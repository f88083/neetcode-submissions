class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                (a[0] * a[0] + a[1] * a[1]),
                (b[0] * b[0] + b[1] * b[1])
            )
        );

        for (int[] p : points) {
            pq.offer(p);
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; ++i) {
            int[] tmp = pq.poll();
            res[i][0] = tmp[0];
            res[i][1] = tmp[1];
        }
        return res;
    }
}
