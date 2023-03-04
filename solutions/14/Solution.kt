class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val first = strs.first() ?: ""
        val others = strs.asSequence().drop(1)

        for (i in first.indices) {
          if (others.any { i >= it.length || it[i] != first[i] }) {
            return first.take(i)
          }
        }

        return first
    }
}
