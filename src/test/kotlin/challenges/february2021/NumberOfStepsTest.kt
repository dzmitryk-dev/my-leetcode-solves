package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NumberOfStepsTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = numberOfSteps(testData.num)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "numberOfSteps for ${testData.num} should be ${testData.expected}"
        )
    }

    companion object {

        data class TestData(
            val num: Int,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(14, 6),
            TestData(8 , 4),
            TestData(123, 12),
            TestData(0, 0)
        )
    }
}