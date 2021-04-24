import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllPaths {


	private static int i = 0;
	public static void printAllPaths(Graph g, String s, String d, String folderName, String fileNameExtention) throws InterruptedException
	{
		if (s == null && d == null) {
			DrawGraph.drawgraph(g, null, folderName, fileNameExtention, 0);
			new File("./.graph.dot").delete();
			return;
		}

		Map<String, Boolean> isVisited = new HashMap<>();
		for (String vertex : g.getVertexList()) {
			isVisited.put(vertex, false);
		}

		ArrayList<String> pathList = new ArrayList<>();
		pathList.add(s);
		printAllPathsUtil(g, s, d, isVisited, pathList, folderName, fileNameExtention);
		new File("./.graph.dot").delete();
		System.out.println("\nAll printed! :D");
	}

	public static void printAllPaths(Graph g, String s, String d, String folderName) throws InterruptedException
	{
		printAllPaths(g, s, d, folderName, "jpg");
	}

	public static void printAllPaths(Graph g, String s, String d) throws InterruptedException
	{
		printAllPaths(g, s, d, "graph", "jpg");
	}


	private static void printAllPathsUtil(Graph g, String u, String d,
								Map<String, Boolean > isVisited,
								List<String> localPathList, String folderName, String fileNameExtension) throws InterruptedException
	{
		if (u.equals(d)) {
			DrawGraph.drawgraph(g, localPathList, folderName, fileNameExtension, i++);
		}
		isVisited.put(u, true);
		for (String i : g.getAdjacency(u)) {
			if (!isVisited.get(i)) {
				localPathList.add(i);
				printAllPathsUtil(g, i, d, isVisited, localPathList, folderName, fileNameExtension);
				localPathList.remove(i);
			}
		}
		isVisited.put(u, false);
	}
}

