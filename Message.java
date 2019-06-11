package project;

public class Message{
    private String message;
    private String getterPerson;
    private String senderPerson;


    //Constructor
    public Message() {
        this.message = " ";
        this.getterPerson = " ";
        this.senderPerson = " ";
    }

    public Message(String message) {
        this.message = message;
        this.getterPerson = "";
        this.senderPerson = "";
    }

    //Getters and Setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getGetterPerson() { return getterPerson; }
    public void setGetterPerson(String getterPerson) { this.getterPerson = getterPerson; }

    public String getSenderPerson() { return senderPerson; }
    public void setSenderPerson(String senderPerson) { this.senderPerson = senderPerson; }
}
