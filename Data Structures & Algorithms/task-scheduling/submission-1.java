class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Create an array to store the count of each task
        int[] count = new int[26];

        // Count the frequency of each task
        for (char task : tasks) {
            count[task - 'A']++;
        }

        // Create a max heap to store the task counts in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add the non-zero task counts to the max heap
        for (int cnt : count) {
            if (cnt > 0) {
                maxHeap.add(cnt);
            }
        }

        // Initialize the total time to 0
        int time = 0;

        // Create a queue to store the tasks that are waiting for their cooling interval
        Queue<int[]> q = new LinkedList<>();

        // Continue processing tasks until both the max heap and queue are empty
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            // Increment the time for each interval
            time++;

            // If the max heap is empty, jump to the next task's scheduled time
            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                // Take the task with the highest count from the max heap
                int cnt = maxHeap.poll() - 1;

                // If there are remaining instances of the task, add it to the queue
                // with its scheduled time (current time + cooling interval)
                if (cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }

            // If there are tasks in the queue and the next task's scheduled time is the current time,
            // add the task back to the max heap
            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        // Return the total time intervals needed to complete all tasks
        return time;
    }
}
