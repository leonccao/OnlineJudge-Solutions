class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.trim().split("\\.");
        String[] ver2 = version2.trim().split("\\.");
        int len = Math.max(ver1.length, ver2.length);
        for (int i = 0; i < len; i ++) {
            int tmp1 = i < ver1.length ? Integer.valueOf(ver1[i]) : 0;
            int tmp2 = i < ver2.length ? Integer.valueOf(ver2[i]) : 0;
            if (tmp1 < tmp2) return -1;
            if (tmp1 > tmp2) return 1;
        }
        return 0;
    }
}