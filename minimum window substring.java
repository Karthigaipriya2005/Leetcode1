class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        if(s.equals(t)) {
            return s;
        }
        // Method 1: Using HashMaps
        // Map<Character, Integer> reference = new HashMap<>();
        // for(char ch: t.toCharArray()) {
        //     if(reference.containsKey(ch)) {
        //         reference.put(ch, reference.get(ch) + 1);
        //     } else {
        //         reference.put(ch, 1);
        //     }
        // }
        // int left = 0;
        // int right = 0;
        // Map<Character, Integer> windowCounts = new HashMap<>();
        // int count = 0; 
        // int minLen = Integer.MAX_VALUE;
        // int minStart = 0;
        // while(right < s.length()) {
        //     char currRight = s.charAt(right);
        //     if(reference.containsKey(currRight)) {
        //         if(windowCounts.containsKey(currRight)) {
        //             windowCounts.put(currRight, windowCounts.get(currRight) + 1);
        //         } else {
        //             windowCounts.put(currRight, 1);
        //         }
        //         if(windowCounts.get(currRight) <= reference.get(currRight)) {
        //             count++;
        //         }
        //     }
        //     while(count == t.length()) {
        //         if(right - left + 1 < minLen) {
        //             minLen = right - left + 1;
        //             minStart = left;
        //         }
        //         char currLeft = s.charAt(left);
        //         if(reference.containsKey(currLeft)) {
        //             windowCounts.put(currLeft, windowCounts.get(currLeft) - 1);
        //             if(windowCounts.get(currLeft) < reference.get(currLeft)) {
        //                 count--;
        //             }
        //         }
        //         left++;
        //     }
        //     right++;
        // }
        // if(minLen == Integer.MAX_VALUE) {
        //     return "";
        // }
        // return s.substring(minStart, minStart + minLen);
        // Method 2: Using arrays
        int[] reference = new int[128];
        int[] windowCounts = new int[128];
        int left = 0;
        int right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for(char ch: t.toCharArray()) {
            reference[ch]++;
        }

        while(right < s.length()) {
            char currRight = s.charAt(right);
            if(reference[currRight] > 0) {
                windowCounts[currRight]++;
                if(windowCounts[currRight] <= reference[currRight]) {
                    count++;
                }
            }
            while(count == t.length()) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char currLeft = s.charAt(left);
                if(reference[currLeft] > 0) {
                    windowCounts[currLeft]--;
                    if(windowCounts[currLeft] < reference[currLeft]) {
                        count--;
                    }
                }
                left++;
            }
            right++;
        }

        if(minLen == Integer.MAX_VALUE) {
            return "";
        }
        
        return s.substring(minStart, minStart + minLen);
    }
}
