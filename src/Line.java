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
    Line(double k) {
        this.k = k;
        d=0;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (Double.compare(line.k, k) != 0) return false;
        return Double.compare(line.d, d) == 0;

    }
    static boolean isParallel(Line a, Line b){
        return a.k==b.k;
    }
}
