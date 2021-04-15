import java.io.File;
import java.io.FileWriter;   
import java.io.IOException;
import java.util.*;

public class DrawGraph {
    

    public static void drawgraph(Graph<String> g, List<String> path) {
        toDotFile(g, path);
        String img = "./img/path";
        int i = 0;
        Process p;
        String imgName = img;
        String checkName = imgName + ".jpg";
        File imgGraph = new File (checkName);

        while (imgGraph.exists() && ! imgGraph.isDirectory()) {
            i++;
            imgName = img + i;
            checkName = imgName + ".jpg";
            imgGraph = new File (checkName);
        }
        if (path == null) checkName = "graph.jpg";
        try {
            p = Runtime.getRuntime().exec("dot -T jpg .graph.dot -o " + checkName);
            p.waitFor();
            p = Runtime.getRuntime().exec("rm .graph.dot");
            p.waitFor();
            p.destroy();
        } catch (Exception e) {}
    }

    private static void toDotFile(Graph<String> g, List<String> path) {
        try {
            FileWriter Writer = new FileWriter(".graph.dot");
            Writer.write("strict digraph mygraph { \n");
            Writer.write(g.toString());
            if (path != null){
                Writer.write("\t" + path.get(0));
                for (int i = 1; i < path.size(); i++) {
                    Writer.write(" -> " + path.get(i));
                }
            }
            Writer.write(" [color=red]\n}");
            Writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}