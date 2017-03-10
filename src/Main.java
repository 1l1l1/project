/**
 * Created by user on 08.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        Point a= new Point(0,0);
        Point b= new Point(0,0);
        Point c= new Point(0,0);
        System.out.println(new Line(a,b));
        System.out.println(new Line(c,b));
        System.out.println(new Line(c,a));
        System.out.println(Point.isLieOnLine(a,b,c));
        System.out.println(a.equals(b));
    }
}
