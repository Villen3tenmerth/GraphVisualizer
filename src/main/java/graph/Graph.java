package graph;

import drawing.DrawingApi;
import geometry.Vector;

import static geometry.Utils.rotate;

public abstract class Graph {
    protected final DrawingApi drawingApi;
    protected final int n;

    public Graph(DrawingApi drawingApi, int n) {
        this.drawingApi = drawingApi;
        this.n = n;
    }

    public abstract void drawGraph();

    protected Vector getVertexCenter(int v) {
        long width = drawingApi.getDrawingAreaWidth();
        long height = drawingApi.getDrawingAreaHeight();
        Vector c = new Vector(width / 2.0, height / 2.0);
        double r = Math.min(width, height) / 3.0;
        Vector dir = new Vector(0, r);
        double angle = 2 * Math.PI / n;
        return c.add(rotate(dir, angle * (v - 1)));
    }

    protected void drawVertices() {
        long width = drawingApi.getDrawingAreaWidth();
        long height = drawingApi.getDrawingAreaHeight();
        double radius = Math.min(width, height) / (7.0 * n);
        for (int i = 1; i <= n; i++) {
            drawingApi.drawCircle(getVertexCenter(i), radius);
        }
    }

    protected void drawEdge(int v, int u) {
        drawingApi.drawLine(getVertexCenter(v), getVertexCenter(u));
    }
}
