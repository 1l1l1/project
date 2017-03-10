import static java.lang.System.*;
/**
 * Created by user on 08.03.2017.
 */
class Line {
    private double k;
    private double d;
    Line(double a, double b){
        k=a;
        d=b;
    }
    Line(double a) {
        d=a;
        k=0;
    }
    Line() {
        k=1;
        d=0;
    }
    Line(Point a, Point b){
        if (a.getX()-b.getX()==0 || a.getY()-b.getY()==0)
            if(a.getY()-b.getY()==0)
                if (a.equals(b))
                    err.println("Ошибка в методе Line(Point a, Point b): Данные точки совпадают");
                else
                    k=0;
            else
                err.println("Ошибка в методе Line(Point a, Point b): Данная прямая не является функцией, построение невозможно");
        else
            k=(a.getY()-b.getY())/(a.getX()-b.getX());
        if (k==0)
            d=a.getY();
        else
            d=a.getY()-k*a.getX();
    }
    public double getK() {
        return k;
    }
    public void setK(double k) {
        this.k = k;
    }
    public double getD() {
        return d;
    }
    public void setD(double d) {
        this.d = d;
    }
    @Override
    public String toString() {
        if (k==0)
            return "y="+d;
        else {
            if (d > 0)
                return "y=" + k + "*x+" + d;
            if (d==0)
                return "y=" + k + "*x";
            if (d<0)
                return "y=" + k + "*x" + d;
            else
                return null;
        }
    }
    static boolean isParallel(Line a, Line b){
        return a.k==b.k;
    }
    static boolean isCoinciding(Line a, Line b){
        return (a.k==b.k && a.d==b.d);
    }
    static Point pointOfIntersection(Line a, Line b){
        if (Line.isCoinciding(a,b)){
            err.println("Ошибка в методе static Point pointOfIntersection(Line a, Line b): Данные прямые совпадают");
            return null;
        }
        if (Line.isParallel(a,b)){
            err.println("Ошибка в методе static Point pointOfIntersection(Line a, Line b): Данные прямые параллельны");
            return null;
        }
        if (a.k==0) return new Point((a.d-b.d)/b.k,a.d);
        if (b.k==0) return new Point((b.d-a.d)/a.k,b.d);
        return new Point ((b.d-a.d)/(a.k-b.k),a.k*(b.d-a.d)/(a.k-b.k)+a.d);
    }
}