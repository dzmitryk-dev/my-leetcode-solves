package interview.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PowerOfThreeTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = isPowerOfThree(testData.number)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "isPowerOfThree for ${testData.number}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val number: Int,
            val expected: Boolean
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(27, true),
            TestData(0, false),
            TestData(9, true),
            TestData(45, false),
            TestData(1, true),
        )
    }
}