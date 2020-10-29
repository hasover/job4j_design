package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {
    public static Info diff(List<User> previous, List<User> current) {
        Map<Integer,User> previousUsers = previous.
                                          stream().
                                          collect(Collectors.toMap(user -> user.id, user -> user));
        Map<Integer,User> currentUsers = current.
                                          stream().
                                          collect(Collectors.toMap(user -> user.id, user -> user));
        int added = 0, changed = 0, deleted = 0, same = 0;
        for (Integer key : previousUsers.keySet()) {
            if (currentUsers.containsKey(key)) {
                if (previousUsers.get(key).name.equals(currentUsers.get(key).name)) {
                    same++;
                }
                else {
                    changed++;
                }
            }
            else {
                deleted++;
            }
        }
        added = currentUsers.size() - changed - same;
        return new Info(added, changed, deleted);

    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }
}