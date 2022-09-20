import java.util.Scanner;
class arithmetic {
    public int add(int a,int b){
        int sum=a+b;
        return sum;
    }
}
class adder extends arithmetic{
    public static void main(String[] args){
        adder ad=new adder();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the numbers: ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int s=ad.add(a,b);
        System.out.println("Sum="+s);
    }
}


