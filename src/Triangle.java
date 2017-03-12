import static java.lang.System.err;
//Created by user on 08.03.2017.
class Triangle {
    private Point a;
    private Point b;
    private Point c;
    Triangle(Point x, Point y, Point z) {
        if (x.equals(y) || x.equals(z) || y.equals(z)){
            err.println("Ошибка в методе Triangle(Point x, Point y, Point z): Две или три данные точки совпадают");
            return;
        }
        if ((new Line(x,y)).equals(new Line(y,z))){
            err.println("Ошибка в методе Triangle(Point x, Point y, Point z): Данные точки лежат на одной прямой");
            return;
        }
        this.a = x;
        this.b = y;
        this.c = z;
    }
    Triangle(Line x, Line y, Line z){
        if (Line.isCoinciding(x,y)|| Line.isCoinciding(z,y)|| Line.isCoinciding(x,z) || Line.isParallel(x,y) || Line.isParallel(z,y) || Line.isParallel(x,z)){
            err.println("Ошибка в методе Triangle(Line x, Line y, Line z): Две или три данные прямые совпадают или параллельны");
            return;
        }
        if (Line.isIntersectInOnePoint(x,y,z)) {
            err.println("Ошибка в методе Triangle(Line x, Line y, Line z): Три данные прямые пересекаются в одной точке");
            return;
        }
        a=Line.intersection(x,y);
        b=Line.intersection(x,z);
        c=Line.intersection(y,z);
    }
    @Override
    public String toString() {
        return "Triangle{("+a.getX()+','+a.getY()+')'+
                ";("+b.getX()+','+b.getY()+')'+
                ";("+c.getX()+","+c.getY()+')'+
                '}';
    }
    double getArea(){
        return Math.abs((((a.getX()-c.getX())*(b.getY()-c.getY()))-(b.getX()-c.getX())*(a.getY()-c.getY()))/2);
    }
    public Point getA() {
        return a;
    }
    public void setA(Point x) {
        if (x.equals(b) || x.equals(c)){
            err.println("Ошибка в методе public void setA(Point x): Данная точка совпадает с другой вершиной");
            return;
        }
        if ((new Line(x,b)).equals(new Line(x,c))){
            err.println("Ошибка в методе public void setA(Point x): Данные точка лежит с двумя другими вершинами на одной прямой");
            return;
        }
        this.a = x;
    }
    public Point getB() {
        return b;
    }
    public void setB(Point x) {
        if (x.equals(a) || x.equals(c)){
            err.println("Ошибка в методе public void setB(Point x): Данная точка совпадает с другой вершиной");
            return;
        }
        if ((new Line(x,a)).equals(new Line(x,c))){
            err.println("Ошибка в методе public void setB(Point x): Данные точка лежит с двумя другими вершинами на одной прямой");
            return;
        }
        this.b = x;
    }
    public Point getC() {
        return c;
    }
    public void setC(Point x) {
        if (x.equals(a) || x.equals(c)){
            err.println("Ошибка в методе public void setC(Point x): Данная точка совпадает с другой вершиной");
            return;
        }
        if ((new Line(x,b)).equals(new Line(x,a))){
            err.println("Ошибка в методе public void setC(Point x): Данные точка лежит с двумя другими вершинами на одной прямой");
            return;
        }
        this.c = x;
    }
}