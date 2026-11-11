class KthLargest {
    private int k;
    private int[] nums;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        pq = new PriorityQueue<Integer>();

        // Add to the pq
        for (int i = 0; i < nums.length; ++i) {
            pq.add(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
