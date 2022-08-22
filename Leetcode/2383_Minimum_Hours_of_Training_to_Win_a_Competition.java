class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int energyCost = 1 - initialEnergy;
        for (int en : energy) {
            energyCost += en;
        }
        int expCur = initialExperience;
        int expCost = 0;
        for (int exp : experience) {
            if (expCur <= exp) {
                expCost += exp - expCur + 1;
                expCur = exp + 1;
            }
            expCur += exp;
        }
        return expCost + Math.max(0, energyCost);
    }
}