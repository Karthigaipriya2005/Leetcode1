class Solution {
    int startIndex = 0, endIndex =0;
      public  String longestPalindrome(String s) {
       char [] chars = s.toCharArray();
        backtrack(chars, 0);
        return s.substring(startIndex, endIndex+1);
    }
    private void backtrack(char[] chars, int i) {
        int n = chars.length;
        if(i> n-1) return;
        int l = i, r = i;
        while (r < n-1 && chars[r] == chars[r+1]) r++;
        i = r;
        while (l > 0 && r < n-1 && chars[l-1] == chars[r+1]){
            l--; r++;
        }
        if(r-l > endIndex - startIndex){
            startIndex = l;
            endIndex = r;
        }
        backtrack(chars, ++i);
    }
}
