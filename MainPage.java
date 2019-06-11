package project;

public class MainPage {

    //Gets all posts from main page
    public void getMainPage( UserClass user ){

        for(int i=0; i<user.getPostList().size(); i++){
            
            System.out.println("__________________");
            System.out.println( i+1 + ". Post\n" + user.getPostList().get(i).getSharer()+"\n");
            System.out.println(user.getPostList().get(i).getContent());
            System.out.println(user.getPostList().get(i).getLikes() + " Likes ");
            System.out.println(user.getPostList().get(i).getComments().size()+" Comments");
            System.out.println("__________________");
        }
    }
    //Gets selected post from main page
    public void getMainPage( UserClass user, int i ){
        
        System.out.println("__________________");
        System.out.println( i + ". Post\n" + user.getPostList().get(i-1).getSharer()+"\n");
        System.out.println(user.getPostList().get(i-1).getContent());
        System.out.println(user.getPostList().get(i-1).getLikes() + " Likes ");
        System.out.println(user.getPostList().get(i-1).getComments().size()+" Comments");
        System.out.println("__________________");
    }
}
