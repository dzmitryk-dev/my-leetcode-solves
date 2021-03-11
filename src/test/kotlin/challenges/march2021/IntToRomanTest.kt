package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class IntToRomanTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = intToRoman(testData.number)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "intToRoman for ${testData.number}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val number: Int,
            val expected: String
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(3, "III"),
            TestData(4, "IV"),
            TestData(9, "IX"),
            TestData(58, "LVIII"),
            TestData(1994, "MCMXCIV"),
        )
    }
}