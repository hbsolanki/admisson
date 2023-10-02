import java.util.*;
import Student.Student;
import Collage.Collage;
import ACPC.ACPC;

class Main{
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Student> allStudent=new ArrayList<>();
    static ArrayList<Collage> allCollage=new ArrayList<>();
    public static void main(String[] args) {
        int ch;
        do{
            System.out.println("(1)Student (2)Collage (3)Quit");
            ch=sc.nextInt();

            switch(ch){
                case 1 : System.out.println("(1)New Student (2)Already Student (3)Exit");
                            int i=sc.nextInt();
                            if(i==1){
                                Student s=ACPC.addStudent();
                                allStudent.add(s);
                                student(s);
                            }
                            if(i==2){
                                System.out.print("Enter Student id : ");
                                int sid=sc.nextInt();
                                sc.nextLine();
                                System.out.println("Enter password : ");
                                String pass=sc.nextLine();
                                System.out.println(pass);
                                Student s=checkIdPass(sid, pass);
                                if(s!=null){
                                    student(s);
                                }else{
                                    System.out.println("Wrong id & pass");
                                }
                            }
                        break;

                case 2 : collage();
                         break;
                case 3 : System.exit(0);
                         break;
                default : System.out.println("Invalid Option");
            } 
        }while(ch!=3);

    }

    public static void student(Student s){
        System.out.println("(1)choice Filling (2)Addmision Result (3)Exit");
        int ch=sc.nextInt();
        if(ch==1){
            ACPC.choiceFilling(s, allCollage);
            student(s);
        }
        if(ch==2){
            ACPC.getAddmissionLetter(s, allStudent, allCollage);
            student(s);
        }
        if(ch==3){
            return;
        }
    }

    public static void collage(){
        System.out.println("(1)Add Collage (2)Exit");
        int ch=sc.nextInt();
        if(ch==1){
            sc.nextLine();
            allCollage.add(ACPC.addCollage());
        }else{
            return;
        }
    }

    public static Student checkIdPass(int sid,String password){
        for(int k=0;k<allStudent.size();k++){
            Student s=allStudent.get(k);
            if(s.studentId==sid && s.pass.equals(password)){
                return s;
            }
        }
        return null;
    }
}