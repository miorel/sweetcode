import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    traverse(s, 0, new Stack<>(), res);
    return res;
  }

  private static void traverse(String s, int start, Stack<String> cur, List<List<String>> res) {
    if (start == s.length()) {
      res.add(new ArrayList<>(cur));
      return;
    }

    for (int end = start; end < s.length(); ++end) {
      if (!isPalindrome(s, start, end)) {
        continue;
      }
      cur.push(s.substring(start, end + 1));
      traverse(s, end + 1, cur, res);
      cur.pop();
    }
  }

  private static boolean isPalindrome(String s, int lo, int hi) {
    while (lo < hi) {
      if (s.charAt(lo++) != s.charAt(hi--)) {
        return false;
      }
    }
    return true;
  }
}