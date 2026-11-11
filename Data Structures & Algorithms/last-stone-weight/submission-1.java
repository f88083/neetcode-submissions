class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(
            Collections.reverseOrder()
        );

        for (int s : stones) {
            maxHeap.offer(s);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int sec = maxHeap.poll();

            maxHeap.offer(Math.abs(first - sec));
        }


        return maxHeap.peek();
    }
}
