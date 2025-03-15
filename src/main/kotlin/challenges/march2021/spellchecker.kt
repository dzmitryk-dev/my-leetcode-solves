package challenges.march2021

import java.util.*

/*
 https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3681/
*/

/**
 * 1 <= wordlist.length <= 5000
 * 1 <= queries.length <= 5000
 * 1 <= wordlist[i].length <= 7
 * 1 <= queries[i].length <= 7
 */
fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
    //Preparation
    val wordset = wordlist.toSet()
    val caseMap = wordlist.groupBy { word -> word.lowercase(Locale.getDefault()) }
    val vowelsMap = wordlist.groupBy { word ->
        word.lowercase(Locale.getDefault()).replaceVowels()
    }

    return queries.map { word ->
        if (wordset.contains(word)) {
            word
        } else {
            val wordLowerCase = word.lowercase(Locale.getDefault())
            caseMap[wordLowerCase]?.first() ?: vowelsMap[wordLowerCase.replaceVowels()]?.first() ?: ""
        }
    }.toTypedArray()
}

private val vowels = charArrayOf('a', 'e', 'i', 'o', 'u')

private fun Char.isVowel(): Boolean = this in vowels

private fun String.replaceVowels(): String =
    this.map { l ->
        if (l in vowels) {
            '*'
        } else {
            l
        }
    }.toString()