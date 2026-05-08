class Solution {
    public int[][] merge(int[][] intervals) {
         //sort by start time
        //output List<int[]> list
        //rows = number of intervals
        //cols = <start, end>
        //list.add(intervals[0]);
        //for row 1
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] prev = list.get(list.size() - 1);
            int[] curr = intervals[i];
            if(prev[1] >= curr[0]){
               prev[0] = Math.min(prev[0],curr[0]);
               prev[1] = Math.max(prev[1],curr[1]);
            } else {
               list.add(intervals[i]);
            }            
        }
            
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
