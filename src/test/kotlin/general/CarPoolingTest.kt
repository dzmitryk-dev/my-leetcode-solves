package general

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CarPoolingTest {

    @ParameterizedTest
    @MethodSource("provideTestCase")
    fun test(case: TestCase) {
        val actual = carPooling(case.inputTrips, case.inputCapacity)
        assertEquals(case.expected, actual, "for case = ($case) actual result was $actual")
    }

    companion object {

        data class TestCase(
            val inputTrips: Array<IntArray>,
            val inputCapacity: Int,
            val expected: Boolean
        ) {
            override fun toString(): String {
                return "inputTrips = ${inputTrips.contentDeepToString()}, inputCapacity = $inputCapacity, expected = $expected"
            }
        }

        @JvmStatic
        fun provideTestCase() = listOf(
            /*
            Example 1:
            Input: trips = [[2,1,5],[3,3,7]], capacity = 4
            Output: false
            */
            TestCase(
                arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)),
                4,
                false
            ),
            /*
            Example 2:
            Input: trips = [[2,1,5],[3,3,7]], capacity = 5
            Output: true
             */
            TestCase(
                arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)),
                5,
                true
            ),
            /*
            Input: trips = [[2,2,6],[2,4,7],[8,6,7]], capacity = 11
            Output: true
             */
            TestCase(
                arrayOf(intArrayOf(2, 2, 6), intArrayOf(2, 4, 7), intArrayOf(8, 6, 7)),
                11,
                true
            ),
        )
    }
}