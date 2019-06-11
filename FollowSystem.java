package project;

import java.util.ArrayList;

public class FollowSystem{

    private ArrayList<UserClass> RemainingUsers;
    //constuctor
    public FollowSystem(){
        //gets shallow copy of all users list
        this.RemainingUsers = new ArrayList<UserClass>(UserClass.getUserlist());
    }

    //Getters and Setters
    public ArrayList<UserClass> getRemainingUsers() { return RemainingUsers; }
    public void setRemainingUsers(ArrayList<UserClass> remainingUsers) { RemainingUsers = remainingUsers; }


    //Follows a user which selected
    public void Follow(UserClass user1 /*follower*/,UserClass user2 /*followed*/){
        ArrayList<UserClass> list = new ArrayList<>();
        list = user1.getFollowedList();
        list.add(user2);
        user1.setFollowedList(list);

       list = getRemainingUsers();
       list.remove(user2);
       setRemainingUsers(list);

       ArrayList<String>list1 = new ArrayList<>();
       list1 = user2.getNotificationBox();
       list1.add("You followed by "+ user1.getName());
    }

    //Unfollows user which selected
    public void Unfollow(UserClass user1,UserClass user2){
        ArrayList<UserClass> list;
        list = user1.getFollowedList();
        list.remove(user2);
        user1.setFollowedList(list);

        list = getRemainingUsers();
        list.add(user2);
        setRemainingUsers(list);

        ArrayList<String>list1 = new ArrayList<>();
        list1 = user2.getNotificationBox();
        list1.add("You unfollowed by "+ user1.getName());
    }

    //Controls if user follows another selected user
    public boolean IsFollow(UserClass user1,UserClass user2){
        for (int i = 0; i < user1.getFollowedList().size(); i++){
            if (user1.getFollowedList().get(i).equals(user2)){
                return true;
            }
        }
      return false;
    }

    //controls if each user follows each other
    public boolean IsEachOtherFollowing(UserClass user1,UserClass user2){
        for (int i =0; i< user1.getFollowedList().size();i++){
            if (user1.getFollowedList().get(i).equals(user2) ){
                for (int j=0; j < user2.getFollowedList().size() ;j++){
                    if (user2.getFollowedList().get(j).equals(user1) ){
                        return true;//if both side is following each other return True
                    }
                }
            }
        }
      return false;//if it doesnt return true from top it returns false
    }
}
