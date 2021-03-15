package challenges.march2021

import java.lang.StringBuilder
import java.net.URL
import kotlin.random.Random

/*
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3673/
 */

private const val BASE_URL = "http://tinyurl.com"

private const val ALPHABET = "qwertyuioplkjhgfdsazxcvbnm"

class Codec {

    private val random = Random(System.currentTimeMillis())
    private val encodingMap = mutableMapOf<String, String>()
    private val decodingMap = mutableMapOf<String, String>()

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        val shortSuffix = encodingMap[longUrl] ?:
        random.nextInt(8, 12).let { length ->
            val builder = StringBuilder()
            repeat(length) {
                random.nextInt(0, ALPHABET.lastIndex).let { index ->
                    builder.append(ALPHABET[index])
                }
            }
            builder.toString()
        }.also { shortSuffix ->
            encodingMap[longUrl] = shortSuffix
            decodingMap[shortSuffix] = longUrl
        }

        return "$BASE_URL/$shortSuffix"
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        val shortSuffix = URL(shortUrl).path.substring(1)
        return decodingMap.getOrDefault(shortSuffix, "")
    }
}