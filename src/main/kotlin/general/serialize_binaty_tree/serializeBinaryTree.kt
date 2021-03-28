package general.serialize_binaty_tree

import structures.TreeNode

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */

class Codec {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        return serealizeToString(root).toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        return deserealizeFromString(data.split(';').map { it.toIntOrNull() }.iterator())
    }

    private fun serealizeToString(root: TreeNode?, acc: StringBuilder = StringBuilder()): StringBuilder {
        return if (root == null) {
            acc.append("null").append(";")
        } else {
            acc.append(root.`val`).append(";")
            serealizeToString(root.left, acc)
            serealizeToString(root.right, acc)
        }
    }

    private fun deserealizeFromString(iterator: Iterator<Int?>): TreeNode? {
        return if (iterator.hasNext()) {
            val element = iterator.next()
            return if (element == null) {
                null
            } else {
                TreeNode(element).also { node ->
                    node.left = deserealizeFromString(iterator)
                    node.right = deserealizeFromString(iterator)
                }
            }
        } else {
            null
        }
    }
}