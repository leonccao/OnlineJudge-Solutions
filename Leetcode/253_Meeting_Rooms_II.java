// old Priority Queue
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (Interval interval : intervals) {
            if (!pq.isEmpty() && pq.peek() <= interval.start)
                pq.poll();
            pq.add(interval.end);
        }
        return pq.size();
    }
}

// old & not preferable
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends   = new int[intervals.length];
        for (int i = 0; i < intervals.length; i ++) {
            starts[i] = intervals[i].start;
            ends[i]   = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int j = 0, ans = 0;
        for (int i = 0; i < intervals.length; i ++) {
            if (starts[i] < ends[j]) ans ++;
            else j ++;
        }
        return ans;
    }
}

// Scan line O(nlogn)
class Solution {
    class Meeting {
        int index, val;
        Meeting(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        Meeting[] meets = new Meeting[intervals.length * 2];
        int count = 0;
        for (Interval interval : intervals) {
            meets[count ++] = new Meeting(interval.start,  1);
            meets[count ++] = new Meeting(interval.end,   -1);
        }
        Arrays.sort(meets, new Comparator<Meeting>(){
            public int compare(Meeting a, Meeting b) {
                return a.index - b.index;
            }
        });
        
        int sum = 0, ans = 0;
        for (int i = 0; i < meets.length; i ++) {
            sum += meets[i].val;
            while (i + 1 < meets.length && meets[i + 1].index == meets[i].index)
                sum += meets[++ i].val;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

// PriorityQueue + Assign Room + In-room Merge Intervals
class Solution {
    class Room {
        int name, end;
        Room(int name, int end) {
            this.name = name;
            this.end = end;
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        PriorityQueue<Room> pq = new PriorityQueue<>(new Comparator<Room>(){
            public int compare(Room a, Room b) {
                return a.end - b.end;
            }
        });
        List<List<Interval>> rec = new ArrayList<>();
        for (Interval interval : intervals) {
            Room cur = null;
            if (pq.isEmpty() || pq.peek().end > interval.start) {
                cur = new Room(pq.size(), 0);
                rec.add(new ArrayList<>());
            } else cur = pq.poll();
            cur.end = interval.end;
            rec.get(cur.name).add(interval);
            pq.add(cur);
        }
        mergeInterval(rec);
        return pq.size();
    }
    
    private void mergeInterval(List<List<Interval>> rec) {
        for (int i = 0; i < rec.size(); i ++) {
            if (rec.get(i).isEmpty()) continue;
            List<Interval> tmp = new ArrayList<>();
            Interval last = rec.get(i).get(0);
            for (int j = 1; j < rec.get(i).size(); j ++)
                if (last.end < rec.get(i).get(j).start) {
                    tmp.add(last);
                    last = rec.get(i).get(j);
                } else last.end = rec.get(i).get(j).end;
            tmp.add(last);
            rec.set(i, tmp);
        }
        for (List<Interval> room : rec) {
            System.out.print("[");
            for (Interval interval : room)
                System.out.print("[" + interval.start + ", " + interval.end + "], ");
            System.out.println("]");
        }
    }
}