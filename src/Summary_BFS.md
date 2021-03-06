# BFS
## Review
#69 #120 #615
#892. Alien Dictionary
#598. Zombie in Matrix 
#573. Build Post Office II
#605.

## BFS on tree
==> 因為tree結構上下分明, 每層丟進queue
``` java
Queue<TreeNode> q = new LinkedList<TreeNode>();
q.offer(root);

// 判斷queue是不是空, *** q.isEmpty() ****
while(!q.isEmpty()){
  int size = q.size();
  for (int i = 0; i < size; i ++){
    TreeNode node = q.poll();
    if (node.left != null){
      q.offer(node.left);
    }
    if (node.right != null){
      q.offer(node.right);
    }
  }
}
```
69. Binary Tree Level Order Traversal </br>
=> challenge 1: use 1 queue (done) </br>
=> challenge 2: use DFS (todo) </br>
7. Serialize and Deserialize Binary Tree </br>
70. Binary Tree Level Order Traversal II </br>
71. Binary Tree Zigzag Level Order Traversal </br>
242. Convert Binary Tree to Linked Lists by Depth

## BFS on graph
==> 沒有圖的先制造出圖, </br>
==> 使用HashMap or HashSet 以免重複計算 </br>
==> 圖可能會有環, 一個節點的鄰居的鄰居可能是自己, 所以要記錄去過的點 </br>
1. use HashSet/HashMap/arraylist to save visited node </br>
2. or if node = 1 mark visited node = 0, then we will not consider it again
```java
Queue<T> q = new LinkedList<T>();
HashSet<T> hs = new HashSet<T>();
q.offer(T);
hs.add(T)
  
while(!q.isEmpty()){
  int size = q.size();
  for (int i = 0; i < size; i ++){ // 需要分層
    T node = q.poll();
    for (node.neightbors){
      if (!hs.contains(node)){
        q.offer(node);
        hs.add(node);
      }
    }
    
  }
}

```
* 120 Word Ladder 
* 433 Number of Islands 
* 611. Knight Shortest Path 
=> 可以試試看用從source, destination同時出發開始走, 看看是不否交會？

* Time on Metrix: O(R X C)
```
// R*C个点，R*C*2 条边（每个点上下左右4条边，每条边被2个点共享）
```

* Time on Graph: O(N^2)
```
/* 
Node: N;
Edge: M; (max M could be N^2 )
=> time complexity is O(N + M) => worst case could be O(N^2)
*/
```

## Topological sorting
``` java
ArrayList<node> result = new ArrayList<node>();

// 1. get a HashMap of <Node, # of dependency>
HashMap<node, Integer> map = new HashMap<node, Integer>();
for (node : graph){
  for (neighbor: node.neighbors){
    if (map.containsKey(neighbors)){
      map.put(neighbor, map.get(neighbors) + 1);
    }else{
      map.put(neighbor, 1);    
    }
  }
}

// 2. start with node without dependency and put it into queue
QueueM<T> q = new LinkedList<T>();
for (node : graph){
  if (!map.containsKey(node)){
    q.offer(node);
  }
}

// 3. BFS
while(!q.isEmpty()){
  Node theNode = q.poll();
  result.add(neighbor)

  for (neighbor: theNode.neighbors){
    if (map.containsKey(nieghbor)){
      int count = map.get(neighbor) - 1;
      if (count == 0){
        q.offer(neighbor);
      }
      map.put(neighbor, count);
    }
  }
}

return result;
```
* O(N + E) 
Topoligical Order的四種問法
* 求任意1个拓扑序（Topological Order）
* 问是否存在拓扑序（是否可以被拓扑排序）=> 輸入的數目和排序出結果數目相同
* 求所有的拓扑序 DFS
* 求是否存在且仅存在一个拓扑序 => Queue中最多同时只有1个节点

* 127 Topological Sorting </br>
* 892 Alien Dictionary </br>
* 615 Course Schedule </br>

Todo:</br>
* 616 Course Schedule II 
* 605 Sequence Reconstruction

## Union find
* 589 Connecting Graph
* 590 Connecting Graph II








