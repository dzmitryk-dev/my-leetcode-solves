package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ReorderedPowerOf2Test {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = reorderedPowerOf2(testData.N)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "reorderedPowerOf2 for ${testData.N}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val N: Int,
            val expected: Boolean
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(1, true),
            TestData(10, false),
            TestData(16, true),
            TestData(24, false),
            TestData(46, true),
            TestData(218, true),
            TestData(1521, false)
        )
    }
}