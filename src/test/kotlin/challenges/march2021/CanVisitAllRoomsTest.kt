package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import print

class CanVisitAllRoomsTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = canVisitAllRooms(testData.rooms)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "canVisitAllRooms for ${testData.rooms.print()},should be ${testData.expected} but was $actual"
        )
    }

    companion object {

        data class TestData(
            val rooms: List<List<Int>>,
            val expected: Boolean
        ) {
            override fun toString(): String = "${rooms.print()}, $expected"
        }

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(listOf(listOf(1), listOf(2), listOf(3), listOf()), true),
            TestData(listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0)), false),
        )
    }
}