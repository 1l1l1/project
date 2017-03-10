/**
 * Created by user on 08.03.2017.
 */
public class Point {
    private double x;
    private double y;
    Point(double a, double b){
        x=a;
        y=b;
    }
    Point(double a){
        new Point(a,0);
    }
    Point(){
        new Point(0);
    }
    @Override
    public String toString() {
        return "Point(" +
                "" + x +
                ", " + y +
                ')';
    }
    double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    static boolean isLieOnLine(Point a, Point b, Point c){
        if (a.equals(b)||a.equals(c)||b.equals(c)) {
            System.err.println("Ошибка в методе static boolean isLieOnLine(Point a, Point b, Point c): Данные точки совпадают");
            return Boolean.parseBoolean(null);
        }
        else
            if (a.x==0 && b.x==0 || c.x==0 && b.x==0 || a.x==0 && c.x==0)
                return a.x == 0 && b.x == 0 && c.x == 0;
            else
                return (Line.isCoinciding(new Line(a,b),(new Line(b,c))));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare(point.x, x) != 0) return false;
        return Double.compare(point.y, y) == 0;

    }
}