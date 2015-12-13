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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> answer = new ArrayList<Interval>();

        if(intervals == null || intervals.size() == 0){
            return answer;
        }
        // sort intervals in ascending order by the start value of intervals,
        Collections.sort(intervals, new IntervalComparator());
        Interval last = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(cur.start <= last.end){
                last.end = Math.max(last.end, cur.end);
            }else{
                answer.add(last);
                last = cur;
            }
        }
        answer.add(last);
        return answer;
    }
    private class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
             return a.start - b.start;
        }
    }
}