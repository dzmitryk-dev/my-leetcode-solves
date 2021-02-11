package challenges.february2021

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class IsAnagramTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = isAnagram(testData.input1, testData.input2)
        assertEquals(
            testData.expected,
            actual,
            "isAnagram for ${testData.input1}, ${testData.input2} should be ${testData.expected}"
        )
    }

    companion object {

        data class TestData(
            val input1: String,
            val input2: String,
            val expected: Boolean
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData("anagram", "nagaram" , true),
            TestData("rat", "car" , false),
            TestData("aacc","ccac", false)
        )
    }
}