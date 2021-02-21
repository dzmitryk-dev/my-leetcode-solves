package interview.string

import interview.strings.reverse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ReverseIntegerTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = reverse(testData.input)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "reverseString for ${testData.input}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val input: Int,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
            // Input: x = 123
            // Output: 321
            TestData(123, 321),
            // Input: x = -123
            // Output: -321
            TestData(-123, -321),
            // Input: x = 120
            // Output: 21
            TestData(120, 21),
            // Input: x = 0
            // Output: 0
            TestData(0, 0),
            // Input: X = Int.MIN
            // Output: 0
            TestData(Int.MIN_VALUE, 0),
            // Input: X = Int.MIN
            // Output: 0
            TestData(Int.MAX_VALUE, 0),
        )
    }
}