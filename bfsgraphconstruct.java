import java.util.*;
public class bfsgraphconstruct{
    private Map<Integer, List<Integer>> adjList;
    public bfsgraphconstruct() {
        adjList=new HashMap<>();
    }
    public void addVertex(int vertex){
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }
    public void addEdge(int from,int to){
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(to);
    }
    public void bfs(int start){
        Set<Integer>visited = new HashSet<>();
        Queue<Integer>queue = new LinkedList<>();
        visited.add(start);
        queue.offer(start);
        System.out.print("BFS Traversal starting from vertex " + start + ": ");
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for(int neighbor:adjList.get(vertex)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        bfsgraphconstruct graph = new bfsgraphconstruct();
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        graph.bfs(2);
    }
}
