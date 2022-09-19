class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int maxRange = 0;
        for (int num : nums) {
            maxRange = Math.max(maxRange, num);
        }
        int[] init = new int[maxRange + 1];
        for (int i = 0; i <= maxRange; i++) {
            init[i] = 0;
        }
        
        SegmentTree st = new SegmentTree(init);
        
        int result = 1;
        for (int num : nums) {
            int l = Math.max(1, num - k);
            int r = num - 1;
            int cur = 1;
            if (l <= r) {
                cur = st.rMaxQ(l, r) + 1;
            }
            if (cur > init[num]) {
                st.update(num, num, cur);
                init[num] = cur;
            }
            result = Math.max(result, cur);
        }
        return result;
    }
        
        

    /**
     * Time-Complexity:  O(n*log(n))
     *
     * @param array the Initialization array
     */
    
    public class SegmentTree {
        private Node[] heap;
        private int[] array;
        private int size;
        public SegmentTree(int[] array) {
            this.array = Arrays.copyOf(array, array.length);
            //The max size of this array is about 2 * 2 ^ log2(n) + 1
            size = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double) array.length) / Math.log(2.0)) + 1)));
            heap = new Node[size];
            build(1, 0, array.length);
        }


        public int size() {
            return array.length;
        }

        //Initialize the Nodes of the Segment tree
        private void build(int v, int from, int size) {
            heap[v] = new Node();
            heap[v].from = from;
            heap[v].to = from + size - 1;

            if (size == 1) {
                heap[v].max = array[from];
            } else {
                //Build childs
                build(2 * v, from, size / 2);
                build(2 * v + 1, from + size / 2, size - size / 2);

                //min = min of the children
                heap[v].max = Math.max(heap[2 * v].max, heap[2 * v + 1].max);
            }
        }

        /**
         * Range Min Query
         * 
         * Time-Complexity: O(log(n))
         *
         * @param  from from index
         * @param  to to index
         * @return max
         */
        public int rMaxQ(int from, int to) {
            return rMaxQ(1, from, to);
        }

        private int rMaxQ(int v, int from, int to) {
            Node n = heap[v];


            //If you did a range update that contained this node, you can infer the Min value without going down the tree
            if (n.pendingVal != null && contains(n.from, n.to, from, to)) {
                return n.pendingVal;
            }

            if (contains(from, to, n.from, n.to)) {
                return heap[v].max;
            }

            if (intersects(from, to, n.from, n.to)) {
                propagate(v);
                int leftMin = rMaxQ(2 * v, from, to);
                int rightMin = rMaxQ(2 * v + 1, from, to);

                return Math.max(leftMin, rightMin);
            }

            return Integer.MIN_VALUE;
        }


        /**
         * Range Update Operation.
         * With this operation you can update either one position or a range of positions with a given number.
         * The update operations will update the less it can to update the whole range (Lazy Propagation).
         * The values will be propagated lazily from top to bottom of the segment tree.
         * This behavior is really useful for updates on portions of the array
         * <p>
         * Time-Complexity: O(log(n))
         *
         * @param from  from index
         * @param to    to index
         * @param value value
         */
        public void update(int from, int to, int value) {
            update(1, from, to, value);
        }

        private void update(int v, int from, int to, int value) {

            //The Node of the heap tree represents a range of the array with bounds: [n.from, n.to]
            Node n = heap[v];

            /**
             * If the updating-range contains the portion of the current Node  We lazily update it.
             * This means We do NOT update each position of the vector, but update only some temporal
             * values into the Node; such values into the Node will be propagated down to its children only when they need to.
             */
            if (contains(from, to, n.from, n.to)) {
                change(n, value);
            }

            if (n.size() == 1) return;

            if (intersects(from, to, n.from, n.to)) {
                /**
                 * Before keeping going down to the tree We need to propagate the
                 * the values that have been temporally/lazily saved into this Node to its children
                 * So that when We visit them the values  are properly updated
                 */
                propagate(v);

                update(2 * v, from, to, value);
                update(2 * v + 1, from, to, value);

                n.max = Math.max(heap[2 * v].max, heap[2 * v + 1].max);
            }
        }

        //Propagate temporal values to children
        private void propagate(int v) {
            Node n = heap[v];

            if (n.pendingVal != null) {
                change(heap[2 * v], n.pendingVal);
                change(heap[2 * v + 1], n.pendingVal);
                n.pendingVal = null; //unset the pending propagation value
            }
        }

        //Save the temporal values that will be propagated lazily
        private void change(Node n, int value) {
            n.pendingVal = value;
            n.max = value;
            array[n.from] = value;

        }

        //Test if the range1 contains range2
        private boolean contains(int from1, int to1, int from2, int to2) {
            return from2 >= from1 && to2 <= to1;
        }

        //check inclusive intersection, test if range1[from1, to1] intersects range2[from2, to2]
        private boolean intersects(int from1, int to1, int from2, int to2) {
            return from1 <= from2 && to1 >= from2   //  (.[..)..] or (.[...]..)
                    || from1 >= from2 && from1 <= to2; // [.(..]..) or [..(..)..
        }

        //The Node class represents a partition range of the array.
        static class Node {
            int max;
            //Here We store the value that will be propagated lazily
            Integer pendingVal = null;
            int from;
            int to;

            int size() {
                return to - from + 1;
            }

        }
    }

}