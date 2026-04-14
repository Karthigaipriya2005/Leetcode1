class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] curr = new int[5];
        int[] prev = new int[5];

        for (int i = n - 1; i >= 0; i--) {
            for (int trans = 0; trans < 4; trans++) {
                curr[trans] = trans % 2 == 0 ? Math.max(prev[trans + 1] - prices[i], prev[trans])
                        : Math.max(prev[trans + 1] + prices[i], prev[trans]);

            }
            prev = curr;
        }

        return curr[0];
    }
}
