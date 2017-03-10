/**
 * Created by user on 08.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        Line a=new Line(-2,4);
        Line b=new Line(1/3,5);
        System.out.println(Line.pointOfIntersection(a,b));
        System.out.println( (a.k*(b.d-a.d)/(a.k-b.k)+a.d));
    }
}
