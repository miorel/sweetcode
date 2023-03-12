function lengthOfLongestSubstring(s: string): number {
  let res = 0;

  const lastIndex = new Map<string, number>();
  let start = 0;
  for (let end = 0; end < s.length; ++end) {
    const c = s[end];
    start = Math.max(start, (lastIndex.get(c) ?? -1) + 1);
    lastIndex.set(c, end);
    res = Math.max(res, end - start + 1);
  }

  return res;
}
