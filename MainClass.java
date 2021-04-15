public class MainClass {
    public static void main(String args[])
    {
        Process p;
        try {
            p = Runtime.getRuntime().exec("rm -R img");
            p.waitFor();
            p = Runtime.getRuntime().exec("mkdir img");
            p.waitFor();
            p.destroy();
        } catch (Exception e) {}

        Graph<String> g = ReadFile.readfile("myGraph.txt");
        DrawGraph.drawgraph(g, null);
        FindAllPaths.printAllPaths(g, g.getFisrtVertex(), g.getLastVertex());
    }

}