class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            graph.get(preReq).add(course);
        }

        int[] state = new int[numCourses];

        for(int course = 0; course < numCourses; course++){
            if(state[course] == 0 && hasCycle(course, graph, state)){
                return false;
            }
        }

        return true;
    }

    public boolean hasCycle(int course, List<List<Integer>> graph, int[] state){
        if(state[course] == 1) return true;

        if(state[course] == 2) return false;

        state[course] = 1;

        for(int nextCourse: graph.get(course)){
            if(hasCycle(nextCourse, graph,state)){
                return true;
            }
        }

        state[course] = 2;
        return false;
    }
}
