/*** TATENDA SEKABANJA
This is a program that program that prompts the user for 32 teams,for each team, the team is randomly assigned to a group. Once all groups are entered, the tournament begins with the group stages,
and the winners move on, so it is up to the final. The stages are printed out in tournament bracket style ***/

import java.util.*;

        public class world_cup {
            /** 
             * get_teams: asks the user for input and assigns each team to a group
             *@param sizef- the size of the female array
            **/
            
                public static void get_teams(Scanner s,Set<String> countries,Random r, ArrayList<int[]>g_keys,ArrayList<ArrayList<Team>>groups){
                int x=8;  // the range of keys to select fom 
                boolean valid=false;
                String resp=null;
                System.out.println(countries);
                for(int i=0;i<32;i++){
                    System.out.print("Type in a team: ");

                valid=false;
                while (valid==false){
                resp=s.nextLine();
                if(countries.contains(resp)){
                    valid=true;
                    // remove the countr we just added from the set of prospective countries
                    countries.remove(resp);
                }
                else{
                    System.out.println("Country does not exist or country already in competition");
                    System.out.print("Type in a team: ");
            }      
        }
                int index=r.nextInt(x);
                
                int[] inner_arr = g_keys.get(index);    
                int letter = inner_arr[0];
                //we go to the group- whihch is the letter- 0,1 .a,b
                Team team=new Team(resp,letter);
                ///we add the team to the group array, according to the letter
                groups.get(letter).add(team);
                inner_arr[1]-=1;
                //everey time we add to a group, we reduce it's number of available spaces 
                if(inner_arr[1]==0){
                    //if the group is full, we romove it from the list of available groups
                    g_keys.remove(index);
                    x-=1;
                    
                }

                //so know we will have a group array of 8 arrays, with each inner array containing 4 teams
                
                

                
                    
            }
      
        
    }

            
            public static void main (String args[]){
                Scanner s =new Scanner(System.in);
                Random r= new Random();
                Set<String> countries = new HashSet<>(Arrays.asList(
            "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria",
             "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina",
              "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Côte d'Ivoire", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic",
               "Chad", "Chile", "China", "Colombia", "Comoros", "Congo (Congo-Brazzaville)", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czechia (Czech Republic)", 
               "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", 
               "Eritrea", "Estonia", "Eswatini ", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", 
               "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Holy See", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", 
               "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho",
                "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania",
                 "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (formerly Burma)", "Namibia", "Nauru", "Nepal", 
                 "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Palestine State", "Panama",
                 "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", 
                 "Saint Vincent and the Grenadines", "Samoa", "San Marino", 
            "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia"));
                
                    ArrayList<ArrayList<Team>>groups = new ArrayList<>(1);//**************************************************
                    
                for (int i = 0; i < 8; i++) {
                   groups.add(new ArrayList<>());
                }
                
                ArrayList<int[]> g_keys = new ArrayList<>();
                
                for (int i = 0; i < 8; i++) {
                    int[] key = new int[2];
                    key[0] = i;
                    key[1] = 4;
                    g_keys.add(key);
        }
            get_teams( s, countries, r,g_keys,groups);
            Tournament tournament= new Tournament (groups);


            


                
                 for(int t=0;t<groups.size();t++){
                    char g = (char) (t+65);
                    System.out.println();
                    System.out.println("Group "+ g) ;
                    for(int b=0;b<4;b++){
                        System.out.println(groups.get(t).get(b).get_name());
                    }
                }

               
                 tournament.group_stage();
                  Team [] top= tournament.get_first();
                Team [] sec= tournament.get_sec();
                
                //for the round of 16, the top teams from one group vs the second teams from another group
                 tournament.round_16();
                 
                 tournament.quarter();
                 tournament.semi_f();
                 tournament.set_winner();
                 tournament.set_third();
                Team[] quarters= tournament.get_quarters();
                Team[] semis= tournament.get_semis();
                Team [] final_r=tournament.get_final();
                Team [] third_r=tournament.get_third();

                System.out.println(top[0].get_name()+"                                                                                                              "+ sec[0].get_name());
                System.out.println( "           "+quarters[0].get_name() + "                                                                          " + quarters[4].get_name());
                System.out.println(sec[1].get_name()+"                                                                                                              "+ top[1].get_name());

                System.out.println("                               "+semis[0].get_name() +"                                    "+ semis[2].get_name());
                System.out.println();
                System.out.println(top[2].get_name()+"                                                                                                             "+ sec[2].get_name());
                System.out.println( "           "+quarters[1].get_name() + "                                                                          " + quarters[5].get_name());
                System.out.println(sec[3].get_name()+"                                     "+final_r[0].get_name() +"      " +final_r[1].get_name()+ "                                              "+ top[3].get_name());
                System.out.println(top[4].get_name()+"                                                                                                     "+ sec[4].get_name());
                System.out.println( "           "+quarters[2].get_name() + "                                                                          " + quarters[6].get_name());
                System.out.println(sec[5].get_name()+"                                                                                                                "+ top[5].get_name());

                System.out.println("                               "+semis[1].get_name() +"                                     "+ semis[3].get_name());
                System.out.println();
                System.out.println(top[6].get_name()+"                                                                                                                "+ sec[6].get_name());
                System.out.println( "           "+quarters[3].get_name() + "                                                                        " + quarters[7].get_name());
                System.out.println(sec[7].get_name()+"                                                                                                                "+ top[7].get_name());


                tournament.get_winners();

               

            }
            
        }
    

