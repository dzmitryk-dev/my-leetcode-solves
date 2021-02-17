package interview.arrays

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class RotateImageTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val data = testData.data.clone()
        val expected = testData.expected
        rotate(data)
        Assertions.assertArrayEquals(
            expected,
            data,
            "rotate for ${testData.data.joinToString(",", "[", "]") { it.print() }} " +
                    "should be ${expected.joinToString(",", "[", "]") { it.print() }} " +
                    "but was ${data.joinToString(",", "[", "]") { it.print() }} instead"
        )
    }

    companion object {

        data class TestData(
            val data: Array<IntArray>,
            val expected: Array<IntArray>
        ) {
            override fun toString(): String {
                return "input = ${data.joinToString(",", "[", "]") { it.print() }}, " +
                        "expected = ${expected.joinToString(",", "[", "]") { it.print() }}"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            //Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
            //Output: [[7,4,1],[8,5,2],[9,6,3]]
            TestData(
                arrayOf(
                    intArrayOf(1,2,3),
                    intArrayOf(4,5,6),
                    intArrayOf(7,8,9)
                ),
                arrayOf(
                    intArrayOf(7,4,1),
                    intArrayOf(8,5,2),
                    intArrayOf(9,6,3)
                ),
            ),
            // Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
            // Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
            TestData(
                arrayOf(
                    intArrayOf(5,1,9,11),
                    intArrayOf(2,4,8,10),
                    intArrayOf(13,3,6,7),
                    intArrayOf(15,14,12,16),
                ),
                arrayOf(
                    intArrayOf(15,13,2,5),
                    intArrayOf(14,3,4,1),
                    intArrayOf(12,6,8,9),
                    intArrayOf(16,7,10,11),
                )),
            // Input: matrix = [[1]]
            // Output: [[1]]
            TestData(arrayOf(intArrayOf(1)), arrayOf(intArrayOf(1)),),
            // Input: matrix = [[1,2],[3,4]]
            // Output: [[3,1],[4,2]]
            TestData(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 4)
                ),
                arrayOf(
                    intArrayOf(3, 1),
                    intArrayOf(4, 2)
                ),
            )
        )
    }
}