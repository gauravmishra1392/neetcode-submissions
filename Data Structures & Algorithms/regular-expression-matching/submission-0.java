class Solution {
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {

        memo = new Boolean[s.length()][p.length()];

        return isMatchRecur(s, p, s.length() - 1, p.length() - 1);
    }

    boolean isMatchRecur(String s, String t, int slen, int plen) {

        if (plen < 0) {
            return slen < 0;
        }

        // FIX: only access memo when slen >= 0
        if (slen >= 0 && memo[slen][plen] != null) {
            return memo[slen][plen];
        }

        if (t.charAt(plen) == '*') {

            boolean noOccur = isMatchRecur(s, t, slen, plen - 2);
            boolean oneOrMore = false;

            if (slen >= 0 &&
                (t.charAt(plen - 1) == '.' ||
                 t.charAt(plen - 1) == s.charAt(slen))) {

                oneOrMore = isMatchRecur(s, t, slen - 1, plen);
            }

            boolean result = noOccur || oneOrMore;

            // FIX: only memoize when slen >= 0
            if (slen >= 0) {
                memo[slen][plen] = result;
            }

            return result;
        }

        if (slen >= 0 &&
            (t.charAt(plen) == '.' ||
             s.charAt(slen) == t.charAt(plen))) {

            boolean result =
                isMatchRecur(s, t, slen - 1, plen - 1);

            // FIX: only memoize when slen >= 0
            memo[slen][plen] = result;

            return result;
        }

        // FIX: only memoize when slen >= 0
        if (slen >= 0) {
            memo[slen][plen] = false;
        }

        return false;
    }
}