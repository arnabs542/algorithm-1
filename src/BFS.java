/////////////////////////////
// BFS
// BFS on tree 
/////////////////////////////

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

/////////////////////////////
// BFS on graph 
// 需要紀錄visited node
// use HashSet/HashMap/arraylist to save visited node
// or if the node = 1, made the visited node = 0; so we will not consider it again
/////////////////////////////

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

/////////////////////////////
// Topoligical sorting
/////////////////////////////
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
