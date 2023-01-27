class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var res = 0

        var start = 0
        val lastIndex = HashMap<Char, Int>()
        for ((end, c) in s.withIndex()) {
            start = Math.max(start, lastIndex.getOrDefault(c, -1) + 1)
            lastIndex[c] = end
            res = Math.max(res, end - start + 1)
        }

        return res
    }
}
