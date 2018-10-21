import java.util.*;

public class TaskSchedulerFixedOrder {

    // Original: HashMap O(n) O(n)
    private int withHashMap(int[] tasks, int cooldown) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int task : tasks) {
            ans = Math.max(ans + 1, map.getOrDefault(task, Integer.MIN_VALUE) + cooldown + 1);
            map.put(task, ans);
        }
        return ans;
    }

    private class Task {
        int name, time;
        public Task(int name, int time) {
            this.name = name;
            this.time = time;
        }
    }

    // Follow up: Queue O(kn) O(k)
    private int withQueue(int[] tasks, int cooldown) {
        int ans = 0;
        Queue<Task> queue = new LinkedList<Task>();
        for (int task : tasks) {
            ans ++;
            for (Task rec : queue) 
                if (rec.name == task) {
                    ans = rec.time + cooldown + 1;
                    break;
                }
            while (!queue.isEmpty() && queue.peek().time < ans - cooldown)
                queue.poll();
            queue.add(new Task(task, ans));
        }
        return ans;
    }

    // Follow up: HashMap O(kn) O(k)
    private int withHashMapSizeK(int[] tasks, int cooldown) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int task : tasks) {
            ans = Math.max(ans + 1, map.getOrDefault(task, Integer.MIN_VALUE) + cooldown + 1);
            List<Integer> garbage = new ArrayList<Integer>();
            for (int key : map.keySet())
                if (map.get(key) < ans - cooldown)
                    garbage.add(key);
            for (int key : garbage)
                map.remove(key);
            map.put(task, ans);
        }
        return ans;
    }

    // Follow up: Queue + HashMap O(n) O(k)
    private int withQueueAndMap(int[] tasks, int cooldown) {
        int ans = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int task : tasks) {
            ans = Math.max(ans + 1, map.getOrDefault(task, Integer.MIN_VALUE) + cooldown + 1);
            while (!queue.isEmpty() && map.get(queue.peek()) < ans - cooldown)
                map.remove(queue.poll());
            map.put(task, ans);
            queue.add(task);
        }
        return ans;
    }

    public static void main(String[] args) {
        TaskSchedulerFixedOrder sol = new TaskSchedulerFixedOrder();
        // int[] tasks = {1, 1, 2, 3, 3, 1};
        // int[] tasks = {1, 1, 2, 1, 3, 1, 1};
        int[] tasks = {1, 1, 2, 3, 4, 1, 4, 3, 1, 3, 1};
        System.out.println(sol.withQueueAndMap(tasks, 2));
    }
}