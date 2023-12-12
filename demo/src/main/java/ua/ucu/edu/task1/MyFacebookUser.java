package ua.ucu.edu.task1;

import java.time.LocalDate;

public class MyFacebookUser implements User {

    private FacebookUser facebookUser;

    public MyFacebookUser(FacebookUser facebookUser) {
        this.facebookUser = facebookUser;
    }

    public String getEmail() {
        return facebookUser.getEmail();
    }

    public String getCountry() {
        return facebookUser.getUserCountry();
    }

    public LocalDate getLastActiveDate() {
        return facebookUser.getUserActiveTime().toLocalDate();
    }

}
