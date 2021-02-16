package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LetterCasePermutationTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = letterCasePermutation(testData.input)
        Assertions.assertTrue(
            { actual.containsAll(testData.expected) && actual.size == testData.expected.size },
            "letterCasePermutation for ${testData.input} " +
                   "should be ${testData.expected.joinToString(",", "[", "]") { it }} " +
                    "but was ${actual.joinToString(",", "[", "]") { it }}"
        )
    }

    companion object {

        data class TestData(
            val input: String,
            val expected: List<String>
        ) {
            override fun toString(): String {
                return "$input ${expected.joinToString(",", "[", "]") { it }}"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            // Example 1:
            // Input: S = "a1b2"
            // Output: ["a1b2","a1B2","A1b2","A1B2"]
            TestData("a1b2", listOf("a1b2","a1B2","A1b2","A1B2")),
            //Example 2:
            // Input: S = "3z4"
            // Output: ["3z4","3Z4"]
            TestData("3z4", listOf("3z4","3Z4")),
            // Example 3:
            // Input: S = "12345"
            // Output: ["12345"]
            TestData("12345", listOf("12345")),
            // Example 4:
            // Input: S = "0"
            // Output: ["0"]
            TestData("0", listOf("0")),
            TestData("C", listOf("c","C"))
        )
    }

}