package general.firstbadversion

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class FirstBadVersionTest {
    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testCase: TestCase) {
        val s = Solution().apply {
            bad = testCase.bad
        }
        Assertions.assertEquals(testCase.bad, s.firstBadVersion(testCase.n))
    }

    companion object {
        data class TestCase(val n: Int, val bad: Int)

        @JvmStatic
        fun provideTestData() = listOf(
            TestCase(n = 5, bad = 4),
            TestCase(n = 1, bad = 1),
            TestCase(n = 2, bad = 1),
            TestCase(n = 2, bad = 2)
        )
    }
}