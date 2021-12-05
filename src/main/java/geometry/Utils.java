package geometry;

public class Utils {
    public static Vector rotate(Vector v, double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        return new Vector(v.x * cos + v.y * -sin, v.x * sin + v.y * cos);
    }
}
