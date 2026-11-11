class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // position, speed
        int[][] pair = new int[position.length][2];

        for (int i = 0; i < n; ++i) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        // Large to small
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 1;
        double prevTime = 1.0 * (target - pair[0][0]) / pair[0][1];

        for (int i = 1; i < n; ++i) {
            double currTime = 1.0 * (target - pair[i][0]) / pair[i][1];
            
            // Current car will be late, couldn't catch up to the front car
            // Therefore form a new fleet
            if (currTime > prevTime) {
                ++fleets;
                prevTime = currTime;
            }
        }

        return fleets;
    }
}
