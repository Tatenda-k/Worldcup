import java.util.*;

public class Group{
private Team first;
private Team second;
private ArrayList<Team> group;

Random rand=new Random();

public  Group(ArrayList<Team> group){
   
     this.group=group;
}

public ArrayList<Team> get_group(){
    return group;
}
//calls the matches method, scores method, and set_top_teams method
public void begin(){
    List<Integer> comb = new ArrayList<>();
    matches(comb,0);

    Team [] top= scores();
    
    set_top_teams(top); 

}

//set's the firstplace and second place teams
private void set_top_teams(Team[]top){
    first=top[0];
    second=top[1];
}
//creates the matches for each team by generating all possible combinations
private void matches (List<Integer> curr, int firstNum){
    if(curr.size()==2){

        match(group.get(curr.get(0)),group.get(curr.get(1)));
        return;
    }
        for (int num = firstNum; num <4; num++) {
        curr.add(num);
        matches(curr, num + 1);
        curr.remove(curr.size() - 1);
    }

    return;
}

    //randomly pick a winner by picking a random integer
private void match(Team x, Team y){
    int pick=rand.nextInt(2);
    if (pick==0){
        x.add_points(3);
    }
    else{
        y.add_points(3);
    }
}
//pick a random number between 0 and 1
///if the number is 0, increase teamx's score by 1 else, increase team2's score by1

//keep track of the teams with the two highest score
private Team [] scores(){
    // we want to know who has the top two scores and what the top scores are
    // first find the top score, keep track of who it belongs to, return the top two teams
        int max=0;
        Team top= null;
        int max_2=0;
        Team two = null;
                for (Team x: group) {
            if (x.get_score()> max) {
                max_2 = max;
                two=top;
                max = x.get_score();
                top=x;
            } else if (x.get_score() > max_2 || x.get_score() == max) {
                max_2 = x.get_score();
                two=x;
            }
        }
        Team[] tops={top,two};
        return tops;

    }
   

public Team get_first(){
    return first;
}
public Team get_second(){
    return second;
}

}
