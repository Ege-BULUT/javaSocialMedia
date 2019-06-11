package project;

import java.util.ArrayList;

//Fields
public class UserClass{
    private String name;
    private String email;
    private int dayOfBirth = 0;
    private int monthOfBirth;
    private int yearOfBirth;
    private ArrayList<String> notificationBox;
    private ArrayList<Post> postList;
    private ArrayList<Post> timeLine;
    private ArrayList<Post> favPosts;
    private ArrayList<UserClass> followedList;
    private String place;
    private ArrayList<Message> incoming;
    private ArrayList<Message> outgoing;
    private static ArrayList<UserClass> userlist = new ArrayList<>();

    //Constructors
    public UserClass (){
        this.name = " ";
        this.email = " ";
        this.dayOfBirth = 0;
        this.monthOfBirth = 0;
        this.yearOfBirth = 0;
        this.notificationBox = new ArrayList<>();
        this.postList = new ArrayList<>();
        this.timeLine = new ArrayList<>();
        this.favPosts = new ArrayList<>();
        this.followedList = new ArrayList<>();
        this.place = " ";
        this.incoming = new ArrayList<>();
        this.outgoing = new ArrayList<>();
        userlist.add(this);
    }

    public UserClass(String name,String email,int dayOfBirth, int monthOfBirth,int yearOfBirth,String place){
        this.name = name;
        this.email = email;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.notificationBox = new ArrayList<>();
        this.postList = new ArrayList<>();
        this.timeLine = new ArrayList<>();
        this.favPosts = new ArrayList<>();
        this.followedList = new ArrayList<>();
        this.place = place;
        this.incoming = new ArrayList<>();
        this.outgoing = new ArrayList<>();
        userlist.add(this);
    }

    public UserClass(String name, String email, int dayOfBirth,int monthOfBirth,int yearOfBirth, ArrayList<String> notificationBox, ArrayList<Post> postList, ArrayList<Post> timeLine, ArrayList<Post> favPosts, ArrayList<UserClass> followedList, String place, ArrayList<Message> incoming, ArrayList<Message> outgoing){
        this.name = name;
        this.email = email;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.notificationBox = notificationBox;
        this.postList = postList;
        this.timeLine = timeLine;
        this.favPosts = favPosts;
        this.followedList = followedList;
        this.place = place;
        this.incoming = incoming;
        this.outgoing = outgoing;
        userlist.add(this);
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public ArrayList<String> getNotificationBox() { return notificationBox; }
    public void setNotificationBox(ArrayList<String> notificationBox) { this.notificationBox = notificationBox; }

    public ArrayList<Post> getPostList() { return postList; }
    public void setPostList(ArrayList<Post> postList) { this.postList = postList; }

    public ArrayList<Post> getTimeLine() { return timeLine; }
    public void setTimeLine(ArrayList<Post> timeLine) { this.timeLine = timeLine; }

    public ArrayList<Post> getFavPosts() { return favPosts; }
    public void setFavPosts(ArrayList<Post> favPosts) { this.favPosts = favPosts; }

    public ArrayList<UserClass> getFollowedList() { return followedList; }
    public void setFollowedList(ArrayList<UserClass> followedList) { this.followedList = followedList; }

    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    public ArrayList<Message> getIncoming() { return incoming; }
    public void setIncoming(ArrayList<Message> incoming) { this.incoming = incoming; }

    public ArrayList<Message> getOutgoing() { return outgoing; }
    public void setOutgoing(ArrayList<Message> outgoing) { this.outgoing = outgoing; }

    public int getDayOfBirth() {return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) {this.dayOfBirth = dayOfBirth; }

    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }

    public int getYearOfBirth() {return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public static ArrayList<UserClass> getUserlist() { return userlist; }
    public static void setUserlist(ArrayList<UserClass> userlist) { UserClass.userlist = userlist; }

    //Other methods
    public void SendToNotificationBox(String notification){
        //gets notification and sends it to user
        ArrayList<String> list = new ArrayList<>();
        list = getNotificationBox();
        list.add(notification);
        setNotificationBox(list);
    }

    public void ShowNotifications(){
        for (int i = 0; i < notificationBox.size(); i++){
            System.out.println(notificationBox.get(i));
        }
    }
}
