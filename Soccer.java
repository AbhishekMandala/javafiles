import java.util.*;
class sports{
    String Name(){
        return "Kabaddi";
    }
    int getNumberOfTeamMembers(){
        return 7;
    }
}
class Soccer extends sports{
    String Name(){
        return "Cricket\t";
    }
    int getNumberOfTeamMembers(){
        return 11;
    }
    public static void main(String args[]){
        Soccer s=new Soccer();
        String str=s.Name();
        int a=s.getNumberOfTeamMembers();
        System.out.println(str+a);
    }
}
