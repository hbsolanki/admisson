package Student;
import java.util.HashMap;

import Collage.Collage;
import Collage.Collage.Cource;

public class Student {
    public String name;
    public int studentId;
    float math;
    float chemistry;
    float physics;
    public String pass;
    public HashMap<Cource, Collage> selection;
    public Collage collage;
    public Cource cource;

    public Student(String name,int studentId,String pass,float math,float chemistry,float physics){
        this.name=name;
        this.studentId=studentId;
        this.math=math;
        this.chemistry=chemistry;
        this.physics=physics;
        this.pass=pass;         
    }

    public double merit(){
        return (math+chemistry+physics)/3;
    }

    public void  getStudentDetails(){

    }
}
