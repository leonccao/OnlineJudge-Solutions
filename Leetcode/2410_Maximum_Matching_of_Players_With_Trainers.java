class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int count = 0, index = 0;
        
        for (int i = 0; i < players.length; i++) {
            while (index < trainers.length &&
                   trainers[index] < players[i]) {
                index++;
            }
            if (index >= trainers.length) {
                break;
            }
            
            count++;
            index++;
        }
        return count;
    }
}