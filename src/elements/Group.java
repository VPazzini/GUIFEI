package elements;

import java.util.ArrayList;

public class Group {

    private ArrayList<Edge> group = new ArrayList<>();
    private float startF;
    private float endF;
    private float dfF;
    String met;

    public Group(ArrayList<Edge> group, float startF, float endF, float dfF, String met) {
        this.group.addAll(group);
        this.startF = startF;
        this.endF = endF;
        this.dfF = dfF;
        this.met = met;
    }

    public ArrayList<Edge> getGroup() {
        return group;
    }

    @Override
    public String toString() {
        String s = "";
        for (Edge e : group) {
            s += e.getNumber() + " ";
        }
        return s;
    }

    public float getStartF() {
        return startF;
    }

    public float getEndF() {
        return endF;
    }

    public float getDfF() {
        return dfF;
    }

    public String getMet() {
        return met;
    }

    public void setStartF(float startF) {
        this.startF = startF;
    }

    public void setEndF(float endF) {
        this.endF = endF;
    }

    public void setDfF(float dfF) {
        this.dfF = dfF;
    }

    public void setMet(String met) {
        this.met = met;
    }
    
    
    
}
