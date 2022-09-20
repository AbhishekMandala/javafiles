import java.util.Scanner;

public class Rect {
    public void area (int l,int b) {
        System.out.println("Area=" + l * b);
    }
    public void perimeter (int l,int b) {
        System.out.println("Perimeter=" + 2 * (l + b));
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int b = s.nextInt();
        Rect c=new Rect();
        c.area(l,b);
        c.perimeter(l,b);
    }
}
