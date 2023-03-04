private fun String.isPalindrome(): Boolean {
  var lo = 0
  var hi = this.lastIndex
  while (lo < hi) {
    if (this[lo++] != this[hi--]) {
      return false
    }
  }
  return true
}

class Solution {
  fun isPalindrome(x: Int): Boolean = x.toString().isPalindrome()
}
