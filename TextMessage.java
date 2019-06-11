package project;

import java.util.ArrayList;
import java.util.Scanner;

public class TextMessage extends Message {

    public TextMessage(String message){
        super(message);
    }
     public TextMessage(){
         super();
     }

    @Override
    public String getGetterPerson() {
        return super.getGetterPerson();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String getSenderPerson() {
        return super.getSenderPerson();
    }

    @Override
    public void setGetterPerson(String getterPerson) {
        super.setGetterPerson(getterPerson);
    }

    @Override
    public void setSenderPerson(String senderPerson) {
        super.setSenderPerson(senderPerson);
    }

    public void SendMessage(UserClass user1, UserClass user2, String message) {
        FollowSystem Following = new FollowSystem();
        //constructs message for person
        setSenderPerson(user1.getName());
        setGetterPerson(user2.getName());
        setMessage(message);

        //controls if user is followed
        if (Following.IsEachOtherFollowing(user1, user2)) {
            ArrayList<Message> list = new ArrayList<Message>();
            ArrayList<String> slist = new ArrayList<>();

            list = user1.getOutgoing();
            list.add(this);
            user1.setOutgoing(list);

            list = user2.getIncoming();
            list.add(this);
            user2.setIncoming(list);
            user2.SendToNotificationBox("You got a new message from " + user1.getName());

            int controller = 0;
            //controls users inbox
            for (int j = 0; j < user2.getIncoming().size(); j++) {
                //adds 1 to counter when it finds first this message
                if (this.equals(user2.getIncoming().get(j))) {
                    controller++;
                }

                //controls if there's 2nd same message in boxes
                if (controller == 2) {
                    //removes this message if there's same message in outbox
                    list = user1.getOutgoing();
                    list.remove(this);
                    user1.setOutgoing(list);

                    //removes this message if there's same message in inbox
                    list = user2.getIncoming();
                    list.remove(this);
                    user2.setIncoming(list);

                    //removes this notification if there's same notification
                    slist = user2.getNotificationBox();
                    slist.remove(user2.getNotificationBox().size() - 1);
                    user2.setNotificationBox(slist);
                    break;
                }
            }
        }
    }

    public void MessagingPanel(UserClass user) {
        Scanner scanner = new Scanner(System.in);
        int no = user.getFollowedList().size();
        System.out.println("Please select who do you want to send message");

        for (int i = 1; i < no + 1; i++) {
            System.out.println(i + ". " + user.getFollowedList().get(i - 1).getName());
        }
        int choose = scanner.nextInt() - 1;

        scanner.nextLine(); // Dummy
        setSenderPerson(user.getName());
        setGetterPerson(user.getFollowedList().get(choose).getName());

        System.out.println("Please write your message: ");
        String msg = scanner.nextLine();
        setMessage(msg);

        SendMessage(user,user.getFollowedList().get(choose),getMessage());
        System.out.println("Your message sent!");
    }
}
