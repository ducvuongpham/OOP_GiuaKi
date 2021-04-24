import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Graph {
  
    private String graphName = "";
    private Map<String, List<String> > map = new HashMap<>();
    
    public void addVertex(String s)
    {
        map.put(s, new LinkedList<String>());
    }
  
    public void addEdge(String source,
                        String destination,
                        boolean bidirectional)
    {
  
        if (!map.containsKey(source))
            addVertex(source);
  
        if (!map.containsKey(destination))
            addVertex(destination);
        
        if (map.get(source).contains(destination) == false)
        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }
  
    public int getVertexCount()
    {
        return map.keySet().size();
        
    }
  
    public int getEdgesCount(boolean bidirection)
    {
        int count = 0;
        for (String v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        return count;
    }

    public void hasVertex(String s)
    {
        if (map.containsKey(s)) {
            System.out.println("The graph contains "
                               + s + " as a vertex.");
        }
        else {
            System.out.println("The graph does not contain "
                               + s + " as a vertex.");
        }
    }
  
    public void hasEdge(String s, String d)
    {
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between "
                               + s + " and " + d + ".");
        }
        else {
            System.out.println("The graph has no edge between "
                               + s + " and " + d + ".");
        }
    }

    public List<String> getAdjacency(String n) {
        return map.get(n);
    }

    public Set<String> getVertexList() {
        return map.keySet();
    }

    public String getFisrtVertex() {
        String first = map.entrySet().iterator().next().getKey();
        for (String v : map.keySet()) {
            if (first.compareTo(v) > 0) {
                first = v;
            }
        }
        return first;
    }

    public String getLastVertex() {
        String last = map.entrySet().iterator().next().getKey();
        for (String v : map.keySet()) {
            if (last.compareTo(v) < 0) {
                last = v;
            }
        }
        return last;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("");
        for (String v : map.keySet()) {
            builder.append("\t" + v + " -> {");
            for (String w : map.get(v)) {
                builder.append(w + " ");
            }
            builder.append("}\n");
        }
        return builder.toString();
    }

    public String getGraphName() {
        return this.graphName;
    }

    public void setGraphName(String filename) {
        String[] paths = filename.split("\\.");
        this.graphName = paths[0];
        for (int i = 1; i < paths.length - 1; i++) {
            this.graphName = this.graphName + paths[i];
        }
    }
}
  
