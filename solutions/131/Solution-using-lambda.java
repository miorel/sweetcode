import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

class Bag<T> {
  T object;
}

class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();

    Stack<String> cur = new Stack<>();
    Bag<Consumer<Integer>> traverse = new Bag<>();
    traverse.object = (start) -> {
      if (start == s.length()) {
        res.add(new ArrayList<>(cur));
        return;
      }

      for (int end = start; end < s.length(); ++end) {
        if (!isPalindrome(s, start, end)) {
          continue;
        }

        cur.push(s.substring(start, end + 1));
        traverse.object.accept(end + 1);
        cur.pop();
      }
    };

    traverse.object.accept(0);

    return res;
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