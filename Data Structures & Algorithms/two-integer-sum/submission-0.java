class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
            int remainNum = target - nums[i];

            if(map.containsKey(remainNum)){
                return new int[]{map.get(remainNum),i};
            }

            map.put(nums[i],i);
        }

        return new int[]{-1,-1};
    }
}
