package interview.arrays

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class RotateArrayTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val data = testData.data.clone()
        val k = testData.k
        val expected = testData.expected
        rotate(data, k)
        Assertions.assertArrayEquals(
            expected,
            data,
            "rotate for ${testData.data.joinToString(",", "[", "]")} should be ${expected.joinToString(",", "[", "]")} but " +
                    "was ${data.joinToString(",", "[", "]")} instead"
        )
    }

    companion object {

        data class TestData(
            val data: IntArray,
            val k: Int,
            val expected: IntArray
        ) {
            override fun toString(): String {
                return "input = ${data.joinToString(",", "[", "]")}, k = $k, expected = ${expected.joinToString(",", "[", "]")}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as TestData

                if (!data.contentEquals(other.data)) return false
                if (k != other.k) return false
                if (!expected.contentEquals(other.expected)) return false

                return true
            }

            override fun hashCode(): Int {
                var result = data.contentHashCode()
                result = 31 * result + k
                result = 31 * result + expected.contentHashCode()
                return result
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(intArrayOf(1,2,3,4,5,6,7), 3, intArrayOf(5,6,7,1,2,3,4)),
            TestData(intArrayOf(-1,-100,3,99), 2, intArrayOf(3,99,-1,-100)),
            TestData(intArrayOf(1), 0, intArrayOf(1)),
            TestData(intArrayOf(1), 1, intArrayOf(1)),
            TestData(intArrayOf(1,2,3,4,5,6,7), 0, intArrayOf(1,2,3,4,5,6,7)),
            TestData(intArrayOf(1,2,3,4,5,6,7), 1, intArrayOf(7,1,2,3,4,5,6)),
            TestData(intArrayOf(1,2), 3, intArrayOf(2, 1)),
            TestData(intArrayOf(1,2), 2, intArrayOf(1, 2)),
            TestData(intArrayOf(1,2,3,4,5,6), 4, intArrayOf(3,4,5,6,1,2)),
            TestData(intArrayOf(1,2,3,4,5,6, 7), 4, intArrayOf(4,5,6,7,1,2,3)),
            TestData(
                intArrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27),
                38,
                intArrayOf(17,18,19,20,21,22,23,24,25,26,27,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)),
        )
    }
}