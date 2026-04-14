class Solution {
public:

    int check(string& s, int len){
        const int p = 31;
        const int m = 1e9 + 9;
        long long hash_value = 0;
        long long p_L = 1; // This will store p^len % m
        int n = s.size();
        
        // We use unordered_set for O(1) average lookup time (set is O(log N))
        unordered_map<long long, vector<int>> lookup;

        // 1. Precompute p^len % m 
        // We need this to subtract the character that falls out of the window
        for (int i = 0; i < len; i++) {
            p_L = (p_L * p) % m;
        }

        // 2. Calculate the hash of the FIRST window of size 'len'
        for (int i = 0; i < len; i++) {
            int val = s[i] - 'a' + 1;
            // Shift previous characters left by multiplying by p, then add new char
            hash_value = (hash_value * p + val) % m;
        }

        // Store the first window's hash
        lookup[hash_value] = {0};

        // 3. Slide the window across the rest of the string
        for (int i = len; i < n; i++) {
            int added_val = s[i] - 'a' + 1;
            int removed_val = s[i-len] - 'a' + 1;

            // The Sliding Window Math:
            // Multiply by p, subtract the removed value (scaled by p^len), and add the new value
            hash_value = (hash_value * p - (removed_val * p_L) + added_val) % m;
            hash_value = (hash_value + m) % m;
            
            auto itr = lookup.find(hash_value);
            int idx = i-len+1;
            if(itr != lookup.end()){
                string cur = s.substr(idx, len);
                for(int prev_idx: lookup[hash_value]){
                    if(s.substr(prev_idx, len) == cur){
                        return idx;
                    }
                }
            }
            lookup[hash_value].push_back(idx);
        }

        return -1;
    }

    string longestDupSubstring(string s) {
        int n = s.size();
        string ans = "";
        int l = 1, r = n-1;
        while(l <= r){
            int m = l + (r-l)/2;
            int idx = check(s, m);
            if(idx != -1){
                ans = s.substr(idx, m);
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return ans;
    }
};
