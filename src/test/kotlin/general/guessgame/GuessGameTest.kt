package general.guessgame

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class GuessGameTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testCase: TestCase) {
        val s = Solution().apply {
            pick = testCase.pick
        }
        assertEquals(s.guessNumber(testCase.n), testCase.pick)
    }

    companion object {
        data class TestCase(val n: Int, val pick: Int)

        @JvmStatic
        fun provideTestData() = listOf(
            TestCase(n = 10, pick = 6),
            TestCase(n = 1, pick = 1),
            TestCase(n = 2, pick = 1)
        )
    }
}