package io.toru.daggerexample.network;

/**
 * Created by toru on 2016. 9. 15..
 */
public class NetworkApi {
    public boolean validateUser(String username, String password) {
        // imagine an actual network call here
        // for demo purpose return false in "real" life
        if (username == null || username.length() == 0) {
            return false;
        } else {
            return true;
        }
    }
}