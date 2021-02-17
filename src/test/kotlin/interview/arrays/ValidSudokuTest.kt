package interview.arrays

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class ValidSudokuTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val board = testData.board
        val expected = testData.result
        val actual = isValidSudoku(board)
        Assertions.assertEquals(
            expected,
            actual,
            "twoSum for ${board.joinToString { it.print() + "\n"}} should be $expected but wa $actual"
        )
    }

    companion object {

        data class TestData(
            val board: Array<CharArray>,
            val result: Boolean,
        ) {

            override fun toString(): String {
                return "${board.joinToString { it.print() + "\n"}} $result"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(
                arrayOf(
                    charArrayOf('5','3','.','.','7','.','.','.','.'),
                    charArrayOf('6','.','.','1','9','5','.','.','.'),
                    charArrayOf('.','9','8','.','.','.','.','6','.'),
                    charArrayOf('4','.','.','8','.','3','.','.','1'),
                    charArrayOf('7','.','.','.','2','.','.','.','6'),
                    charArrayOf('.','6','.','.','.','.','2','8','.'),
                    charArrayOf('.','.','.','4','1','9','.','.','5'),
                    charArrayOf('.','.','.','.','8','.','.','7','9')
                ), true
            ),
            TestData(
                arrayOf(
                    charArrayOf('8','3','.','.','7','.','.','.','.'),
                    charArrayOf('6','.','.','1','9','5','.','.','.'),
                    charArrayOf('.','9','8','.','.','.','.','6','.'),
                    charArrayOf('4','.','.','8','.','3','.','.','1'),
                    charArrayOf('7','.','.','.','2','.','.','.','6'),
                    charArrayOf('.','6','.','.','.','.','2','8','.'),
                    charArrayOf('.','.','.','4','1','9','.','.','5'),
                    charArrayOf('.','.','.','.','8','.','.','7','9')
                ), false
            )
        )
    }
}