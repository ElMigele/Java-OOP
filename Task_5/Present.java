package Task_5;

import java.util.ArrayList;

import Task_5.Classes.Professor;
import Task_5.Classes.Student;

public class Present {
    Model m;
    View v;
    boolean loop;
    boolean groupLoop;
    public Present(){
        m = new Model();
        v = new View();
        loop = true;
        groupLoop = false;
    }

    public void Run(){
        while (loop) {
            int com = v.GetCommand();
            v.ShowCom(com);
            switch (com) {
                case 0:
                    m.Service.AddStudent(new Student(v.GetName("Student")));
                    break;
                case 1:
                    v.ShowResult(m.Service.GetStudent(v.GetID("Student")).toString());
                    break;
                case 2:
                    v.ShowResult(m.Service.Students().toString());
                    break;
                case 3:
                    m.Service.AddProfessor(new Professor(v.GetName("Professor")));
                    break;
                case 4:
                    v.ShowResult(m.Service.GetProfessor(v.GetID("Professor")).toString());
                    break;
                case 5:
                    v.ShowResult(m.Service.Professors().toString());
                    break;

                case 6:
                    int p = v.GetID("Professor");
                    ArrayList<Integer> studIDs = new ArrayList<>();
                    groupLoop = true;
                    while (groupLoop) {
                        Student s = m.Service.GetStudent(v.GetID("Student"));
                        studIDs.add(s.ID());
                        groupLoop = v.ConfirmContinue();
                    }

                    m.Service.CreateGroup(p, studIDs);
                    break;
                case 7:
                    v.ShowResult(m.Service.GetGroup(v.GetID("Group")).toString());
                    break;
                case 8:
                    v.ShowResult(m.Service.StudyGroups().toString());
                    break;

                case 9:
                    loop = false;
                    break;
            }
        }
    }
}