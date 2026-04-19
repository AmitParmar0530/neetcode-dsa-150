class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();  // stores indices

        for (int i = 0; i < n; i++) {

            // 1. Evict front if it's outside the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 2. Evict from back all indices whose values are <= nums[i]
            //    (they can never be the max while nums[i] is in the window)
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // 3. Add current index to back
            deque.offerLast(i);

            // 4. Start recording once first window is complete
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
    return result;
    }
}
