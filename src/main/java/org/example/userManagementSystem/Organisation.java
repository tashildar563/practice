package org.example.userManagementSystem;

import org.example.Solution;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Organisation implements Solution {

    @Override
    public void logic() {
        UserManagement userManagement = UserManagement.getInstance();
        boolean exit=false;
        Scanner sc = new Scanner(System.in);
        while(!exit) {
            System.out.println("=========Features========");
            System.out.println("1. Add User\n2. Delete User\n3. Get List Of User\n4. Get User By id\n5 Exit");
            System.out.println("Select a feature, Enter feature Id");
            int id = sc.nextInt();
            if (id == 1) {
                System.out.println("1. Add User");
                System.out.println("Enter User Name");
                sc.nextLine();
                String name = sc.nextLine();
                userManagement.addUser(name);
            } else if (id == 2) {
                System.out.println("2. Delete User");
                System.out.println("Enter User id");
                int deleteId = sc.nextInt();
                userManagement.deleteUserById(deleteId);
            } else if (id == 3) {
                System.out.println("3. Get List Of User");
                System.out.println("List >>");
                List<Map<String, String>> list = userManagement.getEmployeeList();
                for (Map user : list) {
                    System.out.print(user.values() + "\n");
                }
            } else if (id == 4) {
                System.out.println("4. Get user by id");
                System.out.println("Enter user Id");
                int userid = sc.nextInt();
                User user = userManagement.getByUserId(id);
                System.out.println("Id : " + user.getId() + " Name : " + user.getName());
            }else if(id==5){
                exit = true;
            }
        }
    }

    @Override
    public String description() {
        return "18. User Management";
    }

    @Override
    public String problemStatement() {
        return "";
    }
}
