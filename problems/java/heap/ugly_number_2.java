class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        heap.add(1L);
        long cur = 1;
        int count = 1;
        while(count <= n){
            while(set.contains(heap.peek())){
                heap.poll();
            }
            cur = heap.poll();

            heap.add(cur*2);
            heap.add(cur*3);
            heap.add(cur*5);

            set.add(cur);
            count++;
        }
        return (int)cur;
        
    }
}
