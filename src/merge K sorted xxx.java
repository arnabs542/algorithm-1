////////  merge 2 sorted array/ list/ intervals  ////////
6. Merge Two Sorted Arrays
839. Merge Two Sorted Interval Lists
165. Merge Two Sorted Lists

=> 設定counter, i for array1, j for array2
=> while ( i < A1.length && j < A2.length){
    比大小, 小的先放入結果
  }
=> 剩下的再全部放入結果

////////  merge K sorted array  ////////

=> priorityqueue
Queue<T> q = new PriorityQueue<T>();

=> 把 K rows 的第一個element都放入PriorityQueue
=> while(!q.isEmpty()){ 
    q.poll()
    q.offer(poll出那一列的下個element)
    }
