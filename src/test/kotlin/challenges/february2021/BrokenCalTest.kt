package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class BrokenCalTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = brokenCalc(testData.X, testData.Y)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "brokenCalc for ${testData.X} and ${testData.Y}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val X: Int,
            val Y: Int,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
//            Example 1:
//            Input: X = 2, Y = 3
//            Output: 2
//            Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
            TestData(2, 3, 2),
//            Example 2:
//            Input: X = 5, Y = 8
//            Output: 2
//            Explanation: Use decrement and then double {5 -> 4 -> 8}.
            TestData(5, 8, 2),
//            Example 3:
//            Input: X = 3, Y = 10
//            Output: 3
//            Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
            TestData(3, 10, 3),
//            Example 4:
//            Input: X = 1024, Y = 1
//            Output: 1023
//            Explanation: Use decrement operations 1023 times.
            TestData(1024, 1, 1023),
            // Input: X = 1, Y = 1000000000
            // Output: 39
            TestData(1, 1000000000, 39),
            // Input X = 1, Y = 1
            // Output: 0
            TestData(1, 1, 0)
        )
    }
}