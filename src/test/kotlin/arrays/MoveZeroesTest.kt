package arrays

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MoveZeroesTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val data = testData.data.clone()
        val expected = testData.expected
        moveZeroes(data)
        Assertions.assertArrayEquals(
            expected,
            data,
            "moveZeroes for ${testData.data.joinToString(",", "[", "]")} should be $expected but was" +
                    "${data.joinToString(",", "[", "]")} instead"
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
            TestData(intArrayOf(0,1,0,3,12), intArrayOf(1,3,12,0,0)),
            TestData(intArrayOf(0,1,0,0,3,12), intArrayOf(1,3,12,0,0,0)),
            TestData(intArrayOf(1,0), intArrayOf(1,0))
        )
    }
}