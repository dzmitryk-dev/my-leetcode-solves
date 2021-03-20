package challenges.march2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UndergroundSystemTest {

    @Test
    fun case1() {
        val undergroundSystem = UndergroundSystem()
        undergroundSystem.checkIn(45, "Leyton", 3)
        undergroundSystem.checkIn(32, "Paradise", 8)
        undergroundSystem.checkIn(27, "Leyton", 10)
        undergroundSystem.checkOut(45, "Waterloo", 15)
        undergroundSystem.checkOut(27, "Waterloo", 20)
        undergroundSystem.checkOut(32, "Cambridge", 22)

        // return 14.00000. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        undergroundSystem.getAverageTime("Paradise", "Cambridge").let {
            Assertions.assertEquals(14.00000, it)
        }

        // return 11.00000. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer
        // with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.00000
        undergroundSystem.getAverageTime("Leyton", "Waterloo").let {

        }

        undergroundSystem.checkIn(10, "Leyton", 24)

        // return 11.00000
        undergroundSystem.getAverageTime("Leyton", "Waterloo").let {
            Assertions.assertEquals(11.00000, it)
        }

        undergroundSystem.checkOut(10, "Waterloo", 38)
        // return 12.00000
        undergroundSystem.getAverageTime("Leyton", "Waterloo").let {
            Assertions.assertEquals(12.00000, it)
        }
    }

    @Test
    fun case2() {
        val undergroundSystem = UndergroundSystem()
        undergroundSystem.checkIn(10, "Leyton", 3)
        undergroundSystem.checkOut(10, "Paradise", 8)
        // return 5.00000
        undergroundSystem.getAverageTime("Leyton", "Paradise").let {
            Assertions.assertEquals(5.00000, it)
        }

        undergroundSystem.checkIn(5, "Leyton", 10)
        undergroundSystem.checkOut(5, "Paradise", 16)
        // return 5.50000
        undergroundSystem.getAverageTime("Leyton", "Paradise").let {
            Assertions.assertEquals(5.50000, it)
        }

        undergroundSystem.checkIn(2, "Leyton", 21)
        undergroundSystem.checkOut(2, "Paradise", 30)
        // return 6.66667
        undergroundSystem.getAverageTime("Leyton", "Paradise").let {
            Assertions.assertEquals(6.66667, it)
        }
    }
}