package Lib;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserManager {
    private final Set<User> usersSet;

    public UserManager() {
        usersSet = new HashSet<>();
    }

    public synchronized void addUser(User user) {
        usersSet.add(user);
    }

    public synchronized void removeUser(User user) {
        usersSet.remove(user);
    }

    public synchronized Set<User> getUsers() {
        return Collections.unmodifiableSet(usersSet);
    }

    public boolean isUserExists(User user) {
        return usersSet.contains(user);
    }
}