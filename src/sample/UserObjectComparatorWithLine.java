package sample;

import java.util.Comparator;

/**
 * Created by Kevin on 2015/10/27.
 */
public class UserObjectComparatorWithLine implements Comparator<UserObject> {

    @Override
    public int compare(UserObject u1, UserObject u2) {
        return u1.getLine().compareTo(u2.getLine());
    }
}
