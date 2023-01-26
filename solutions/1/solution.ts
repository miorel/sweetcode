function twoSum(nums: number[], target: number): [number, number] {
  const prevs = new Map<number, number>();

  for (let i = 0; i < nums.length; ++i) {
    const indexOfCounterPart = prevs.get(target - nums[i]);
    if (indexOfCounterPart != null) {
      return [i, indexOfCounterPart];
    }

    prevs.set(i, nums[i]);
  }

  throw new Error("no solution");
}
