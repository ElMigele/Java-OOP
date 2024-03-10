package Task_5.Classes;

import java.util.ArrayList;

public class StudyGroupList {
    private int freeID;

    public ArrayList<StudyGroup> StudyGroups(){
        return studyGroups;
    }
    private ArrayList<StudyGroup> studyGroups;

    public StudyGroupList(){
        studyGroups = new ArrayList<>();
    }

    public StudyGroup CreateGroup(Professor p, ArrayList<Student> s){
        StudyGroup g = new StudyGroup(p, s, freeID);
        studyGroups.add(g);
        freeID++;
        return g;
    }
    public StudyGroup GetGroup(int ID){
        if (ID < 0 || ID >= studyGroups.size()) {
            throw new UnsupportedOperationException("ID is out of range");
        }
        return studyGroups.get(ID);
    }

    @Override
    public String toString(){
        String res = new String();
        for (StudyGroup studyGroup : studyGroups) {
            res += studyGroup.toString() + "\n";
        }
        return res;
    }
}