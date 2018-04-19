// 這類問題 要從start小的開始看
// insert intervals
// 156. Merge Intervals 
// 839. Merge Two Sorted Interval Lists 
// 486. Merge K Sorted Arrays 


// merge intervals

// merge 2 sorted interval list
// time: O(m + n)
// 1. Interval curr = null, last = null;
// 2. 比start, 看要從哪一個拿出來, 從小的開始拿, 設為curr
// 3. 拿出來後, 跟reuslt比, 沒交集插入, 設為last, 有交集改last
// 4. 改交集:
// last.start = Math.min(last.start, curr.start);
// last.end = Math.max(last.end, curr.end);


// merge k sorted interval list
// time: O(nklog(k))
// space: O(k)
// 要開一個class存現在是做到哪一個interval
public class IntervalLocation{
        int row;
        int col;
        Interval interval;
        public IntervalLocation(int row, int col, Interval interval){
            this.row = row;
            this.col = col;
            this.interval = interval;
        }
    }
    
// priority queue =>implemet comparator
private Comparator<Interval> IntervalComparator = new Comparator<Interval>{
  public int compare(Interval interval1, Interval interval2){
    return interval1.start - interval2.start;
  }
}

// 注意priority queue寫法, 要傳入comparator的話需要size
Queue<Intervals> q = new PriorityQueue<Intervals>(int size, IntervalComparator);

// 每poll出一個interval, 再跟result比, 沒交集插入, 設為last, 有交集改last
