package graph;

import drawing.DrawingApi;

import java.util.List;

public class MatrixGraph extends Graph {
    private final List<List<Boolean>> matrix;

    public MatrixGraph(DrawingApi drawingApi, int n, List<List<Boolean>> matrix) {
        super(drawingApi, n);
        this.matrix = matrix;
        if (matrix.size() != n) {
            throw new RuntimeException("Incorrect graph size");
        }
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).size() != n) {
                throw new RuntimeException("Matrix should be square");
            }
            for (int j = i + 1; j < n; j++) {
                if (matrix.get(i).get(j) != matrix.get(j).get(i)) {
                    throw new RuntimeException("Graph shouldn't be directed");
                }
            }
        }
    }

    @Override
    public void drawGraph() {
        drawVertices();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix.get(i).get(j)) {
                    drawEdge(i + 1, j + 1);
                }
            }
        }
    }
}
