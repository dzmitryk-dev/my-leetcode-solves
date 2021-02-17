package interview.arrays

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PlusOneTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val data = testData.data
        val expected = testData.expected
        val actual = plusOne(data)
        Assertions.assertArrayEquals(
            expected,
            actual,
            "plusOne for ${data.joinToString(",", "[", "]")} should be $expected"
        )
    }

    companion object {

        data class TestData(
            val data: IntArray,
            val expected: IntArray
        ) {
            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as TestData

                if (!data.contentEquals(other.data)) return false
                if (!expected.contentEquals(other.expected)) return false

                return true
            }

            override fun hashCode(): Int {
                var result = data.contentHashCode()
                result = 31 * result + expected.contentHashCode()
                return result
            }

            override fun toString(): String {
                return "${data.joinToString(",", "[", "]")}, ${expected.joinToString(",", "[", "]")}"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(intArrayOf(1,2,3), intArrayOf(1,2,4)),
            TestData(intArrayOf(4,3,2,1),intArrayOf(4,3,2,2)),
            TestData(intArrayOf(0), intArrayOf(1)),
            TestData(intArrayOf(9, 9), intArrayOf(1, 0, 0))
        )
    }
}