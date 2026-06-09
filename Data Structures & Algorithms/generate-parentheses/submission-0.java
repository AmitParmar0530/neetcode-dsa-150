class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> result, String current, int open, int close, int n){
        //Basecase
        if(open == n && close == n){
            result.add(current);
            return;
        }

        //add open until n
        if(open < n){
            backtrack(result, current + "(", open + 1, close, n);
        }

        //add close < open
        if(close < open){
            backtrack(result, current + ")", open, close + 1, n);
        }

    }
}
