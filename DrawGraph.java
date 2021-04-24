import java.io.File;
import java.io.FileWriter;   
import java.io.IOException;
import java.util.List;

public class DrawGraph {
    public static void drawgraph(Graph g, List<String> path, String folderName, String fileNameExtension, int i) throws InterruptedException {
        toDotFile(g, path);

        String baseName = "./" + folderName + "/" + g.getGraphName();
        String imgName = "";

        if (path == null) imgName = baseName + "." + fileNameExtension;
        else imgName = baseName + "_path" + i + "." + fileNameExtension;

        ExecShell.Execute("dot -?", 2, "\nHaven't you install graphviz?" +
                                       "\nTry \"sudo apt install graphviz\"" +
                                       "\nOr go to: https://graphviz.org/download").waitFor();

        new File("./" + folderName).mkdir();

        ExecShell.Execute("dot -T" + fileNameExtension + " .graph.dot -o " + imgName).waitFor();
    }

    private static void toDotFile(Graph g, List<String> path) {
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
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}