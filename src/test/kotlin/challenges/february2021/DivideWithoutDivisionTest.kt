package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class DivideWithoutDivisionTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val result = divide(testData.dividend, testData.divisor)
        Assertions.assertEquals(
            testData.result,
            result,
            "divide for ${testData.dividend} and ${testData.divisor}, should be ${testData.result} but was $result"
        )
    }

    companion object {

        data class TestData(
            val dividend: Int,
            val divisor: Int,
            val result: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
//            Example 1:
//            Input: dividend = 10, divisor = 3
//            Output: 3
//            Explanation: 10/3 = truncate(3.33333..) = 3.
             TestData(10, 3, 3),
//            Example 2:
//            Input: dividend = 7, divisor = -3
//            Output: -2
//            Explanation: 7/-3 = truncate(-2.33333..) = -2.
            TestData(7, -3, -2),
//            Example 3:
//            Input: dividend = 0, divisor = 1
//            Output: 0
            TestData(0, 1, 0),
//            Example 4:
//            Input: dividend = 1, divisor = 1
//            Output: 1
            TestData(1, 1, 1),
            TestData(1, 2, 0),
            TestData(-2147483648, -1, 2147483647),
            TestData(-2147483648, 2, -1073741824),
            TestData(1004958205, -2137325331, 0),
            TestData(-2147483648, - 3, 715827882),
            TestData(-2147483648, -2147483648, 1),
        )
    }
}