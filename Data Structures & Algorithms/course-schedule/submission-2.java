class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];

        List<List<Integer>> adList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adList.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            indegrees[pre[1]]++;
            adList.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                queue.offer(i);
            }
        }

        int finish = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            finish++;

            for(int neighbor: adList.get(node)){
                indegrees[neighbor]--;
                if(indegrees[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        return finish == numCourses;

    }
}
