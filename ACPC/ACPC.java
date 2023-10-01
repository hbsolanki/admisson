package ACPC;

import Collage.Collage;
import Collage.Collage.Cource;
import Student.Student;
import java.util.*;

public class ACPC {
    static Scanner sc=new Scanner(System.in);

    public static Student addStudent(){
        System.out.print("Enter Student Name : ");
        String name=sc.nextLine();
        System.out.print("set Password : ");
        String pass=sc.nextLine();
        System.out.print("Enter Marks OF Maths : ");
        float math=sc.nextFloat();
        System.out.print("Enter Marks OF Chemistry : ");
        float chemistry=sc.nextFloat();
        System.out.print("Enter Marks OF Physics : ");
        float physics=sc.nextFloat();
        System.out.println();
        int studentId=(int)(Math.random()*1000);
        System.out.println("Your id : "+studentId);

        Student s=new Student(name, studentId,pass, math, chemistry, physics);
        return s;
    }

    public static Collage addCollage(){
        System.out.print("Enter Collage : ");
        String name=sc.nextLine();
        Collage c=new Collage(name);
        c.addCource();
        return c;
    }

    public static void choiceFilling(Student s,ArrayList<Collage> allCollages){
        HashMap<Collage.Cource,Collage> selection=new HashMap<>();
        if(allCollages.size()==0){
            System.out.println("No Any Collages Availabel");
            return;
        }
        
        int num;
        do{
            System.out.println("Select Collage");
            showAllCollages(allCollages);
            System.out.print("Enter Number Collage Number : ");
            num=sc.nextInt();
            
            if(num>allCollages.size() || num<1){
                System.out.println("invalid Option");
                continue;
            }

            Collage selectCollage=allCollages.get(num-1);
            selectCollage.collageInfo();
            System.out.print("Enter cource Number : ");
            int cNum=sc.nextInt();
            Collage.Cource selectCource=selectCollage.allCources.get(num-1);
            selection.put(selectCource,selectCollage);
            System.out.println();
            System.out.println("Add More Collage=1 or Exit=0");
            num=sc.nextInt();
            if(num!=1){
                break;
            }

        }while(true);
        s.selection=selection;
    }

    public static void showAllCollages(ArrayList<Collage> allCollages){
        for(int i=0;i<allCollages.size();i++){
            System.out.println("-*-*->Collage : "+(i+1));
            allCollages.get(i).collageInfo();
            System.out.println();
        }
    }

    public static void getAddmissionLetter(Student s,ArrayList<Student> allStudents,ArrayList<Collage> allCollages){
        result(allStudents, allCollages);
        if(s.cource!=null && s.collage!=null){
            System.out.println("Name : "+s.name);
            System.out.println("id : "+s.studentId);
            System.out.println("Collage : "+s.collage);
            System.out.println("Cource : "+s.cource);
        }
    }

    public static void result(ArrayList<Student> allStudents,ArrayList<Collage> allCollages){
        PriorityQueue<Student> pq=new PriorityQueue<>(new Comparator<Student>() {
            public int compare(Student s1,Student s2){
                return (int) (s2.merit() - s1.merit());
            }
        });
        for(int i=0;i<allStudents.size();i++){
            Student s=allStudents.get(i);
            if(s.selection!=null){
                pq.add(s);
            }
            
        }

        for(int i=0;i<allCollages.size();i++){
            Collage c=allCollages.get(i);
            ArrayList<Cource> cources=c.allCources;
            for(int k=0;k<cources.size();k++){
                Cource cor=cources.get(k);
                for(int n=0;n<pq.size();n++){
                    Student s=pq.poll();
                    if(s.selection.containsKey(cor)){
                        s.collage=c;
                        s.cource=cor;
                        cor.seats-=1;
                    }else{
                        pq.add(s);
                    }
                }
            }
        }

    }

    
}
