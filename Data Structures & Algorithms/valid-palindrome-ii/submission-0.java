class Solution {
    public boolean validPalindrome(String s) {
        //first check if initial string palindrom return true 

        if(isPalindrom(s)){
            return true;
        }

        for(int i = 0; i < s.length(); i++){
            String newStr = s.substring(0, i) + s.substring(i + 1);
            if(isPalindrom(newStr)){
                return true;
            }
        }

        return false;
        //remove the index char, check palindrom        
    }

    public boolean isPalindrom(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}