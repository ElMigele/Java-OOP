package Task_5.Classes;

import java.util.ArrayList;

public class StudyGroup {
    public int ID(){
        return id;
    }
    private int id;

    public Professor Professor(){
        return professor;
    }
    private Professor professor;

    public ArrayList<Student> Students(){
        return students;
    }
    private ArrayList<Student> students;

    public StudyGroup(Professor p, ArrayList<Student> s, int myID){
        professor = p;
        students = new ArrayList<>(s);
        id = myID;
    }

    @Override
    public String toString(){
        String res = new String();
        res += "Group id: " + id + "\n";
        res += "Professor: " + professor + "\n";
        res += "Students:\n"; 
        for (Student student : students) {
            res += student + "\n";
        }

        return res;
    }
}