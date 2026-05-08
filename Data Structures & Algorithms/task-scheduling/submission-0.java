class Solution {
    public int leastInterval(char[] tasks, int n) {
        //fill freq[26]
        //PQ decending 
        //fill PQ 
        //create queue for cooling interval 
        //time 
        //pq & queue empty 
        //time ++ 
        //if(pq empty)
        //time = queue.peek[1];
        int[] freq = new int[26];
        for(char task: tasks){
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int count: freq){
            if(count > 0){
                pq.add(count);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;

            if(pq.isEmpty()){

            } else {
                int cnt = pq.poll() - 1;

                if(cnt > 0){
                    queue.add(new int[]{cnt, time + n});
                }
            }

            if(!queue.isEmpty() && queue.peek()[1] == time){
                pq.add(queue.poll()[0]);
            }
        }

        return time;
    }
}
