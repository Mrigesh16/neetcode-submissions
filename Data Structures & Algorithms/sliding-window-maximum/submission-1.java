class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dQueue = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
         for (int i = 0; i < k; i++) {
            while (!dQueue.isEmpty() && nums[dQueue.peekLast()] < nums[i]) {
                dQueue.removeLast();
            }
            dQueue.addLast(i);
        }

        ans.add(nums[dQueue.peekFirst()]);

        for(int i = k; i<nums.length; i++){
            if(dQueue.peekFirst() <= i - k)
                dQueue.removeFirst();
            while(!dQueue.isEmpty() && (nums[dQueue.peekLast()] < nums[i])){
                dQueue.removeLast();
            }
            if(dQueue.isEmpty())
                dQueue.addFirst(i);
            else
                dQueue.addLast(i);
            ans.add(nums[dQueue.peekFirst()]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
