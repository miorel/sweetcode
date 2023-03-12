class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> prevs;

        for (int i = 0; i < nums.size(); ++i) {
            auto counterpart = prevs.find(target - nums[i]);
            if (counterpart != prevs.end()) {
                return {counterpart->second, i};
            }
            prevs[nums[i]] = i;
        }

        throw logic_error("Problem statement promised a solution!");
    }
};
