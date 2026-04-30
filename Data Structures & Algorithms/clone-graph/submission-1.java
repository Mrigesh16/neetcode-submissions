/*
Definition for a Node.
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
*/

// class Solution {

//     Map<Node, Node> map = new HashMap<>();

//     public Node cloneGraph(Node node) {
//         if (node == null) return null;

//         if (map.containsKey(node))
//             return map.get(node);

//         Node clone = new Node(node.val);
//         map.put(node, clone);

//         for (Node nei : node.neighbors) {
//             clone.neighbors.add(cloneGraph(nei));
//         }

//         return clone;
//     }
// }

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        map.put(node, new Node(node.val));
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node nei : curr.neighbors) {

                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val));
                    queue.offer(nei);
                }

                map.get(curr).neighbors.add(map.get(nei));
            }
        }

        return map.get(node);
    }
}