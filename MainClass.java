public class MainClass {
    public static void main(String args[]) throws InterruptedException
    {
        Graph g = ReadFile.readfile("myGraph.txt");
        FindAllPaths.printAllPaths(g, null, null, "path");
        FindAllPaths.printAllPaths(g, g.getFisrtVertex(), g.getLastVertex(), "path");
    }
}