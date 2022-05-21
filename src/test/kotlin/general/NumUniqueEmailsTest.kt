package general

import numUniqueEmails
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NumUniqueEmailsTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = numUniqueEmails(testData.emails)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "numUniqueEmails for ${testData.emails} should be ${testData.expected} but wa $actual"
        )
    }

    companion object {

        data class TestData(
            val emails: Array<String>,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(arrayOf("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"), 2),
        )
    }
}