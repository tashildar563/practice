package org.example.userManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManagement {
    private static UserManagement userManagement;
    private List<User> userList = new ArrayList<>();
    private List<String> names;
    private int lastId = 0;
    public static UserManagement getInstance(){
        if(userManagement==null){
            userManagement = new UserManagement();
        }
        return userManagement;
    }
    public boolean addUser(String name){
        if(names==null){
            names = new ArrayList<>();
        }

        if(names.contains(name)){
            System.out.println("User with name "+name+" already present");
            return false;
        }else{
           lastId++;
           userList.add(new User(lastId,name));
           names.add(name);
           return true;
        }
    }

    public User getByUserId(Integer id){
        User u = null;
        for(User user:userList){
            if(id.equals(user.getId())){
                u=user;
                break;
            }
        }
        return u;
    }

    public boolean deleteUserById(Integer id){
        boolean deleted = false;
        for(User user:userList){
            if(id.equals(user.getId())){
                userList.remove(user);
                deleted=true;
                break;
            }
        }
        return deleted;
    }

    public List<Map<String,String>> getEmployeeList(){
        List<Map<String,String>> list = new ArrayList<>();
        if(userList==null){
            return list;
        }
        for(User user:userList){
            Map<String,String> map = new HashMap<>();
            map.put(user.getId().toString(),user.getName());
            list.add(map);
        }
        return list;
    }
}
