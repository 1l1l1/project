//Created by user on 08.03.2017.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Line arr[]=new Line[100];
        int q=0;
        while (sc.hasNextDouble()){
            double a=sc.nextDouble();
            double b=sc.nextDouble();
            arr[q]=new Line(a,b);
            q++;
        }
        double min=-1;
        Line a=new Line();
        Line b=new Line();
        Line c=new Line();
        for (int i=0; i<q; i++)
            for (int j = i; j < q; j++)
                for (int k = j; k < q; k++)
                    if (!(Line.isCoinciding(arr[i], arr[j]) || Line.isCoinciding(arr[i], arr[k]) || Line.isCoinciding(arr[k], arr[j])))
                        if (!(Line.isParallel(arr[i], arr[j]) || Line.isParallel(arr[i], arr[k]) || Line.isParallel(arr[k], arr[j])))
                            if (!(Line.isIntersectInOnePoint(arr[i], arr[j], arr[k]))){
                                Triangle t=new Triangle(arr[i], arr[j], arr[k]);
                                if ((t.getArea() < min || min == -1) && t.getArea()!=0) {
                                    min = t.getArea();
                                    a = arr[i];
                                    b = arr[j];
                                    c = arr[k];
                                }}
        System.out.println(new Triangle(a,b,c));
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        System.out.println("c: "+c);
        System.out.println("area="+new Triangle(a,b,c).getArea());
    }
}
