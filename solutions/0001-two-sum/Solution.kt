class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val prevs = HashMap<Int, Int>()

        for ((index, x) in nums.withIndex()) {
            val indexOfCounterpart = prevs[target - x]
            if (indexOfCounterpart != null) {
                return intArrayOf(index, indexOfCounterpart)
            }

            prevs[x] = index
        }

        throw RuntimeException("no solution")
    }
}
