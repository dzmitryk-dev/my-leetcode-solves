package general

import org.junit.jupiter.api.Assertions.*

class threeSumKtTest {

    companion object {

        data class TestCase(
            val input: IntArray,
            val expected: List<List<Int>>
        )

        @JvmStatic
        fun provideTestCases() = emptyList<TestCase>()
    }


}