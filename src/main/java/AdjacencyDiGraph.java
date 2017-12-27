
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class AdjacencyDiGraph <Vertex ,Edge> implements Digraph<Vertex,Edge>{

    protected Set<Vertex> vertices= new HashSet<Vertex>();
    protected Set<Edge> edges= new HashSet<Edge>();
    protected Map<Vertex, List<Edge> > vertexToEdges= new HashMap<Vertex, List<Edge> >();
    private Map<Edge, Vertex> edgeToSrc= new HashMap<Edge, Vertex>();
    private Map<Edge, Vertex> edgeToDest= new HashMap<Edge, Vertex>();
    private Map<String, Vertex> nameToVertex= new HashMap<String, Vertex>();

    public AdjacencyDiGraph(){
    }

    public void addVertex(Vertex v){
        if(!vertices.contains(v)){
            vertices.add(v);
            vertexToEdges.put(v, new ArrayList<Edge>());
        }
    }

    public List<Vertex> getVertices(){
        return new ArrayList<Vertex>(vertices);
    }

    public void addEdge(Edge e, Vertex src, Vertex dest){
        addVertex(src);
        addVertex(dest);
        edges.add(e);
        edgeToSrc.put(e, src);
        edgeToDest.put(e, dest);
        vertexToEdges.get(src).add(e);
    }

    public List<Edge> getEdges(){
        return new ArrayList<Edge>(edges);
    }

    public List<Vertex> getAdjacentVertices(Vertex src){
        List<Vertex> res= new ArrayList<Vertex>();
        for(Edge e : vertexToEdges.get(src)){
            res.add(edgeToDest.get(e));
        }
        return res;
    }

    public List<Edge> getOutgoingEdges(Vertex v){
        return Collections.unmodifiableList(vertexToEdges.get(v));
    }

    public Vertex getSource(Edge e){
        return edgeToSrc.get(e);
    }

    public Vertex getDestination(Edge e){
        return edgeToDest.get(e);
    }

    public void nameVertex(String name, Vertex v) {
        nameToVertex.put(name, v);
    }

    public Vertex getVertexByName(String name){
        return nameToVertex.get(name);
    }


    // should use java.util.Optional
    public String getNameOrNullByVertex(Vertex v){
        for(Map.Entry<String, Vertex> e: nameToVertex.entrySet()){
            if(e.getValue().equals(v)){
                return e.getKey();
            } }
        return null;
    }

    public void namevertex(String name,Vertex v){
        //TODO
    }

    public void getvertexByame(String name){

        //TODO
    }

    public List<String> getNames(){
        return new ArrayList<String>(nameToVertex.keySet());
    }

    public boolean areConnected(Vertex src, Vertex dest){
        return false;
        // TODO !
    }

    public boolean areConnected(String src, String dest){
        return areConnected(getVertexByName(src), getVertexByName(dest));
    }

    public List<Vertex> shortestPath(Vertex src, Vertex dest){
        // TODO !
        return new ArrayList<>();
    }
    public List<Vertex> shortestPath(String src, String dest){
        return shortestPath(getVertexByName(src), getVertexByName(dest));
    }

}
