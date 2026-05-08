class Solution {
    public int[] productExceptSelf(int[] nums) {
        //Input: nums = [1,2,4,6]
        //Output: [48,24,12,8]
        //1, 1, 2, 8
        //48,24,6, 1
        //48,24,12,8

        int len = nums.length;
        int[] res = new int[len];
        int[] pref = new int[len];
        int[] suf = new int[len];

        pref[0] = 1;
        for(int i = 1; i < len; i++){
            pref[i] = pref[i - 1] * nums[i - 1]; 
        } 

        suf[len - 1] = 1;
        for(int i = len - 2; i >= 0; i--){
            suf[i] = suf[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < len; i++){
            System.out.println(pref[i] + " * " + suf[i]);
            res[i] = pref[i] * suf[i];
        }

        return res;

    }
}  
