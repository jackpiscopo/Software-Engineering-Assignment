package um;

import java.util.ArrayList;
import java.util.List;

public class TeamComposite implements Participant {

    //private int teamNum;

    private List<Participant> childTeams = new ArrayList<>();

    //@Override
    public void printTeam() {
        //System.out.println("Team "+ teamNum+": ");
        //System.out.println("Player "+)

        for (Participant participant : childTeams) {
            participant.printTeam();
        }
        //childTeams.forEach(Participant::printTeam);
    }

    public void addMember(Participant participant) {
        childTeams.add(participant);
    }

    public void removeMember(Participant participant) {
        childTeams.remove(participant);
    }

    public void clear() {
        childTeams.clear();
    }

    public int size() {
        if(childTeams!=null) {
            return childTeams.size();
        } else {
            return 0;
        }
    }

    @Override
    public void setUncovered(int x, int y) {
        for(Participant participant : childTeams) {
            participant.setUncovered(x, y);
        }
    }
}
