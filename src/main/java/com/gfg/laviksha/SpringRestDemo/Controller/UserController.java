package com.gfg.laviksha.SpringRestDemo.Controller;

import com.gfg.laviksha.SpringRestDemo.Model.User;
import com.gfg.laviksha.SpringRestDemo.UserData.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class UserController {

    HashMap<Long,User> users= UserData.users;
//get all users
    @GetMapping ("/users")
    public List<User> getAllUsers(){
        List<User> listUser=new ArrayList<User>();
        for(Map.Entry<Long,User> user:users.entrySet()){
            listUser.add(user.getValue());
        }

        return listUser;
    }
//get user by id
    @GetMapping("user/{id}")
    public User getUserById(@PathVariable Long id){
        return users.get(id);
    }

    //delete user
    @DeleteMapping ("user/{id}")
    public boolean deleteUser(@PathVariable Long id){
        if(users.containsKey(id)){
            users.remove(id);
            return true;
        }
        return  false;
    }


    //create user
@PostMapping("/user")
    public User createUser(@RequestBody User user){
        if(!users.containsKey(user.getId())){
            users.put(user.getId(),user);
            return users.get(user.getId());
        }
        return null;
    }

    //update user
    @PutMapping("/user")
    public User updateUser(@RequestBody  User user){
        if(users.containsKey(user.getId())){
            users.put(user.getId(),user);
            return users.get(user.getId());
        }
        return null;
    }


}
