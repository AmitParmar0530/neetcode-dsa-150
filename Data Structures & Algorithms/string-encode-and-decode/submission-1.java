class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()){ 
            return "";
        }

        StringBuilder result = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for(String str: strs){
            sizes.add(str.length());
        }

        for(int size: sizes){
            result.append(size).append(",");
        }

        result.append("#");

        for(String str: strs){
            result.append(str);
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0) return new ArrayList<>();

        int len = str.length();
        int i = 0;
        
        List<String> result = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        while(str.charAt(i) != '#'){
            StringBuilder cur = new StringBuilder();
            while(str.charAt(i) != ','){
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;

        for(int sz: sizes){
            result.add(str.substring(i, i + sz));
            i += sz;
        }

        return result;
    }
}
