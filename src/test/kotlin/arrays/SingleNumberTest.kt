package arrays

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SingleNumberTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: Pair<IntArray, Int>) {
        val data = testData.first
        val expected = testData.second
        val actual = singleNumber(data)
        Assertions.assertEquals(
            expected,
            actual,
            "singleNumber for ${data.joinToString(",", "[", "]")} should be $expected"
        )
    }

    companion object {
        @JvmStatic
        fun provideTestData() = listOf(
            intArrayOf(2,2,1) to 1,
            intArrayOf(4,1,2,1,2) to 4,
            intArrayOf(1) to 1,
        )
    }
}