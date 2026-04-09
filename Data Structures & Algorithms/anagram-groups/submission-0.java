class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            
            int[] freq = new int[26];
            
            for(char c: str.toCharArray()){
                int idx = c - 'a';
                freq[idx] = freq[idx] + 1;    
            }

            String key = Arrays.toString(freq);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> list: map.values()){
           res.add(list);     
        }

        return res;
    }
}
