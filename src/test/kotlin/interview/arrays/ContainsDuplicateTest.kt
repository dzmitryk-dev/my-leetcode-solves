package interview.arrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource


class ContainsDuplicateTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: Pair<IntArray, Boolean>) {
        val data = testData.first
        val expected = testData.second
        val actual = containsDuplicate(data)
        assertEquals(expected, actual, "containsDuplicate for ${data.joinToString(",", "[", "]")} should be $expected")
    }

    companion object {
        @JvmStatic
        fun provideTestData() = listOf(
            intArrayOf(1, 2, 3, 1) to true,
            intArrayOf(1, 2, 3, 4) to false,
            intArrayOf(1,1,1,3,3,4,3,2,4,2) to true,
        )
    }
}