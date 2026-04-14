class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words.length == 0) return res;
        int wordLen = words[0].length();
        int n = s.length();
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            Map<String, Integer> currCount = new HashMap<>();
            int count = 0;
            for (int right = i; right + wordLen <= n; right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordCount.containsKey(word)) {
                    currCount.put(word, currCount.getOrDefault(word, 0) + 1);
                    count++;
                    while (currCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currCount.put(leftWord, currCount.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                    if (count == words.length) {
                        res.add(left);
                    }
                } else {
                    currCount.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return res;
    }
}
