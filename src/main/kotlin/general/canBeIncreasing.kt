package general

/**
 * https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
 */
//fun canBeIncreasing(nums: IntArray): Boolean {
//    for (indexToIgnore in nums.indices) {
//        if (nums.filterIndexed { index, _ -> index != indexToIgnore }.isSorted()) {
//            return true
//        }
//    }
//    return false
//}

private fun List<Int>.isSorted(): Boolean {
    var previous = first()
    for (index in 1 until size) {
        if (this[index] > previous) {
            previous = this[index]
            continue
        }
        return false
    }
    return true
}

//fun canBeIncreasing(nums: IntArray): Boolean {
//    indexToIgnore@ for (indexToIgnore in nums.indices) {
//        var previous = if (indexToIgnore == 0) {
//            nums[1]
//        } else {
//            nums.first()
//        }
//        val firstIndexToIterate = if (indexToIgnore == 0) {
//            2
//        } else {
//            1
//        }
//        for (index in firstIndexToIterate until nums.size) {
//            if (index == indexToIgnore) {
//                continue
//            }
//            if (nums[index] > previous) {
//                previous = nums[index]
//                continue
//            }
//            continue@indexToIgnore
//        }
//        return true
//    }
//    return false
//}

fun canBeIncreasing(nums: IntArray): Boolean {
    if (nums.size <= 2) return true
    var prevMax = nums.first()
    var currentMax = prevMax
    var ignored = false
    for (i in 1 until nums.size) {
        val v = nums[i]
        if (v > currentMax) {
            prevMax = currentMax
            currentMax = v
            continue
        }
        if (!ignored) {
            ignored = true
            if (i == 1) {
                prevMax = v
                currentMax = v
            }
            if (v > prevMax) {
                currentMax = v
            }
            continue
        }
        return false
    }
    return true
}