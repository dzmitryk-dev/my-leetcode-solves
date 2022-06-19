package interview.sorting_and_search

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MergeSortedArrayTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val inputArray = testData.left.copyOf()
        merge(inputArray, testData.m, testData.right, testData.n)
        Assertions.assertArrayEquals(
            testData.expected,
            inputArray,
            "merge for ${testData.left.contentToString()}, should be ${testData.expected.contentToString()} but was $inputArray"
        )
    }

    companion object {

        data class TestData(
            val left: IntArray,
            val m: Int,
            val right: IntArray,
            val n: Int,
            val expected: IntArray
        ) {
            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as TestData

                if (!left.contentEquals(other.left)) return false
                if (m != other.m) return false
                if (!right.contentEquals(other.right)) return false
                if (n != other.n) return false
                if (!expected.contentEquals(other.expected)) return false

                return true
            }

            override fun hashCode(): Int {
                var result = left.contentHashCode()
                result = 31 * result + m
                result = 31 * result + right.contentHashCode()
                result = 31 * result + n
                result = 31 * result + expected.contentHashCode()
                return result
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(intArrayOf(1,2,3,0,0,0), m = 3, intArrayOf(2, 5, 6), n = 3, intArrayOf(1,2,2,3,5,6)),
            TestData(intArrayOf(1), m = 1, intArrayOf(), n = 0, intArrayOf(1)),
            TestData(intArrayOf(0), m = 0, intArrayOf(1), n = 1, intArrayOf(1)),
            TestData(intArrayOf(1,2,4,7,0,0,0), m = 4, intArrayOf(2, 5, 6), n = 3, intArrayOf(1,2,2,4,5,6,7)),
        )
    }
}