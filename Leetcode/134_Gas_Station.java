class Solution {
    class Station {
        int price;
        int index;
        Station(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length < 1) return -1;
        
        int[] price = new int[gas.length];
        price[0] = gas[0] - cost[0];
        for (int i = 1; i < gas.length; i ++)
            price[i] = price[i - 1] + gas[i] - cost[i];
        
        Deque<Station> deque = new LinkedList<Station>();
        for (int i = 0; i < gas.length; i ++) {
            while (!deque.isEmpty() && deque.peekLast().price >= price[i])
                deque.pollLast();
            deque.offerLast(new Station(price[i], i));
        }
        if (deque.peekFirst().price >= 0) return 0;
        
        int tail = price[gas.length - 1];
        int bias = 0;
        for (int i = 0; i < gas.length - 1; i ++) {
            if (!deque.isEmpty() && deque.peekFirst().index == i)
                bias -= deque.pollFirst().price;
            tail += gas[i] - cost[i];
            while (!deque.isEmpty() && deque.peekLast().price >= tail)
                deque.pollLast();
            deque.addLast(new Station(tail, i + gas.length));
            if (deque.peekFirst().price + bias >= 0)
                return i + 1;
        }
        return -1;
            
        
    } 
}