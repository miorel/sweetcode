private fun Long.reversed(base: Long = 10L): Long {
  var res = 0L

  var n = this
  while (n != 0L) {
    res *= base
    res += n % base
    n /= base
  }

  return res
}

private fun Long.isPalindrome(): Boolean = this >= 0L && this == this.reversed()

class Solution {
  fun isPalindrome(x: Int): Boolean = x.toLong().isPalindrome()
}
