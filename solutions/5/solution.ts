function longestPalindrome(s: string): string {
  let res: { hi: number; lo: number } | null = null;

  const n = s.length;
  for (const delta of [0, 1]) {
    for (let mid = 0; mid < n; ++mid) {
      let lo = mid;
      let hi = mid + delta;
      while (lo >= 0 && hi < n && s[lo] === s[hi]) {
        ++hi;
        --lo;
      }

      if (res == null || res.hi - res.lo < hi - lo) {
        res = { hi, lo };
      }
    }
  }

  return res == null ? "" : s.slice(res.lo + 1, res.hi);
}
