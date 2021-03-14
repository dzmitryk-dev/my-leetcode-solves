package interview.string

import interview.strings.firstUniqChar
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class FirstUniqCharTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = firstUniqChar(testData.input)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "firstUniqChar for ${testData.input}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val input: String,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData("leetcode", 0),
            TestData("loveleetcode", 2),
            TestData("", -1),
            TestData("leetcodeleetcode", -1),
        )
    }
}