# BFS
## Review

## BFS on tree
==> queue
``` java
Queue<TreeNode> q = new LinkedList<TreeNode>();
q.offer(root);
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

## BFS on graph
==> 要記錄去過的點 </br>
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


