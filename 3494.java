class Solution {
     public static long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long time[] = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += skill[i];
            time[i] = sum * mana[0];
        }

        for (int i = 1; i < m; i++) {
            long l = time[0], r = time[n - 1];

            long ans = bs(time, skill, l, r, mana[i]); 
            long curr = ans;
            for (int j = 0; j < n; j++) {
                time[j] = curr + skill[j] * mana[i];
                curr = time[j];
            }
        }
        return time[n - 1];

    }

    private static long bs(long time[], int skill[],long l, long r, int cap) {
        long ans = -1;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (can(mid,time,skill,cap)) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    private static boolean can(long mid,long time[], int skill[],int cap) {
        long sum = mid + skill[0] * cap;
        for (int i = 1; i < time.length; i++) {
            if(sum<time[i]){
                return false;
            }
            sum = sum + skill[i] * cap;
        }
        return true;
    }
}
