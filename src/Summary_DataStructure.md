# Data Structure
## Queue
* offer O(logn)
* top/peek O(1)
* poll O(logn) 
* BFS

``` java
private Comparator<Integer> compareMaxQ = new Comparator<Integer>(){
        public int compare(Integer a, Integer b){
            return b - a;
        }
    };
    
Queue<Integer> minQ = new PriorityQueue<Integer>();
Queue<Integer> maxQ = new PriorityQueue<Integer>(count, compareMaxQ);
```

K个数的中位数，需要知道第K/2小和第K/2大
=> 最大堆+最小堆
• 动态维护中位数一般都是用双堆解决 O(nlogn)
– 同理：动态维护第K大数

* 642 Moving Average from Data Stream

* 360 Sliding Window Median
=> (minHeap.remove(nums[j]) takes O(n), 太慢了。 </br>
=> TreeSet

## TreeSet
* .add() O(logn)
* .remove() O(logn)
* .contains() O(logn)
* .first() O(1) // smallest
* .last() O(1)

* 360 Sliding Window Median

* 364 Trapping Rain Water II

## Deque (Double-ended queue)
* offerFirst O(1)
* offerLast O(1)
* pollFirst O(1)
* pollLast O(1)
* peekFirst O(1)
* peekLast O(1)
* .size() O(1)



## Stack
* push O(1)
* top O(1)
* pop O(1)
* iterative DFS
### Monotone Stack

## Trie
O(L) // L: word length
``` java
```
* 422 Implement Trie
* 473 Add and Search Word - Data structure design

## Hash
* 128 Hash Function
* 134 LRU Cache

* 657 Insert Delete GetRandom O(1)
* 954 Insert Delete GetRandom O(1) - Duplicates allowed
https://www.jiuzhang.com/solutions/insert-delete-getrandom-o1-duplicates-allowed/

* 209 First Unique Character in a String
* 960 First Unique Number in a Stream II

DataStream questions
https://www.lintcode.com/problem/?tag=data-stream





