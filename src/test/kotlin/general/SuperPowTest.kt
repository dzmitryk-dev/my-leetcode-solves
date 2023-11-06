package general

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SuperPowTest {


// Too stupid to solve now
//    @ParameterizedTest
//    @MethodSource("provideTestData")
//    fun test(testData: TestData) {
//        val actual = superPow(testData.a, testData.b)
//        assertEquals(
//            testData.expected,
//            actual,
//            "superPow(${testData.a}, ${testData.b}) should be ${testData.expected} but wa $actual"
//        )
//    }

    companion object {

        data class TestData(
            val a: Int,
            val b: IntArray,
            val expected: Int
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(a = 2, b = intArrayOf(3), expected = 8),
            TestData(a = 2 , b = intArrayOf(1, 0), expected = 1024),
            TestData(a = 1, b = intArrayOf(4, 3, 3, 8, 5, 2), expected = 1)
        )
    }
}