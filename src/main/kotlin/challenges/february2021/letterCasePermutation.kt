package challenges.february2021

fun letterCasePermutation(S: String): List<String> {
    val chars = S.toCharArray()
    val possibilities = mutableListOf(chars)
    permutate(0, possibilities)
    return possibilities.map { String(it) }
}


tailrec fun permutate(index: Int, strs: MutableList<CharArray>) {
    val input = strs[0]
    if (index > input.lastIndex) return
    if (input[index].isLetter()) {
        strs.map {
            val newArray = it.clone()
            val character = it[index]
            newArray[index] = if (character.isLowerCase()) {
                character.toUpperCase()
            } else {
                character.toLowerCase()
            }
            newArray
        }.let {
            strs.addAll(it)
        }
    }
    permutate(index + 1, strs)
}