import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static Graph<String> readfile(String filename) {
        Graph<String> graph = new Graph<String>();
        try {
            File Object = new File(filename);
            Scanner Reader = new Scanner(Object);
            while (Reader.hasNextLine()) {
            String line = Reader.nextLine();
            String[] word = line.split("\\s");
            for (int i = 1; i < word.length; i++) {
                graph.addEdge(word[0], word[i], false);
            }
        }
        Reader.close();
        return graph;
        }   
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}