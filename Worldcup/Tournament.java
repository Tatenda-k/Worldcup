import java.util.ArrayList;
import java.util.*;
public class Tournament{

    Random r=new Random();
    private Team winner;
    private Team third;
    private Team second;
    private Team fourth;
    Team[] final_r=new Team[2];
    Team[] third_p=new Team[2];
    Team[]semis=new Team[4];
    Team [] top=new Team[8];
    Team[] sec= new Team[8];
    Team[] quarters= new Team[8];
     ArrayList<ArrayList<Team>>groups;

    // the constructor receives the groups, and creates group classes
    public  Tournament(ArrayList<ArrayList<Team>>groups){
        this.groups=groups;       
        }
// itterate over all groups and create a group object
//call the begin method, and get the top 2 teams of each group and append them to respective arrays
public  void group_stage(){
    //for i in teams;
    //access the group attribute of the team, make it the key , and add the team to the values of the dict
    for( int i=0;i<8;i++){
        Group group=new Group(groups.get(i));
        group.begin();
        Team x=group.get_first();
        Team y=group.get_second();
        top[i]=x;
    
        sec[i]=y;
    }
}
public Team[] get_quarters(){
    return quarters;
}
public Team[] get_semis(){
    return semis;
}
public Team[] get_final(){
    return final_r;
}
public Team[] get_third(){
    return third_p;
}
public Team[] get_first(){
    return top;
}
public Team[] get_sec(){
    return sec;
}


public void round_16(){
    int x=0;
    int i=0;

    while(i<8){
        //for the left side, the top team from one group will vs the second team from another group, the winner will be advance to the quarters
        quarters[x]=eliminate(top[i],sec[i+1]);
        x+=1;
        i+=2;
    }
    i=0;
    while(i<8){
        quarters[x]=eliminate(sec[i],top[i+1]);

        i+=2;
        x+=1;
    }
}
//pass the teams in the quarters array to the elimination
public void quarter(){
    for(int p=0;p<quarters.length;p++){
    
    int i=0;
    int x=0;
    while (i<8){
        semis[x]=eliminate(quarters[i],quarters[i+1]);
        i+=2;
        x+=1;
    }
    }
}
//we are randomly picking the teams that are going to the final
public void  semi_f(){
    
    int i=0;
    int x=0;
    while (i<2){
     int pick=r.nextInt(1);
    if (pick==0){
        final_r[i]=semis[x];
        third_p[i]=semis[x+1];
    }
    else{
        third_p[i]=semis[x];
        final_r[i]=semis[x+1];
    }
    x+=2;
    i+=1;
}
}


public Team  get_winner(){
    return winner;
}
//randomly select the winner 
public void set_winner(){
    
    int pick=r.nextInt(1);
    if (pick==0){
        
        winner=final_r[0];
        second=final_r[1];
    }
    else{
        winner=final_r[1];
        second=final_r[0];
    }
}
// randomly select third place
public void set_third(){
    
    int pick=r.nextInt(1);
    if (pick==0){  
        third=third_p[0];
        fourth=third_p[1];
    }
    else{
        third=third_p[1];
        fourth=third_p[0];
    }

}

public Team eliminate(Team x, Team y){
     int pick=r.nextInt(1);
    if (pick==0){
        return y;
    }
    else{
        return x;
    }
}
public void get_winners(){
    System.out.println();
    System.out.println("From first to fourth in order");
    System.out.println(winner.get_name() +"    " + second.get_name()+"   " + third.get_name() +  "   " + fourth.get_name());


}

}
