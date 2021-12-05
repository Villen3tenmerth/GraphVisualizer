package geometry;

public class Vector {
    public double x, y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector other) {
        return new Vector(x + other.x, y + other.y);
    }

    public Vector sub(Vector other) {
        return new Vector(x - other.x, y - other.y);
    }

    public Vector mul(double c) {
        return new Vector(x * c, y * c);
    }

    public double len() {
        return Math.hypot(x, y);
    }
}
