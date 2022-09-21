import java.util.Scanner;

class multiplier{
    int multiply(int a,int b){
        int p=a*b;
        return p;
    }

    float multiply(float a,float b){
        float p=a*b;
        return p;
    }

    public static void main(String[] args){
        multiplier x=new multiplier();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 if integers and 0 if float: ");
        int p=sc.nextInt();
        if(p==1) {
            System.out.println("Enter the integers: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int y = x.multiply(a, b);
            System.out.println("Product is "+y);
        }
        else if(p==0) {
            System.out.println("Enter the float values: ");
            float c = sc.nextFloat();
            float d = sc.nextFloat();
            float z = x.multiply(c, d);
            System.out.println("Product is " + z);
        }
        else{
            System.out.println("Invalid entry");
        }
    }
}
