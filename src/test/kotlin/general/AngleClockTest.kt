package general

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class AngleClockTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = angleClock(testData.hour, testData.minutes)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "angleClock for ${testData.hour}, ${testData.minutes} should be ${testData.expected} but wa $actual"
        )
    }

    companion object {

        data class TestData(
            val hour: Int,
            val minutes: Int,
            val expected: Double
        )

        @JvmStatic
        fun provideTestData() = listOf(
            // Example 1:
            // Input: hour = 12, minutes = 30
            // Output: 165
            TestData(12, 30, 165.0),
            // Example 2:
            // Input: hour = 3, minutes = 30
            // Output: 75
            TestData(3, 30, 75.0),
            // Example 3
            // Input: hour = 3, minutes = 15
            // Output: 7.5
            TestData(3, 15, 7.5),
            // Example 4
            // Input: hour = 4, minutes = 50
            // Output: 155
            TestData(4, 50, 155.0),
            // Example 5
            // Input: hour = 12, minutes = 0
            // Output: 0
            TestData(12, 0, 0.0),
            TestData(1, 57, 76.5),
        )
    }
}