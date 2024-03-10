package Task_5.Classes;

import java.util.ArrayList;

public class StudyGroupService {
    public PersonList<Student> Students(){
        return students;
    }
    private PersonList<Student> students;

    public PersonList<Professor> Professors(){
        return professors;
    }
    private PersonList<Professor> professors;

    public StudyGroupList StudyGroups(){
        return studyGroups;
    }
    private StudyGroupList studyGroups;

    public StudyGroupService(){
        studyGroups = new StudyGroupList();
        students = new PersonList<>();
        professors = new PersonList<>();
    }

    public void AddStudent(Student s){
        students.Add(s);
        System.out.println("Student " + s + " was added!");
        System.out.println("");
    }
    public Student GetStudent(int ID){
        return students.GetPerson(ID);
    }
    public ArrayList<Student> GetStudents(ArrayList<Integer> studIDs){
        ArrayList<Student> res = new ArrayList<>();
        for (int i = 0; i < studIDs.size(); i++) {
            res.add(GetStudent(studIDs.get(i)));
        }
        
        return res;
    }

    public void AddProfessor(Professor p){
        professors.Add(p);
        System.out.println("Professor " + p + " was added!");
        System.out.println("");
    }
    public Professor GetProfessor(int ID){
        return professors.GetPerson(ID);
    }
    
    public void CreateGroup(int profID, ArrayList<Integer> studIDs){
        StudyGroup g = studyGroups.CreateGroup(GetProfessor(profID), GetStudents(studIDs));
        System.out.println("Group was created!");
        System.out.println(g);
    }
    public StudyGroup GetGroup(int ID){
        return studyGroups.GetGroup(ID);
    }
}