package general

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CircleandRectangleOverlappingTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun test(testData: TestData) {
        val actual = checkOverlap(
            radius = testData.radius,
            x_center = testData.x_center,
            y_center = testData.y_center,
            x1 = testData.x1,
            y1 = testData.y1,
            x2 = testData.x2,
            y2 = testData.y2)
        Assertions.assertEquals(
            testData.expected,
            actual,
            "checkOverlap for $testData but wa $actual"
        )
    }

    companion object {

        data class TestData(
            val radius: Int,
            val x_center: Int,
            val y_center: Int,
            val x1: Int,
            val y1: Int,
            val x2: Int,
            val y2: Int,
            val expected: Boolean
        )

        @JvmStatic
        fun provideTestData() = listOf(
            TestData(radius = 1, x_center = 0, y_center = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1, expected = true),
            TestData(radius = 1, x_center = 0, y_center = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1, expected = true),
            TestData(radius = 1, x_center = 1, y_center = 1, x1 = -3, y1 = -3, x2 = 3, y2 = 3, expected = true),
            TestData(radius = 1, x_center = 1, y_center = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1, expected = false)
        )
    }
}