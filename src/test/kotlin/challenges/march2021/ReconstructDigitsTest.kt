package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ReconstructDigitsTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = originalDigits(testData.s)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "originalDigits for ${testData.s}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val s: String,
            val expected: String
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData("owoztneoer", "012"),
            TestData("fviefuro", "45"),
            TestData("zeroonetwothreefourfivesixseveneightnine","0123456789"),
            TestData("zerozero","00"),
        )
    }
}