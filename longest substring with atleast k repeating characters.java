class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || s.length() < k) {
            return 0;
        }
        

        int maxLen = Integer.MIN_VALUE;
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        int start = 0;
        boolean valid = true;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (freq[c - 'a'] > 0 && freq[c -'a'] < k) {
                String sub = s.substring(start, end);
                maxLen = Math.max(maxLen, longestSubstring(sub, k));
                start = end + 1;
                valid = false;
            }
        }

        if (valid) {
            return s.length();
        } else {
            return Math.max(maxLen, longestSubstring(s.substring(start), k));
        }
    }
}
