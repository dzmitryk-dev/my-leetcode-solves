package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class MaxAreaTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = maxArea(testData.height)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "numberOfSteps for ${testData.height.print()} should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val height: IntArray,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7), 49),
            TestData(intArrayOf(1, 1) , 1),
            TestData(intArrayOf(4, 3, 2, 1, 4), 16),
            TestData(intArrayOf(1, 2, 1), 2),
        )
    }
}