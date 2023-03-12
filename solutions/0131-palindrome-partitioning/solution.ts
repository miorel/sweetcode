function isPalindrome(s: string, lo: number, hi: number): boolean {
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
function partition(s: string): string[][] {
  const res: string[][] = [];

  const cur: string[] = [];
  const traverse = (start: number) => {
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
