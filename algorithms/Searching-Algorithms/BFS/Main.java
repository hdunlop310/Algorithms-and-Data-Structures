import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		String inputFileName = args[0];
		FileReader reader = new FileReader(inputFileName);
		Scanner in = new Scanner(reader);
		String line = in.nextLine();
    Scanner lineScanner = new Scanner(line);
		int numVertices = lineScanner.nextInt();

        // insert code here to build the graph from the input file
        // create empty graph with correct number of vertices
		// then go through input line by line adding edges to the graph

		Graph new_graph = new Graph(numVertices);
		for (int i = 0; i < numVertices; i++){
			line = in.nextLine();
			lineScanner = new Scanner(line);
			for (int j = 0; j < numVertices; j++)
				if (lineScanner.nextInt() == 1)
					new_graph.getVertex(i).addToAdjList(j);
		}

		reader.close();

		new_graph.bfs();

		String outputFileName = args[1];
		FileWriter writer = new FileWriter(outputFileName);

// insert code here to output the predecessor information
		new_graph.dfs();
		writer.write("dfs: ");
		// output the predecessor information
		for (int i=0; i < numVertices; i++)
			writer.write(" " + new_graph.getVertex(i).getPredecessor());

		writer.write("\n");

		// conduct the breadth-first search
		new_graph.bfs();
		writer.write("bfs: ");
		// output the predecessor information
		for (int i=0; i < numVertices; i++)
			writer.write(" " + new_graph.getVertex(i).getPredecessor());

		writer.close();
		in.close();
		lineScanner.close();

	}

}
