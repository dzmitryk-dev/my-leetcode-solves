package challenges.february2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class ValidateStackSequencesTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = validateStackSequences(testData.pushed, testData.popped)
        Assertions.assertEquals(
                testData.expected,
                actual,
                "brokenCalc for ${testData.pushed.print()} and ${testData.popped.print()}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
                val pushed: IntArray,
                val popped: IntArray,
                val expected: Boolean
        ) {
            override fun toString(): String =
                "${pushed.print()}, ${popped.print()}, $expected"
        }

        @JvmStatic
        fun provideTestData() = listOf(
            /*
                Example 1:
                Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
                Output: true
                Explanation: We might do the following sequence:
                push(1), push(2), push(3), push(4), pop() -> 4,
                push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
            */
            TestData(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4,5,3,2,1), true),
             /*
                Example 2:
                Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
                Output: false
                Explanation: 1 cannot be popped before 2
              */
            TestData(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4,3,5,1,2), false),
            TestData(intArrayOf(1, 0), intArrayOf(1, 0), true),
            TestData(intArrayOf(2,1,0), intArrayOf(2,1,0), true),
        )
    }
}