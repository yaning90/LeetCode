/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        int count = 1;
        // sort intervals by interval.start in ascending order
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        // use minHeap to track the min interval's end value
        PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.end - b.end;
            }
        });
        minHeap.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            Interval cur = minHeap.peek();
            Interval next = intervals[i];
            // if the next meeting's start time is earlier than the min end time,
            // allocate a new room
            if(next.start < cur.end){
                count++;
            // if the next meeting's start time is later than the min end time,
            // remove the previous min end time 
            }else{
                minHeap.poll();
            }
            minHeap.offer(next);
        }
        return count;
    }
}