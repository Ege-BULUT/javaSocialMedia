package project;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPanel{
    public static void main(String args[]){

        //controls all main page for any user
        MainPage mp = new MainPage();

        //controls all timeline for any user
        TimeLine timeLine = new TimeLine();

        //creates an ArrayList for any usage of array<UserClass>
        ArrayList<UserClass> list = new ArrayList<UserClass>();

        //creates an ArrayList for any usage of array<post>
        ArrayList<Post> PostList = new ArrayList<Post>();

        //creates Scanner for any usage of scanner
        Scanner scanner = new Scanner(System.in);

        //Creates an Administrator for controlling birthday
        Administrator Admin = new Administrator();

        //Creates new user for you with your information
        Register Registerer = new Register();
        UserClass user = Registerer.Registering();

        //Creates other users for our program(özellikleri değişecek)
        UserClass user1 = new UserClass("Deyan Bora Çetin", "deyan_bora@hotmail.com", 23, 01, 1999,"İzmir");
        UserClass user2 = new UserClass("Ege Bulut", "izciege@hotmail.com", 3, 4, 2000,"Datça");
        UserClass user3 = new UserClass("Mehmet Uslu", "mehmetamca@gmail.com", 6, 7, 1967,"Erzurum");
        UserClass user4 = new UserClass("Ahmet Sel", "ahmetSel@hotmail.com", 31, 5, 1985,"Manisa");
        UserClass user5 = new UserClass("Arzu Hepcan", "arzu_1997@hotmail.com", 1, 4, 1997,"Ankara");
        UserClass user6 = new UserClass("Aslı Bekir", "asli_20062013@hotmail.com", 25, 1, 1983,"Adana");
        UserClass user7 = new UserClass("Dilan Saman", "dilan_saman@gmail.com", 20, 6, 2002,"Uşak");

        //Follow system which controls all follow operations
        FollowSystem Following = new FollowSystem();

        //Holds all userlist for any use
        ArrayList<UserClass> userlist = new ArrayList<>();
        userlist = UserClass.getUserlist();

        //It runs for all users, controls if their birthday is today or not and if it is sends message to notification box
        for (int i =0; i < userlist.size();i++){
            Admin.CallBirthday(userlist.get(i));
        }

        //Makes some users to follow our user
        Following.Follow(user1,user);
        Following.Follow(user2,user);
        Following.Follow(user3,user);

        //Creates others posts
        Post otherpost1 = new Post(user1.getName()," ",0,0);
        Post otherpost2 = new Post(user1.getName()," ",0,0);
        Post otherpost3 = new Post(user1.getName()," ",0,0);
        Post otherpost4 = new Post(user1.getName()," ",0,0);
        Post otherpost5 = new Post(user1.getName()," ",0,0);
        Post otherpost6 = new Post(user1.getName()," ",0,0);
        Post otherpost7 = new Post(user1.getName()," ",0,0);
        TextMessage message1 = new TextMessage();
        FileMessage message2 = new FileMessage();

        int exit = 0;
        //Panel
        while (exit == 0){
            System.out.println("\nWelcome " + user.getName() + ", please choose an operation;");
            System.out.println("1.  Show Inbox");
            System.out.println("2.  Show Outbox");
            System.out.println("3.  Send Message");
            System.out.println("4.  Share Post");
            System.out.println("5.  Show Your Time Line");
            System.out.println("6.  Show Others Timeline");
            System.out.println("7.  Show Main Page");
            System.out.println("8.  Show Your Followings");
            System.out.println("9.  Show Your Followers");
            System.out.println("10. Follow People");
            System.out.println("11. Unfollow People");
            System.out.println("12. Show Favourite Posts");
            System.out.println("13. Show Notifications");
            System.out.println("Enter any number for exit.");

            //sends message from another user to our user
            message1.SendMessage(user1,user,"Welcome to our platform");
            message2.SendMessage(user2,user,"Welcome to our platform","Welcome.GIF");

            //shares others posts and controls when someone follows they can see the posts in their main page
            otherpost1.sharePost(user1,Following,"I created this platform.");
            otherpost2.sharePost(user2,Following,"I created this platform.");
            otherpost3.sharePost(user3,Following,"Hi,I'm new here.");
            otherpost4.sharePost(user4,Following,"Hello,I'm new here.");
            otherpost5.sharePost(user5,Following,"Hi,Im new here.");
            otherpost6.sharePost(user6,Following,"Hello,I'm new here.");
            otherpost7.sharePost(user7,Following,"Hi,I'm new here.");


            int choose = scanner.nextInt();
            scanner.nextLine();//dummy;

            switch (choose){
                
                //Shows inbox for our user
                case 1:
                    if(user.getIncoming().size() == 0){
                        System.out.println("____________");
                        System.out.println("Your inbox is empty.");
                        System.out.println("____________");
                      break;
                    }
                    else{
                        System.out.println("_______________\nInbox:");
                        for(int i =0;i < user.getIncoming().size();i++){
                            if(user.getIncoming().get(i) instanceof FileMessage){
                                //type casting
                                FileMessage fileMessage =(FileMessage) user.getIncoming().get(i);

                                System.out.println("____________");
                                System.out.println("From :" + fileMessage.getSenderPerson());
                                System.out.println("\nMessage: \n" + fileMessage.getMessage());
                                System.out.println("Content : \n" + fileMessage.getFileName());
                                System.out.println("____________");
                            }
                            else{
                                //type casting
                                TextMessage textMessage =(TextMessage) user.getIncoming().get(i);

                                System.out.println("____________");
                                System.out.println("From :" + textMessage.getSenderPerson());
                                System.out.println("\nMessage: \n" + textMessage.getMessage());
                                System.out.println("____________");
                            }
                        }
                      break;
                    }
                //Shows outbox for our user
                case 2:
                    if(user.getOutgoing().size() == 0){
                        System.out.println("____________");
                        System.out.println("Your Outbox is empty. Please try to message someone.");
                        System.out.println("____________");
                      break;
                    }
                    else{
                        System.out.println("_______________\nOutbox:");
                        for(int i =0;i < user.getOutgoing().size();i++){
                            if(user.getOutgoing().get(i) instanceof FileMessage){
                                //type casting
                                FileMessage fileMessage = (FileMessage) user.getOutgoing().get(i);

                                System.out.println("_______________");
                                System.out.println("To :" + fileMessage.getGetterPerson());
                                System.out.println("\nMessage: \n" + fileMessage.getMessage());
                                System.out.println("File : \n" + fileMessage.getFileName());
                                System.out.println("_______________");
                            }
                            else{
                                //type casting
                                TextMessage textMessage = (TextMessage) user.getOutgoing().get(i);

                                System.out.println("_______________");
                                System.out.println("To :" + textMessage.getGetterPerson());
                                System.out.println("\nMessage: \n" + textMessage.getMessage());
                                System.out.println("_______________");
                            }
                        }
                      break;
                    }
                //Sends user to message panel for sending message
                case 3:
                    if (user.getFollowedList().size()==0){
                        System.out.println("___________________");
                        System.out.println("You haven't followed anyone yet please follow someone.");
                        System.out.println("___________________");
                      break;
                    }

                    else{
                        System.out.println("Please choose what type of message you will send:");
                        System.out.println("1. Text message");
                        System.out.println("2.File message");
                        int selection = scanner.nextInt();
                        scanner.nextLine();
                        if (selection == 1){
                            TextMessage message = new TextMessage();
                            System.out.println("\n");
                            message.MessagingPanel(user);
                        }
                        else if (selection == 2){
                            FileMessage message = new FileMessage();
                            System.out.println("\n");
                            message.MessagingPanel(user);
                        }

                        else{
                            System.out.println("Wrong operation number please try again!");
                        }
                    }
                  break;

                //Creates new post for user and sends him creation page
                case 4:
                    Post post = new Post();
                    post.sharePost(user, Following);
                    System.out.println("\n\tPosted.");
                  break;

                //Shows user's Timeline
                case 5:
                    System.out.println("Time Line:");
                    timeLine.getTimeLine(user);
                    
                    //controls timeline
                    if(user.getTimeLine().size() == 0){
                        System.out.println("___________________");
                        System.out.println("Your Time Line is empty, please post or share something.");
                        System.out.println("___________________");
                      break;
                    }

                    else{
                        System.out.println("Choose the post number for showing post operations");

                        int tPostNumber = scanner.nextInt();
                        scanner.nextLine();//dummy;

                        //controls users post select number
                        if (tPostNumber > user.getTimeLine().size() || tPostNumber < 0){
                            System.out.println("Wrong post number please try again!");
                          break;
                        }

                        else{
                            timeLine.getTimeLine(user, tPostNumber);
                            System.out.println("Enter 1 to like the post 1 \n" +
                                    "Enter 2 to comment the post \n" +
                                    "Enter 3 for showing comments \n" +
                                    "Enter 4 for showing likers\n" +
                                    "Enter 5 for adding this post to your favourite list\n" +
                                    "Enter 6 for returning your Time Line \n" +
                                    "Enter another number for returning User panel.");
                            int tPostAction = scanner.nextInt();
                            scanner.nextLine();//dummy;

                            switch (tPostAction){

                                //Adds 1 like for post which our user selects
                                case 1:
                                    user.getTimeLine().get(tPostNumber - 1).Like();
                                    for (int i = 0; i < user.getTimeLine().get(tPostNumber - 1).getLikers().size(); i++) {
                                        //Controls if user likes it 2 times it doesn't add him 2 times
                                        if (user.equals(user.getTimeLine().get(tPostNumber - 1).getLikers().get(i))) {
                                            list = user.getTimeLine().get(tPostNumber - 1).getLikers();
                                            list.remove(user);
                                            user.getTimeLine().get(tPostNumber - 1).setLikers(list);
                                        }
                                    }

                                    list = user.getTimeLine().get(tPostNumber - 1).getLikers();
                                    list.add(user);
                                    user.getTimeLine().get(tPostNumber - 1).setLikers(list);
                                  break;

                                //Opens comment page for user
                                case 2:
                                    user.getTimeLine().get(tPostNumber - 1).Comment(user);
                                  break;

                                //Prints all comments for selected post
                                case 3:
                                    timeLine.getTimeLine(user, tPostNumber);
                                    if (user.getTimeLine().get(tPostNumber - 1).getComments().size() == 0) {
                                        System.out.println("There is no comment to show. You can write the first comment.");
                                      break;
                                    } 
                                    else{
                                        System.out.println("Comments :\n__________________");
                                        for (int i = 0; i < user.getTimeLine().get(tPostNumber - 1).getComments().size(); i++) {
                                            System.out.println(user.getTimeLine().get(tPostNumber - 1).getComments().get(i));
                                        }
                                      break;
                                    }
                                case 4:
                                    if (user.getPostList().get(tPostNumber - 1).getLikers().size() == 0) {
                                        System.out.println("No likes");
                                        break;
                                    } 
                                    else{
                                        for (int i = 0; i < user.getPostList().get(tPostNumber - 1).getLikers().size(); i++) {
                                            System.out.println(user.getPostList().get(tPostNumber - 1).getLikers().get(i).getName());
                                        }
                                      break;
                                    }
                                case 5:
                                    PostList = user.getFavPosts();
                                    PostList.add(user.getTimeLine().get(tPostNumber - 1));
                                    user.setFavPosts(PostList);
                                  break;
                                //Gets main page for user
                                case 6:
                                    timeLine.getTimeLine(user);
                                  break;
                            }
                          break;
                        }
                    }
                case 6:
                    System.out.println("___________________");
                    System.out.println("Please select whose timeline do you want to see:");

                    //prints names of users
                    for(int i =1; i< userlist.size();i++){
                        System.out.println(i + "." +userlist.get(i).getName());
                    }

                    int selectU = scanner.nextInt();
                    scanner.nextLine(); //dummy

                    //controls selected user input
                    if(selectU > userlist.size() || selectU<1){
                        System.out.println("Wrong user number please try again!");
                      break;
                    }

                    else{
                        timeLine.getTimeLine(userlist.get(selectU));

                        //prints selected users timeline
                        //controls if he has post in his timeline
                        if (userlist.get(selectU).getTimeLine().size() == 0){
                            System.out.println("___________________");
                            System.out.println("His/Her Time Line is empty.");
                            System.out.println("___________________");
                          break;
                        }

                        else{
                            System.out.println("Choose the post number for showing post operations");
                            int tPostNumber = scanner.nextInt();
                            scanner.nextLine();//dummy;

                            //controls users selected post input
                            if (tPostNumber > userlist.get(selectU).getTimeLine().size() || tPostNumber < 0){
                                System.out.println("Wrong post number please try again!");
                              break;
                            }

                            else{
                                timeLine.getTimeLine(userlist.get(selectU), tPostNumber);

                                System.out.println("Enter 1 to like the post\n" +
                                        "Enter 2 to comment the post \n" +
                                        "Enter 3 for showing comments \n" +
                                        "Enter 4 for showing likers\n" +
                                        "Enter 5 for adding this post to your favourite list\n" +
                                        "Enter another number for returning User panel.");
                                int tPostAction = scanner.nextInt();
                                scanner.nextLine();//dummy;

                                switch (tPostAction){
                                    //Adds 1 like for post which our user selects
                                    case 1:
                                        userlist.get(selectU).getTimeLine().get(tPostNumber - 1).Like();

                                        for (int i = 0; i < userlist.get(selectU).getTimeLine().get(tPostNumber - 1).getLikers().size(); i++) {
                                            //Controls if user likes it 2 times it doesn't add him 2 times
                                            if (user.equals(userlist.get(selectU).getTimeLine().get(tPostNumber - 1).getLikers().get(i))) {
                                                list = userlist.get(selectU).getTimeLine().get(tPostNumber - 1).getLikers();
                                                list.remove(user);
                                                userlist.get(selectU).getTimeLine().get(tPostNumber - 1).setLikers(list);
                                            }
                                        }
                                        list = userlist.get(selectU).getTimeLine().get(tPostNumber - 1).getLikers();
                                        list.add(user);
                                        userlist.get(selectU).getTimeLine().get(tPostNumber - 1).setLikers(list);
                                      break;

                                    //Opens comment page for user
                                    case 2:
                                        userlist.get(selectU).getTimeLine().get(tPostNumber - 1).Comment(user);
                                      break;

                                    //Prints all comments for selected post
                                    case 3:
                                        timeLine.getTimeLine(userlist.get(selectU), tPostNumber);
                                        if (userlist.get(selectU).getTimeLine().get(tPostNumber - 1).getComments().size() == 0) {
                                            System.out.println("There is no comment to show. You can write the first comment.");
                                            break;
                                        } 
                                        else{
                                            System.out.println("Comments :\n__________________");
                                            for (int i = 0; i < userlist.get(selectU).getTimeLine().get(tPostNumber - 1).getComments().size(); i++) {
                                                System.out.println(userlist.get(selectU).getTimeLine().get(tPostNumber - 1).getComments().get(i));
                                            }
                                          break;
                                        }
                                    case 4:
                                        if (userlist.get(selectU).getPostList().get(tPostNumber - 1).getLikers().size() == 0) {
                                            System.out.println("No likes");
                                          break;
                                        } 
                                        else{
                                            for (int i = 0; i < userlist.get(selectU).getPostList().get(tPostNumber - 1).getLikers().size(); i++) {
                                                System.out.println(userlist.get(selectU).getPostList().get(tPostNumber - 1).getLikers().get(i).getName());
                                            }
                                          break;
                                        }
                                    //adds this post to our user's fav list
                                    case 5:
                                        PostList = userlist.get(selectU).getFavPosts();
                                        PostList.add(userlist.get(selectU).getTimeLine().get(tPostNumber - 1));
                                        user.setFavPosts(PostList);
                                      break;
                                }
                              break;
                            }
                        }
                    }
                    //Shows user's main page
                    case 7:
                    System.out.println("Main Page:");
                    mp.getMainPage(user);

                    if(user.getPostList().size() == 0){
                        System.out.println("___________________");
                        System.out.println("Your Main Page is empty, please follow someone or post something.");
                        System.out.println("___________________");
                      break;
                    }

                    else {
                        System.out.println("Choose the post number for show post operations");

                        int postNumber = scanner.nextInt();
                        scanner.nextLine();//dummy;

                        //controls users post select input
                        if (postNumber > user.getPostList().size() || postNumber < 0){
                            System.out.println("Wrong post number please try again!");
                          break;
                        }

                        else{
                            mp.getMainPage(user, postNumber);
                            System.out.println("Enter 1 to like the post 1 \n" +
                                    "Enter 2 to comment the post \n" +
                                    "Enter 3 for showing comments \n" +
                                    "Enter 4 for showing likers\n" +
                                    "Enter 5 for adding this post to your favourite list\n" +
                                    "Enter 6 for returning your Time Line \n" +
                                    "Enter another number for returning User panel.");
                            int postAction = scanner.nextInt();
                            scanner.nextLine();//dummy;

                            switch (postAction){
                                //Adds 1 like for post which our user selects
                                case 1:
                                    user.getPostList().get(postNumber - 1).Like();

                                    for (int i = 0; i < user.getPostList().get(postNumber - 1).getLikers().size(); i++) {
                                        //Controls if user likes it 2 times it doesn't add him 2 times
                                        if (user.equals(user.getPostList().get(postNumber - 1).getLikers().get(i))) {
                                            list = user.getPostList().get(postNumber - 1).getLikers();
                                            list.remove(user);
                                            user.getPostList().get(postNumber - 1).setLikers(list);
                                        }
                                    }
                                    list = user.getPostList().get(postNumber - 1).getLikers();
                                    list.add(user);
                                    user.getPostList().get(postNumber - 1).setLikers(list);
                                  break;

                                //Opens comment page for user
                                case 2:
                                    user.getPostList().get(postNumber - 1).Comment(user);
                                  break;
                                //Prints all comments for selected post
                                case 3:
                                    mp.getMainPage(user, postNumber);
                                    if (user.getPostList().get(postNumber - 1).getComments().size() == 0) {
                                        System.out.println("There is no comment to show. You can write the first comment.");
                                      break;
                                    } 
                                    else{
                                        System.out.println("Comments :\n__________________");
                                        for (int i = 0; i < user.getPostList().get(postNumber - 1).getComments().size(); i++) {
                                            System.out.println(user.getPostList().get(postNumber - 1).getComments().get(i));
                                        }
                                      break;
                                    }
                                //show likers
                                case 4:
                                    if (user.getPostList().get(postNumber - 1).getLikers().size() == 0) {
                                        System.out.println("No likes");
                                      break;
                                    } else{
                                        for (int i = 0; i < user.getPostList().get(postNumber - 1).getLikers().size(); i++) {
                                            System.out.println(user.getPostList().get(postNumber - 1).getLikers().get(i).getName());
                                        }
                                      break;
                                    }
                                //adds post to favlist
                                case 5:
                                    PostList = user.getFavPosts();
                                    PostList.add(user.getPostList().get(postNumber - 1));
                                    user.setFavPosts(PostList);
                                  break;
                                //Gets main page for user
                                case 6:
                                    mp.getMainPage(user);
                                  break;
                            }
                        }
                    }
                break;

                //Shows user his contact list
                case 8:
                    if(user.getFollowedList().size() == 0){
                        System.out.println("___________________");
                        System.out.println("You are follow 0 user, please follow someone to socialize.");
                        System.out.println("___________________");
                      break;
                    }
                    else{
                        System.out.println("You are follow "+ user.getFollowedList().size() +" user:");
                        System.out.println("___________________");
                        for (int i = 0; i < user.getFollowedList().size(); i++){
                            System.out.println(user.getFollowedList().get(i).getName());
                        }
                      break;
                    }

                //Shows your followers
                case 9:
                    System.out.println("\nYour followers are:");
                    System.out.println("___________________");

                    for(int i = 0;i < userlist.size();i++){
                        //if he follows user prints his name
                        if(Following.IsFollow(userlist.get(i),user)){
                            System.out.println(userlist.get(i).getName());
                        }
                    }
                    System.out.println("___________________");
                  break;

                //Shows all users who you're not following for our user and gives him follow option
                case 10:
                    System.out.println("___________________");
                    System.out.println("All users in our system are:\n");

                    //prints all users who you're not following in system
                    for (int i = 0; i < Following.getRemainingUsers().size(); i++)
                    {
                        System.out.println(i+1 + " " + Following.getRemainingUsers().get(i).getName());
                    }

                    System.out.println("Please choose the user who you want to follow");
                    int select = scanner.nextInt();
                    scanner.nextLine();

                    //makes you follow user who you choose
                    Following.Follow(user, Following.getRemainingUsers().get(select-1));
                    int number = user.getFollowedList().size()-1;
                    System.out.println("You followed " +  user.getFollowedList().get(number).getName());
                    System.out.println("___________________");
                    break;

                //Shows all users who you are following
                  
                case 11:
                    if(user.getFollowedList().size() == 0){
                        System.out.println("___________________");
                        System.out.println("You are not following anyone.");
                        System.out.println("___________________");
                      break;
                    }

                    else{
                        System.out.println("___________________");
                        System.out.println("All users who you are following\n");

                        for(int i = 0; i < user.getFollowedList().size(); i++)  {
                            System.out.println(i+1 +" "+ user.getFollowedList().get(i).getName());
                        }

                        System.out.println("Please choose the user who you want to unfollow");
                        int select1 = scanner.nextInt();
                        scanner.nextLine();

                        //Holds name
                        String name = user.getFollowedList().get(select1-1).getName();

                        //makes you unfollow user who you choose
                        Following.Unfollow(user, user.getFollowedList().get(select1-1));
                        System.out.println("___________________");
                        System.out.println("You unfollowed " +  name);
                        System.out.println("___________________");
                      break;
                    }
                    // Shows user's notification box
                case 12 :
                    if(user.getFavPosts().size()==0){
                        System.out.println("___________________");
                        System.out.println("You have not any favourite posts, go and fav some post.");
                        System.out.println("___________________");
                      break;
                    }
                    else{
                        for(int i = 0; i < user.getFavPosts().size(); i++){
                            System.out.println("___________________");
                            System.out.println(user.getFavPosts().get(i).getSharer()+"\n");
                            System.out.println(user.getFavPosts().get(i).getContent());
                            System.out.println(user.getFavPosts().get(i).getLikes() + " Likes");
                            System.out.println(user.getFavPosts().get(i).getComments().size()+" Comments");

                            if(user.getFavPosts().get(i).getComments().size() == 0){
                                System.out.println("There is no comment to show.");
                              break;
                            }
                            else{
                                System.out.println("Comments :\n___________________");
                                for(int x=0; x<user.getFavPosts().get(i).getComments().size(); x++){
                                    System.out.println(user.getFavPosts().get(i).getComments().get(x));
                                }
                            }
                            System.out.println("___________________");
                        }
                      break;
                    }
                    //Shows notification box
                case 13:
                    if( user.getNotificationBox().size() == 0){
                        System.out.println("___________________");
                        System.out.println("You have 0 Notifications.");
                        System.out.println("___________________");
                      break;
                    }

                    System.out.println("___________________");
                    user.ShowNotifications();
                    System.out.println("___________________");
                    System.out.println("Enter anything to return User Panel.");
                    scanner.nextLine();
                  break;
                default:
                    exit = 1;
            }
        }
    }
}
