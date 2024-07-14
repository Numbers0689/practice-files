class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] arr = new int[102];
        for (int i = 0; i < n; i++) {
            arr[nums[i]+1]++;
        }

        for (int i = 1; i < 102; i++) {
            arr[i] += arr[i-1];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = arr[nums[i]];
        }
        return nums;
    }
}