private val CLOSES = mapOf(')' to '(', '}' to '{', ']' to '[')

class Solution {
    fun isValid(s: String): Boolean {
        val st = Stack<Char>()

        for (c in s) {
            val counterpart = CLOSES[c]
            if (counterpart == null) {
                st.push(c)
                continue
            }
            if (st.isEmpty() || st.pop() != counterpart) {
                return false
            }
        }

        return st.isEmpty()
    }
}

