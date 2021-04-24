package general

/**
 * https://leetcode.com/problems/longest-string-chain/
 */
fun longestStrChain(words: Array<String>): Int {
    words.sortBy { it.length }
    val preparedWords = words
        .groupBy { it.length }
        .mapValues { (_,value) -> value.toSet() }

    val sizes = preparedWords.keys.sortedDescending()
    var maxSize = 0
    for (size in sizes) {
        if (maxSize > size) break
        val count = findSequence(preparedWords, preparedWords[size] ?: emptySet())
        if (count == sizes.size) {
            return count
        }
        if (count > maxSize) {
            maxSize = count
        }
    }
    return maxSize
}

private fun findSequence(
    words: Map<Int, Set<String>?>,
    candidates: Set<String>,
    currentMaxSize: Int = 0
): Int {
    if (candidates.isEmpty()) return currentMaxSize
    val newLenght = candidates.first().length - 1
    if (newLenght == 0) return currentMaxSize + 1
    val wordsOfNewLenght = words[newLenght] ?: return currentMaxSize + 1
    val newCandidates = mutableSetOf<String>()
    for (candidate in candidates) {
        newCandidates.addAll(findPredecessors(candidate, wordsOfNewLenght))
    }
    return findSequence(words, newCandidates, currentMaxSize + 1)
}

private fun findPredecessors(
    word: String,
    candidates: Set<String>
): Set<String> {
    val array = word.toCharArray()
    val result = mutableSetOf<String>()
    for (i in 0..array.lastIndex) {
        val newCandidate = array.filterIndexed { index, _ -> index != i }.joinToString(separator = "")
        if (candidates.contains(newCandidate)) {
            result.add(newCandidate)
        }
    }
    return result
}

