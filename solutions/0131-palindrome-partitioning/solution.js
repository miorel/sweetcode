function isPalindrome(s, lo, hi) {
  while (lo < hi) {
    if (s[lo++] !== s[hi--]) {
      return false;
    }
  }
  return true;
}

/**
 * @param {string} s
 * @return {string[][]}
 */
function partition(s) {
  const res = [];

  const cur = [];
  const traverse = (start) => {
    if (start === s.length) {
      res.push([...cur]);
      return;
    }

    for (let end = start; end < s.length; ++end) {
      if (!isPalindrome(s, start, end)) {
        continue;
      }

      cur.push(s.slice(start, end + 1));
      traverse(end + 1);
      cur.pop();
    }
  };

  traverse(0);

  return res;
}
