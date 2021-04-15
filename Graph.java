import java.util.*;
  
class Graph<T> {
  
    private Map<T, List<T> > map = new HashMap<>();
  
    public void addVertex(T s)
    {
        map.put(s, new LinkedList<T>());
    }
  
    public void addEdge(T source,
                        T destination,
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
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        return count;
    }

    public void hasVertex(T s)
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
  
    public void hasEdge(T s, T d)
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

    public List<T> getAdjacency(T n) {
        return map.get(n);
    }

    public Set<T> getVertexList() {
        return map.keySet();
    }

    public String getFisrtVertex() {
        String first = map.entrySet().iterator().next().getKey().toString();
        for (T v : map.keySet()) {
            if (first.compareTo(v.toString()) > 0) {
                first = v.toString();
            }
        }
        return first;
    }

    public String getLastVertex() {
        String last = map.entrySet().iterator().next().getKey().toString();
        for (T v : map.keySet()) {
            if (last.compareTo(v.toString()) < 0) {
                last = v.toString();
            }
        }
        return last;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("");
        for (T v : map.keySet()) {
            builder.append("\t" + v.toString() + " -> {");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("}\n");
        }
        return (builder.toString());
    }
}
  
