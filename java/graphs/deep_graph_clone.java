
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class deep_graph_clone {
    public static HashMap<Node, Node> hash;
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        hash = new HashMap<>();
        return dfsClone(node);
    }
    public static Node dfsClone(Node node){
        if(hash.get(node) != null){
            return hash.get(node);
        }
        Node clone = new Node(node.val);
        hash.put(node,clone);
        for(Node nei : node.neighbors){
            clone.neighbors.add(dfsClone(nei));
        }

        return clone; 
       
    }
    // public void recurse(Node node){
    //     List<Node> nextNodes = new ArrayList<>();
    //     for(Node neighbor: node.neighbors){
    //         if(createdClones.get(neighbor.val) == null || !finishedNodes.contains(neighbor.val)){
    //             Node newGuy = new Node(neighbor.val);
    //             nextNodes.add(neighbor);
    //             createdClones.put(neighbor.val,newGuy);
    //             createdClones.get(node.val).neighbors.add(newGuy);
    //             newGuy.neighbors.add(node);
    //         }
    //     }
    //     finishedNodes.add(node.val);

    //     for(Node next: nextNodes){
    //         recurse(next);
    //     }
    // }
}