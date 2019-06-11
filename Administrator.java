package project;

import java.util.Calendar;

public class Administrator{
    //Field
    //gets todays calendar info
    private Calendar cal= Calendar.getInstance();
    private int day = cal.get(Calendar.DAY_OF_MONTH);
    private int month = cal.get(Calendar.MONTH);

    
    public void CallBirthday(UserClass user){
        //Checks if todays date and users birthday is same
        if (day == user.getDayOfBirth() && month+1 == user.getMonthOfBirth()){
            user.SendToNotificationBox("Happy Birthday "+ user.getName());
        }
    }
}
