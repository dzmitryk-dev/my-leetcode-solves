package challenges.february2021

/**
 * https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3639/
 */

fun isBipartite(graph: Array<IntArray>): Boolean {
    return search(graph, graph[0].toSet(), IntArray(graph.size), false)
}

tailrec fun search(
    graph: Array<IntArray>,
    nodes: Set<Int>,
    visitedNodes: IntArray,
    isOdd: Boolean
): Boolean {
    val nextNodes = nodes
        .onEach { index ->
            val res = visitedNodes[index]
            if (res > 0 && res != isOdd.toInt()) return false
            visitedNodes[index] = isOdd.toInt()
        }.map { index -> graph[index] }
        .onEach { indexes ->
            indexes.map {
                val res = visitedNodes[it]
                if (res > 0 && res != isOdd.not().toInt()) return false
            }
        }
        .flatMap { indexes -> indexes.toList() }
        .filter { index -> visitedNodes[index] == 0 }
        .distinct()
        .toSet()
    if (nextNodes.isEmpty() && !visitedNodes.contains(0)) {
        return true
    }

    return search(
        graph,
        if (nextNodes.isEmpty()) {
            setOf(visitedNodes.indexOfFirst { it == 0 })
        } else {
            nextNodes
        },
        visitedNodes,
        isOdd.not()
    )
}

fun Boolean.toInt(): Int =
    if (this) {
        2
    } else {
        1
    }