class Solution {
    public String minWindow(String s, String t) {
        //map T 
        //map current window 
        //have
        //need 
        //Input: s = "OUZODYXAZV", t = "XYZ"
        //Output: "YXAZ"
        int len = t.length();
        Map<Character, Integer> countT = new HashMap<>();
        
        for(char c: t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int have = 0;
        int l = 0;
        int need = countT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(countT.containsKey(ch) && window.get(ch) == countT.get(ch)){
                have++;
            }

            while(have == need){

                if((r - l + 1) < resLen){
                    resLen = (r - l) + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)){
                    have--;
                }

                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
