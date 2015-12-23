class MedianFinder {
    // max heap maintain the smaller half of the data stream
    PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder()); // java 8
    // min heap maintain the larger half of the data stream
    PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        // make sure the max heap size is equal or more than 1 than the min heap
        if(max.size() < min.size()){
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(max.size() == min.size()){
            return (max.peek() + min.peek()) / 2.0; // / 2.0  not 2!!!!
        }
        return max.peek();
    }
};

// time complexity: add O(logn), find O(1)
