package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class SpellCheckerTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = spellchecker(testData.wordlist.toTypedArray(), testData.queries.toTypedArray())
        Assertions.assertArrayEquals(
            testData.expected.toTypedArray(),
            actual,
            "coinChange for ${testData.wordlist}, ${testData.queries} should be ${testData.expected} but was ${actual.print()}"
        )
    }

    companion object {

        data class TestData(
            val wordlist: List<String>,
            val queries: List<String>,
            val expected: List<String>
        )

        @JvmStatic
        fun provideTestData() = listOf(
            // Input: wordlist = ["KiTe","kite","hare","Hare"],
            //        queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
            // Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
            TestData(
                wordlist = listOf("KiTe","kite","hare","Hare"),
                queries = listOf("kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"),
                expected = listOf("kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe")
            )
        )
    }


}