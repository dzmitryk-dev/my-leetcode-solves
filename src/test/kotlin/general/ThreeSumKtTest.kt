package general

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ThreeSumKtTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun test(testCase: TestCase) {
        val actual = threeSum(testCase.input)
        assertEquals(
            testCase.expected.toSet(), actual.toSet(),
            "For threeSum(${arrayOf(testCase.input).contentDeepToString()}) expected ${testCase.expected} but was $actual"
        )
    }

    companion object {

        data class TestCase(
            val input: IntArray,
            val expected: List<List<Int>>
        )

        @JvmStatic
        fun provideTestCases() = listOf(
            TestCase(
                input = intArrayOf(-1, 0, 1, 2, -1, -4),
                expected = listOf(listOf(-1, -1, 2), listOf(-1, 0, 1))
            ),
            TestCase(
                input = intArrayOf(0, 1, 1),
                expected = emptyList()
            ),
            TestCase(
                input = intArrayOf(0, 0, 0),
                expected = listOf(listOf(0, 0, 0))
            ),
            TestCase(
                input = intArrayOf(13,11,-3,-1,6,-11,-11,-12,1,-11,-10,12,3,-11,0,9,3,-13,-10,-2,6,14,9,-4,-9,-3,-9,-15,-10,4,-7,10,1,-3,-5,14,1,-9,-13,-12,-4,-8,7,6,-4,-8,0,6,-14,-3,-11,0,-4,13,3,2,-13,9,2,14,-1,10,10,7,14,12,6,0,-12,0,-5,-9,7,-13,12,10,-13,-3,1,10,9,5,-5,12,-5,13,-1,-11,0,-14,-11,6,3,14,-2,2,11,11,10,6,-4,12,13,10,7,10,5,1),
                expected = listOf(
                    listOf(-15,1,14),
                    listOf(-15,2,13),
                    listOf(-15,3,12),
                    listOf(-15,4,11),
                    listOf(-15,5,10),
                    listOf(-15,6,9),
                    listOf(-14,0,14),
                    listOf(-14,1,13),
                    listOf(-14,2,12),
                    listOf(-14,3,11),
                    listOf(-14,4,10),
                    listOf(-14,5,9),
                    listOf(-14,7,7),
                    listOf(-13,-1,14),
                    listOf(-13,0,13),
                    listOf(-13,1,12),
                    listOf(-13,2,11),
                    listOf(-13,3,10),
                    listOf(-13,4,9),
                    listOf(-13,6,7),
                    listOf(-12,-2,14),
                    listOf(-12,-1,13),
                    listOf(-12,0,12),
                    listOf(-12,1,11),
                    listOf(-12,2,10),
                    listOf(-12,3,9),
                    listOf(-12,5,7),
                    listOf(-12,6,6),
                    listOf(-11,-3,14),
                    listOf(-11,-2,13),
                    listOf(-11,-1,12),
                    listOf(-11,0,11),
                    listOf(-11,1,10),
                    listOf(-11,2,9),
                    listOf(-11,4,7),
                    listOf(-11,5,6),
                    listOf(-10,-4,14),
                    listOf(-10,-3,13),
                    listOf(-10,-2,12),
                    listOf(-10,-1,11),
                    listOf(-10,0,10),
                    listOf(-10,1,9),
                    listOf(-10,3,7),
                    listOf(-10,4,6),
                    listOf(-10,5,5),
                    listOf(-9,-5,14),
                    listOf(-9,-4,13),
                    listOf(-9,-3,12),
                    listOf(-9,-2,11),
                    listOf(-9,-1,10),
                    listOf(-9,0,9),
                    listOf(-9,2,7),
                    listOf(-9,3,6),
                    listOf(-9,4,5),listOf(-8,-5,13),listOf(-8,-4,12),listOf(-8,-3,11),listOf(-8,-2,10),listOf(-8,-1,9),listOf(-8,1,7),listOf(-8,2,6),listOf(-8,3,5),listOf(-7,-5,12),listOf(-7,-4,11),listOf(-7,-3,10),listOf(-7,-2,9),listOf(-7,0,7),listOf(-7,1,6),listOf(-7,2,5),listOf(-7,3,4),listOf(-5,-5,10),listOf(-5,-4,9),listOf(-5,-2,7),listOf(-5,-1,6),listOf(-5,0,5),listOf(-5,1,4),listOf(-5,2,3),listOf(-4,-3,7),listOf(-4,-2,6),listOf(-4,-1,5),listOf(-4,0,4),listOf(-4,1,3),listOf(-4,2,2),listOf(-3,-3,6),listOf(-3,-2,5),listOf(-3,-1,4),listOf(-3,0,3),listOf(-3,1,2),listOf(-2,-2,4),listOf(-2,-1,3),listOf(-2,0,2),listOf(-2,1,1),listOf(-1,-1,2),listOf(-1,0,1),listOf(0,0,0)
                )
            )
        )
    }


}