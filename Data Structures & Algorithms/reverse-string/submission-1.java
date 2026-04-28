class Solution {
    public void reverseString(char[] s) {
        //BF
        //Create another array which store this char from end
        //TC: O(n) SC:O(n)
        //Two Pointer
        int left = 0;
        int right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}