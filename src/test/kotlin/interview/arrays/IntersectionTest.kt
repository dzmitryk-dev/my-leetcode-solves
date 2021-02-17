package interview.arrays

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class IntersectionTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val expected = testData.expected
        val actual = intersect(testData.num1, testData.num2)

        Assertions.assertArrayEquals(
            expected.sortedArray(),
            actual.sortedArray(),
            "intersect for ${testData.num1.print()} and ${testData.num2.print()} should be ${expected.print()} but " +
                    "was ${actual.print()} instead"
        )
    }

    companion object {

        data class TestData(
            val num1: IntArray,
            val num2: IntArray,
            val expected: IntArray
        ) {

            override fun toString(): String {
                return "num1 = ${num1.print()}, num2 = ${num2.print()}, expected = ${expected.print()} "
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(intArrayOf(1,2,2,1), intArrayOf(2,2), intArrayOf(2,2)),
            TestData(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4), intArrayOf(4,9)),
            TestData(intArrayOf(4,9,5,4), intArrayOf(9,4,9,8,4), intArrayOf(4,9,4))
        )
    }
}