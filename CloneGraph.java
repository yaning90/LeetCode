/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return null;
        }
        
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hm = new HashMap<>();
        
        // clone nodes
        int start=0;
        hm.put(node, new UndirectedGraphNode(node.label));
        nodes.add(node);
        while(start<nodes.size()){
            UndirectedGraphNode head = nodes.get(start);
            start++;
            for(int i=0; i<head.neighbors.size();i++){
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if(!hm.containsKey(neighbor)){
                    hm.put(neighbor,new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }
        // clone neighbors
        for(int i=0; i<nodes.size();i++){
            UndirectedGraphNode newNode = hm.get(nodes.get(i)); // 给新的点加neighbors
            for(int j=0; j<nodes.get(i).neighbors.size();j++){
                newNode.neighbors.add(hm.get(nodes.get(i).neighbors.get(j)));
            }
        }
        return hm.get(node);
    }
}
