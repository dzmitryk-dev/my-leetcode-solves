package general

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class FindWinnersTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testCase: TestCase) {
        val actual = findWinners(testCase.input)
        Assertions.assertIterableEquals(
            testCase.expected,
            actual,
            "findWinners for ${testCase.input.contentDeepToString()}, should be ${testCase.expected.print()} but wa ${actual.print()}"
        )
    }


    companion object {

        data class TestCase(
            val input: Array<IntArray>,
            val expected: List<List<Int>>
        ) {
            override fun toString(): String {
                return "input = ${input.contentDeepToString()}; expected = ${expected.print()}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as TestCase

                if (!input.contentDeepEquals(other.input)) return false
                if (expected != other.expected) return false

                return true
            }

            override fun hashCode(): Int {
                var result = input.contentDeepHashCode()
                result = 31 * result + expected.hashCode()
                return result
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestCase(
                arrayOf(
                    intArrayOf(1,3),
                    intArrayOf(2,3),
                    intArrayOf(3,6),
                    intArrayOf(5,6),
                    intArrayOf(5,7),
                    intArrayOf(4,5),
                    intArrayOf(4,8),
                    intArrayOf(4,9),
                    intArrayOf(10,4),
                    intArrayOf(10,9)
                ),
                listOf(
                    listOf(1,2,10),
                    listOf(4,5,7,8)
                )
            ),
            TestCase(
                arrayOf(
                    intArrayOf(2,3),
                    intArrayOf(1,3),
                    intArrayOf(5,4),
                    intArrayOf(6,4)
                ),
                listOf(
                    listOf(1,2,5,6),
                    emptyList()
                )
            )
        )
    }
}