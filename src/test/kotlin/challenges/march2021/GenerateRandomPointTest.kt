package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.random.Random

class GenerateRandomPointTest {

    @ParameterizedTest
    @MethodSource("provideTestData1")
    fun testCase1(result: DoubleArray) {
        Assertions.assertTrue {
            val (x, y) = result
            -1.0 < x && x < 1.0 && -1.0 < y && y < 1.0
        }
    }

    @ParameterizedTest
    @MethodSource("provideTestData2")
    fun testCase2(result: DoubleArray) {
        Assertions.assertTrue {
            val (x, y) = result
            7.89012 - 1.23456 < x &&
            x < 7.89012 + 1.23456 &&
            34567.89012 - 1.23456 < y &&
            y < 34567.89012 + 1.23456
        }
    }

    @ParameterizedTest
    @MethodSource("provideTestData3")
    fun testCase3(result: DoubleArray) {
        Assertions.assertTrue {
            val (x, y) = result
            -73839.1 - 0.01 < x &&
                    x < -73839.1 + 0.01 &&
                    -3289891.3 - 0.01 < y &&
                    y < -3289891.3 + 0.01
        }
    }

    companion object {

        @JvmStatic
        fun provideTestData1() = sequence {
            val solution = Solution(1.0, 0.0, 0.0)
            val size = Random(System.currentTimeMillis()).nextInt(1, 100)
            repeat(size) {
                yield(solution.randPoint())
            }
        }.iterator()

        @JvmStatic
        fun provideTestData2() = sequence {
            val solution = Solution(1.23456,7.89012,34567.89012)
            val size = Random(System.currentTimeMillis()).nextInt(1, 100)
            repeat(size) {
                yield(solution.randPoint())
            }
        }.iterator()

        @JvmStatic
        fun provideTestData3() = sequence {
            val solution = Solution( 0.01,-73839.1,-3289891.3)
            val size = Random(System.currentTimeMillis()).nextInt(1, 100)
            repeat(size) {
                yield(solution.randPoint())
            }
        }.iterator()
    }
}