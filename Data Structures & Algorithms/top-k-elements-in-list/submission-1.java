class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num,map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((e1,e2) -> map.get(e1) - map.get(e2));

        for(int num: map.keySet()){
            heap.add(num);

            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] res = new int[k];

        for(int i = 0; i < k ; i++){
            res[i] = heap.poll();
        }

        return res;
    }
}
