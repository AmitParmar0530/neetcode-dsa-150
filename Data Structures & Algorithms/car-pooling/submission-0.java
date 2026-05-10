class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //Input: trips = [[4,1,2],[3,2,4]], capacity = 4
        //Output: true
        //sorted by from 
        //add priorityQueue sorted by numpassenger // [end, numPassengers]
        Arrays.sort(trips, Comparator.comparingInt(t -> t[1]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));

        int currPass = 0;
        for(int[] trip: trips){
            int numPassanger = trip[0];
            int start = trip[1];
            int end = trip[2];

            while(!minHeap.isEmpty() && minHeap.peek()[0] <= start){
                currPass -= minHeap.poll()[1];
            }

            currPass += numPassanger;
            if(currPass > capacity){
                return false;
            }

            minHeap.offer(new int[]{end, numPassanger});
        }

        return true;
    }
}