class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] cuts = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            cuts[i] = i - 1;
        }

        for (int center = 0; center < n; center++) {
            expandAroundCenter(s, center, center, cuts);
            expandAroundCenter(s, center, center + 1, cuts);
        }

        return cuts[n];
    }

    private void expandAroundCenter(String s, int left, int right, int[] cuts) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            cuts[right + 1] = Math.min(cuts[right + 1], 1 + cuts[left]);
            left--;
            right++;
        }
    }
}