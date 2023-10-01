package Collage;

import java.util.*;

public class Collage {
    static Scanner sc=new Scanner(System.in);
    String name;
    public ArrayList<Cource> allCources=new ArrayList<>();

    public Collage(String name){
        this.name=name;
    }

    public static class Cource{
        String name;
        double merit;
        public int seats;

        Cource(String name,int seats){
            this.name=name;
            this.seats=seats;
        }
    }

    public void addCource(){
        System.out.println("How Many Cource?");
        int n=sc.nextInt();

        for(int i=1;i<=n;i++){
            sc.nextLine();
            System.out.println("Enter Details Of Cource : "+i);
            System.out.print("Name : ");
            String name=sc.nextLine();
            System.out.print("Total Seats : ");
            int totalSeats=sc.nextInt();

            allCources.add(new Cource(name, totalSeats));
        }

    }

    public void collageInfo(){
        System.out.println("Name : "+name);
        System.out.println("-*-Availabel Cources:");
        for(int i=0;i<allCources.size();i++){
            Cource c=allCources.get(i);
            System.out.println((i+1)+" cource : "+c.name+ "  Seats : "+c.seats);
        }
    }

}
