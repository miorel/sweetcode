private val NUMERALS = mapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000
)

class Solution {
    fun romanToInt(s: String): Int = s.indices.sumBy { NUMERALS[s[it]]!! * (
        if (it == s.lastIndex || NUMERALS[s[it]]!! >= NUMERALS[s[it + 1]]!!) { 1 } else { -1 }
    ) }
}
