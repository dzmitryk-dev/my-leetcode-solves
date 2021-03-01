package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class DistributeCandiesTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = distributeCandies(testData.candiType)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "distributeCandies for ${testData.candiType.print()}, should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val candiType: IntArray,
            val expected: Int
        ) {
            override fun toString(): String {
                return "${candiType.print()}, $expected"
            }
        }

        @JvmStatic
        fun provideTestData() = listOf(
//            Input: candyType = [1,1,2,2,3,3]
//            Output: 3
//            Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.
            TestData(intArrayOf(1,1,2,2,3,3), 3),
//            Input: candyType = [1,1,2,3]
//            Output: 2
//            Explanation: Alice can only eat 4 / 2 = 2 candies. Whether she eats types [1,2], [1,3], or [2,3], she still can only eat 2 different types.
            TestData(intArrayOf(1,1,2,3), 2),
//            Input: candyType = [6,6,6,6]
//            Output: 1
//            Explanation: Alice can only eat 4 / 2 = 2 candies. Even though she can eat 2 candies, she only has 1 type.
            TestData(intArrayOf(6,6,6,6), 1),
        )
    }
}