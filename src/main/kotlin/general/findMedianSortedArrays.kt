package general

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val mergedSequence = sequence {
        val num1Iterator = ValueIterator(nums1.iterator())
        val num2Iterator = ValueIterator(nums2.iterator())

        while (true) {
            val v1 = num1Iterator.value
            val v2 = num2Iterator.value
            if (v1 != null && v2 != null) {
                if (v1 < v2) {
                    num1Iterator.moveToNext()
                    yield(v1)
                } else {
                    num2Iterator.moveToNext()
                    yield(v2)
                }
            } else if (v1 == null && v2 != null) {
                num2Iterator.moveToNext()
                yield(v2)
            } else if (v1 != null) {
                num1Iterator.moveToNext()
                yield(v1)
            } else {
                break
            }
        }
    }

    val testlist = mergedSequence.toList()

    val fullSize = nums1.size + nums2.size
    return if (fullSize % 2 == 0) {
        (mergedSequence.elementAt(fullSize / 2 - 1)!!.toDouble() + mergedSequence.elementAt(fullSize / 2).toDouble()) / 2
    } else {
        mergedSequence.elementAt(fullSize / 2).toDouble()
    }
}

private class ValueIterator(
    private val parent: IntIterator
) {

    var value: Int? = null
        private set

    init {
        if (parent.hasNext()) {
            value = parent.nextInt()
        }
    }

    fun moveToNext() {
        value = if (parent.hasNext()) {
            parent.nextInt()
        } else {
            null
        }
    }
}