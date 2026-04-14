class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] freq = new int[51];
        int[] res = new int[n - k + 1];

        for(int i = 0; i < nums.length ; i++){
            if(nums[i] < 0){
                freq[-nums[i]]++;
            }
            if(i - k >= 0  && nums[i - k] < 0){
                freq[-nums[i-k]]--;
            }
            if(i - k + 1 >= 0){
                int count = 0 , beauty = 0;

                for(int j = 50 ; j >= 1 ; j--){
                    count += freq[j];
                    if(count >= x){
                        beauty = j;
                        break;
                    }
                }
                res[ i - k + 1] = -beauty;
            }
        }

        return res;
    }
}
