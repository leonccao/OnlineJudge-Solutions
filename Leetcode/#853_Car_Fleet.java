class Solution {
    class Car {
        int position, speed;
        double time;
        Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] car = new Car[n];
        for (int i = 0; i < n; i ++)
            car[i] = new Car(position[i], speed[i]);
        Arrays.sort(car, new Comparator<Car>() {
            public int compare(Car a, Car b) {
                return b.position - a.position;
            }
        });
        
        for (int i = 0; i < n; i ++)
            car[i].time = (double)(target - car[i].position) / (double)car[i].speed;
        double last = -1;
        int ans = 0;
        for (int i = 0; i < n; i ++)
            if (car[i].time > last) {
                last = car[i].time;
                ans ++;
            }
        return ans;
    }
}