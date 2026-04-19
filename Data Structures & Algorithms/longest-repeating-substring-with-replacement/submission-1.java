class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int result = 0;

        for( int right = 0; right < s.length(); right++){
            int c = s.charAt(right) - 'A';

            // 1. Expand: add right character to window
            freq[c]++;

            // 2. Track the max frequency seen so far
            maxFreq = Math.max(maxFreq, freq[c]);

            // 3. If window is invalid, shrink from left
            int windowSize = right - left + 1;
            if(windowSize - maxFreq > k){
                int leftChar = s.charAt(left) - 'A';
                freq[leftChar]--;
                left++;              
            }

            // 4. Window is always valid here — update result
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
