
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static Graph readfile(String filename) {
        Graph graph = new Graph();
        graph.setGraphName(filename);
        try {
            File Object = new File(filename);
            Scanner Reader = new Scanner(Object);
            while (Reader.hasNextLine()) {
            String line = Reader.nextLine().trim();
            String[] word = line.split("\\s+");
            for (int i = 1; i < word.length; i++) {
                if(word[0].equals(word[i]) == false)
                    graph.addEdge(word[0], word[i], false);
            }
        }
        Reader.close();
        System.out.println("\nGraph name: " + graph.getGraphName());
        return graph;
        }   
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}