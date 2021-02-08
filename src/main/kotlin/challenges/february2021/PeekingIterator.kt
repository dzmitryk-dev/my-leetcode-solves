package challenges.february2021

// Kotlin Iterator reference:
// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/

class PeekingIteratorImpl(
    private val iterator:Iterator<Int>
) : PeekingIterator<Int> {

    private var peeked = false
    private var cachedValue: Int? = null

    override fun peek(): Int {
        return if (peeked) {
            cachedValue!!
        } else {
            cachedValue = iterator.next()
            peeked = true
            cachedValue!!
        }
    }

    override fun next(): Int {
        return if (!peeked) {
            iterator.next()
        } else {
            peeked = false
            val localCachedValue = cachedValue!!
            cachedValue = null
            localCachedValue
        }
    }

    override fun hasNext(): Boolean {
        return if (peeked) {
            true
        } else {
            iterator.hasNext()
        }
    }
}

interface PeekingIterator<T>: Iterator<T> {
    fun peek(): Int

    override fun next(): T

    override fun hasNext(): Boolean
}

/**
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = PeekingIterator(arr)
 * var param_1 = obj.next()
 * var param_2 = obj.peek()
 * var param_3 = obj.hasNext()
 */