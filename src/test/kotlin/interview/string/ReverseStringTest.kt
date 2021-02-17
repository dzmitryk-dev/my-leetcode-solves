package interview.string

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print
import interview.strings.reverseString

class ReverseStringTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val data = testData.input1.clone()
        reverseString(data)
        Assertions.assertArrayEquals(
            testData.expected,
            data,
            "reverseString for ${testData.input1.print()}, should be ${testData.expected.print()} but was ${data.print()}"
        )
    }

    companion object {

        data class TestData(
            val input1: CharArray,
            val expected: CharArray
        ) {
            override fun toString(): String {
                return "${input1.print()} ${expected.print()}"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(charArrayOf('h','e','l','l','o'), charArrayOf('o','l','l','e','h')),
            TestData(charArrayOf('H','a','n','n','a','h'), charArrayOf('h','a','n','n','a','H')),
        )
    }
}