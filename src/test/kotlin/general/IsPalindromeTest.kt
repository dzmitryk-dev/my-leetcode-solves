package general

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class IsPalindromeTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = isPalindrome(testData.x)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "isPalindrome for ${testData.x} should be ${testData.expected} but wa $actual"
        )
    }

    companion object {

        data class TestData(
            val x: Int,
            val expected: Boolean
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(121, true),
            TestData(-121, false),
            TestData(10, false),
            TestData(-101, false),
            TestData(2552, true),
            TestData(0, true)
        )
    }
}