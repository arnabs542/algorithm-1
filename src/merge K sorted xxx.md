# Merge Sorted Array/List/Intervals

## Merge 2 sorted Array/List/Intervals O(n) 
n = A1.length + A2.length

6. Merge Two Sorted Arrays
839. Merge Two Sorted Interval Lists
165. Merge Two Sorted Lists

=> 設定counter, i for array1, j for array2
=> while ( i < A1.length && j < A2.length){
    比大小, 小的先放入結果
  }
=> 剩下的再全部放入結果

## Merge k sorted Array/List/Intervals O(nlog(k)) 
Sol 1.) priorityqueue
Queue<T> q = new PriorityQueue<T>();

=> 把 K rows 的第一個element都放入PriorityQueue
=> while(!q.isEmpty()){ 
    q.poll()
    q.offer(poll出那一列的下個element)
    }

/////////////////////////////////////////
////////  sweep line   ///////
////////////////////////////////////////
391. Number of Airplanes in the Sky
821. Time Intersection
=> create new class for the event, 轉換input data to List<Event> eventList
=> Event(int time, int type) 
=> type: in: 1; out -1;
=> eventList.sort(Comparator.comparing((event e) -> e.time))
=> loop through eventList

821. Time Intersection
=> 如果使用者上線 && count == 2, 记录下这个时间, 作为两个用户都在线的起点
=> 如果使用者下線 && count == 1, 记录下这个时间, 作为两个用户都在线的終點, 放入結果
