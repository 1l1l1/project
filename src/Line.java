import static java.lang.System.err;
//Created by user on 08.03.2017.
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
            k=Math.round(((a.getY()-b.getY())/(a.getX()-b.getX()))*1000)/1000;
        if (k==0)
            d=a.getY();
        else
            d=Math.round((a.getY()-k*a.getX())*1000)/1000;
    }
    double getK() {
        return k;
    }
    public void setK(double k) {
        this.k = k;
    }
    double getD() {
        return d;
    }
    public void setD(double d) {
        this.d = d;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (Double.compare(line.k, k) != 0) return false;
        return Double.compare(line.d, d) == 0;

    }
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(k);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(d);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
        if (Line.isCoinciding(a,b))
            return false;
        return a.k==b.k;
    }
    static boolean isCoinciding(Line a, Line b){
        return (a.k==b.k && a.d==b.d);
    }
    static boolean isIntersectInOnePoint(Line a, Line b, Line c){
        return (Line.intersection(a,b)==Line.intersection(b,c));
    }
    static Point intersection(Line a, Line b){
        if (Line.isCoinciding(a,b)){
            err.println("Ошибка в методе static Point intersection(Line a, Line b): Данные прямые совпадают");
            return null;
        }
        if (Line.isParallel(a,b)){
            err.println("Ошибка в методе static Point intersection(Line a, Line b): Данные прямые параллельны");
            return null;
        }
        if (a.getK()==0) {return new Point((a.getD()-b.getD())/b.getK(),a.getD());}
        if (b.getK()==0) {return new Point((b.getD()-a.getD())/a.getK(),b.getD());}
        return new Point ((b.d-a.d)/(a.k-b.k),(a.getK()*(b.getD()-a.getD())/(a.getK()-b.getK())+a.getD()));
    }
}