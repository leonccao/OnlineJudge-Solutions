class Solution {
    private class Person {
        private int h, k;
        public Person(int h, int k) {
            this.h = h;
            this.k = k;
        }
    }
    
    private void swap(Person[] persons, int a, int b) {
        Person tmp = persons[a];
        persons[a] = persons[b];
        persons[b] = tmp;
    }
        
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i ++)
            persons[i] = new Person(people[i][0], people[i][1]);
        
        Arrays.sort(persons, new Comparator<Person>(){
            public int compare(Person a, Person b) {
                if (a.h != b.h) return a.h - b.h;
                return a.k - b.k;
            }
        });
        
        Person[] hold = new Person[n];
        for (Person person : persons) {
            int cnt = 0, index = 0;
            while (cnt < person.k || hold[index] != null) {
                if (hold[index] == null || hold[index].h == person.h)
                    cnt ++;
                index ++;
            }
            hold[index] = person;
        }
        
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i ++) {
            ans[i][0] = hold[i].h;
            ans[i][1] = hold[i].k;
        }
        return ans;
    }
}