package project;

import java.util.Scanner;

public class Register{
    //Register panel for user
    public UserClass Registering()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\t\t\t***Our Java Project***\n\t-Deyan Bora Çetin -Ege Bulut\n");
        System.out.println("Please fill the blanks with valid answers.");

        //creates new user object
        UserClass user = new UserClass();

        System.out.println("User Name\t:");
        String name = scanner.nextLine();
        user.setName(name);

        System.out.println("\nE-mail\t:");
        String email = scanner.nextLine();
        user.setEmail(email);

        System.out.println("\nPlease enter your birth date one by one:");

        //Getting day info
        System.out.println("Day\t: ");
        int dayOfBirth = scanner.nextInt();
        user.setDayOfBirth(dayOfBirth);
        scanner.nextLine(); //Dummy
        while (user.getDayOfBirth() < 1 || user.getDayOfBirth() > 31)
        {
            System.out.println("This day of birth value is not valid, please enter a valid day value\t: ");
            System.out.println("Day\t: ");
            dayOfBirth = scanner.nextInt();
            user.setDayOfBirth(dayOfBirth);
            scanner.nextLine(); //Dummy
        }

        //Getting month info
        System.out.println("Month\t: ");
        int monthOfBirth = scanner.nextInt();
        user.setMonthOfBirth(monthOfBirth);
        scanner.nextLine(); //Dummy
        while (user.getMonthOfBirth() < 1 || user.getMonthOfBirth() > 12)
        {
            System.out.println("This month of birth value is not valid, please enter a valid month value\t: ");
            System.out.println("Month\t: ");
            monthOfBirth = scanner.nextInt();
            user.setMonthOfBirth(monthOfBirth);
            scanner.nextLine(); //Dummy
        }

        //Getting year info
        System.out.println("Year\t: ");
        int yearOfBirth = scanner.nextInt();
        user.setYearOfBirth(yearOfBirth);
        scanner.nextLine();//Dummy
        while (user.getYearOfBirth() <= 1923 || user.getYearOfBirth() > 2012)
        {
            System.out.println("This year of birth value is not valid, please enter a valid year value\t: ");
            System.out.println("Year\t: ");
            yearOfBirth = scanner.nextInt();
            user.setYearOfBirth(yearOfBirth);
            scanner.nextLine();//Dummy
        }

        //Getting place of residence info
        System.out.println("Please enter your place of residence:");
        String place = scanner.nextLine();
        user.setPlace(place);

        //returns UserClass object for our user
        return user;
    }
}
