class Solution {
    // static int[] arr;
    static int ans;
    public int countDigitOne(int n) {
        ans=0;
        int temp=n;
        int cnt=0;
        int[] arr=new int[11];

        while(temp!=0){
        cnt++;
        temp/=10;
        }

        arr[1]=1;
        

        for(int i=2;i<11;i++){
         arr[i]+=(10*arr[i-1]);
         arr[i]+=(Math.pow(10,i-1));
        }

        hlp(n,cnt,arr);
        return ans;
    }
    static public void hlp(int num,int cnt,int[] arr){
        if (cnt == 0) return;

        if(cnt==1){
            if(hlp2(num,cnt)>=1)
            ans++;
            return;
        }

        int temp=hlp2(num,cnt);
        ans+=(temp)*arr[cnt-1];

        if(temp>1){
            ans+=Math.pow(10,cnt-1);
        }
        else if(temp==1){
            ans+=(hlp3(num,cnt-1)+1);
        }

        hlp(num,cnt-1,arr);
    }


    static public int hlp2(int num, int cnt) {
        return (num / (int)Math.pow(10, cnt - 1)) % 10;
    }

    // FIX: Base-10 logic to get the number formed by the rightmost `cnt` digits
    static public int hlp3(int num, int cnt) {
        return num % (int)Math.pow(10, cnt);
    }
}
