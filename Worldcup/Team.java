public class Team {
    
    private String name;
    private int score;
   public  int group;

    
    public Team(String name,int group){
        this.group=group;
        this.name=name;
        score=0;

    }
    public String get_name(){
        return name;
    }
    public int get_score(){
        return score;
    }
    public  int group(){
        return group;
    }
    public void  add_points(int x){
        score+=x;
    }
    
}


