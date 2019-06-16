package com.gfg.laviksha.SpringRestDemo.UserData;

import com.gfg.laviksha.SpringRestDemo.Model.User;

import java.util.HashMap;

public class UserData {
   public  static HashMap<Long, User> users=new HashMap<Long,User>();

    static {
     User user0=new User(0,"lavi","soni");
        User user1=new User(1,"laviksha","soni");
        User user2=new User(2,"xyz","soni");

        users.put(user0.getId(),user0);
        users.put(user1.getId(),user1);
        users.put(user2.getId(),user2);

    }
}
