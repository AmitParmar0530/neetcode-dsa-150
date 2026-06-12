class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> freq.get(a) - freq.get(b));

        for(int key: freq.keySet()){
            minHeap.offer(key);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k ; i++){
            res[i] = minHeap.poll();
        }

        return res;
    }
}
