# Merge Sorted Array/List/Intervals

## Merge 2 sorted Array/List/Intervals O(n) 
n = A1.length + A2.length

* 6 Merge Two Sorted Arrays
* 839 Merge Two Sorted Interval Lists
* 165 Merge Two Sorted Lists

```java
/* 1. 設定counter, i for array1, j for array2 
   2. while ( i < A1.length && j < A2.length){
        比大小, 小的先放入結果
      }
   3. 剩下的再全部放入結果
   while ( i < A1.length ){
    不用比, 全部放入
   }
   while ( j < A2.length ){
    不用比, 全部放入
   }
*/ 
```
## Merge k sorted Array/List/Intervals O(nlog(k)) 
* 486 Merge K Sorted Arrays
* 104 Merge K Sorted Lists
* 839 Merge Two Sorted Interval Lists


### Sol 1.) priorityqueue
Queue<T> q = new PriorityQueue<T>(); </br>

=> 把 K rows 的第一個element都放入PriorityQueue </br>
``` java
while(!q.isEmpty()){   // O(n)
    q.poll()           // O(logk)
    q.offer(poll出那一列的下個element) //O(logk)
}
```
### Sol 2.) divide & conquer
``` java
private divide(int start, int end){
   if (start >= end){
      return start那方的;
   }
   int mid = (start + end)/2;
   left = divide(start, mid);
   right = divide(mid + 1, end);
   return merge(left, right);
}

private merge(left, right){
   .....
}
```


## sweep line
### 将起点和终点打散排序
<start, +1>
<end, - 1>
将起点和终点打散排序
* 391 Number of Airplanes in the Sky
=> create new class for the event, 轉換input data to List<Event> eventList
=> Event(int time, int type) 
=> type: in: 1; out -1;
=> eventList.sort(Comparator.comparing((event e) -> e.time))
=> loop through eventList

* 821. Time Intersection
=> 如果使用者上線 && count == 2, 记录下这个时间, 作为两个用户都在线的起点
=> 如果使用者下線 && count == 1, 记录下这个时间, 作为两个用户都在线的終點, 放入結果

* 131. The Skyline Problem

