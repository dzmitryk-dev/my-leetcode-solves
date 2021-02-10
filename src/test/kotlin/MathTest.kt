import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MathTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val n = testData.n
        val expected = testData.expected
        val actual = pow2(n)
        Assertions.assertEquals(
            expected,
            actual,
            "pow2 for $n should be $expected"
        )
    }

    companion object {

        data class TestData(
            val n: Int,
            val expected: Int
        )
        @JvmStatic
        fun provideTestData() = listOf(
            TestData(0, 1),
            TestData(1, 2),
            TestData(2, 4),
            TestData(3, 8),
            TestData(4, 16),
            TestData(5, 32),
            TestData(6, 64),
            TestData(7, 128),
            TestData(8, 256)
        )
    }
}