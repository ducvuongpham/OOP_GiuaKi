import java.util.*;

public class FindAllPaths {

	public static void printAllPaths(Graph<String> g, String s, String d)
	{
		Map<String, Boolean > isVisited = new HashMap<>();
		for (String vertex : g.getVertexList()) {
			isVisited.put(vertex, false);
		}

		ArrayList<String> pathList = new ArrayList<>();
		pathList.add(s);
		printAllPathsUtil(g, s, d, isVisited, pathList);
	}

	private static void printAllPathsUtil(Graph<String> g, String u, String d,
								Map<String, Boolean > isVisited,
								List<String> localPathList)
	{
		if (u.equals(d)) {
			//System.out.println(localPathList);
			DrawGraph.drawgraph(g, localPathList);
		}
		isVisited.put(u, true);
		for (String i : g.getAdjacency(u)) {
			if (!isVisited.get(i)) {
				localPathList.add(i);
				printAllPathsUtil(g, i, d, isVisited, localPathList);
				localPathList.remove(i);
			}
		}
		isVisited.put(u, false);
	}
}

