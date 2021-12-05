import drawing.AwtDrawingApi;
import drawing.DrawingApi;
import drawing.JavaFxDrawingApi;
import graph.Graph;
import graph.ListGraph;
import graph.MatrixGraph;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args == null || args.length != 2 || args[0] == null || args[1] == null) {
            help();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        try {
            DrawingApi drawingApi = getApi(args[0]);
            Graph graph = getGraph(drawingApi, args[1], scanner);
            graph.drawGraph();
            if (drawingApi instanceof JavaFxDrawingApi) {
                JavaFxDrawingApi.run();
            }
        } catch (RuntimeException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }

    private static void help() {
        System.err.println("Usage: GraphVisualizer awt|jfx list|matrix");
    }

    private static DrawingApi getApi(String type) {
        if (type.equals("awt")) {
            return new AwtDrawingApi();
        } else if (type.equals("jfx")) {
            return new JavaFxDrawingApi();
        } else {
            throw new RuntimeException("Invalid api type: " + type);
        }
    }

    private static Graph getGraph(DrawingApi drawingApi, String type, Scanner scanner) {
        if (type.equals("list")) {
            return getListGraph(drawingApi, scanner);
        } else if (type.equals("matrix")) {
            return getMatrixGraph(drawingApi, scanner);
        } else {
            throw new RuntimeException("Invalid graph type: " + type);
        }
    }

    private static ListGraph getListGraph(DrawingApi drawingApi, Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new Pair<>(u, v));
        }
        return new ListGraph(drawingApi, n, edges);
    }

    private static MatrixGraph getMatrixGraph(DrawingApi drawingApi, Scanner scanner) {
         int n = scanner.nextInt();
         List<List<Boolean>> matrix = new ArrayList<>();
         for (int i = 0; i < n; i++) {
             matrix.add(new ArrayList<>());
             for (int j = 0; j < n; j++) {
                 if (scanner.nextInt() == 0) {
                     matrix.get(i).add(false);
                 } else {
                     matrix.get(i).add(true);
                 }
             }
         }
         return new MatrixGraph(drawingApi, n, matrix);
    }
}
