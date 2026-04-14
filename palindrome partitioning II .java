class Solution {
    public int minCut(String s) {

        char[] input = s.toCharArray();
        int len = s.length();
        int[] cut = new int[len];

        for (int i = 0; i < len; i++) cut[i] = i;
        for (int i = 1; i < len; i++) {
            if (input[i] == input[0])
                cut[i] = 0;
            else 
                break;
        }        
        
        for (int i = 1; i < len; i++) {
            int last = cut[i-1];
            int left = i-1;

            cut[i] = Math.min(cut[i], cut[i-1]+1);

            while (i < len-1 && input[i] == input[i+1]) {
                last = Math.min(last, cut[i++]);
                cut[i] = Math.min(cut[i], last+1);
            }

            int right = i+1;
            while (left > 0 && right < len && input[left] == input[right]) {
                cut[right] = Math.min(cut[right], cut[left-1]+1);
                left--;
                right++;
            }
            if (left == 0 && right < len && input[left] == input[right])
                cut[right] = 0;        
        }
        return cut[len-1];            
    }
}
