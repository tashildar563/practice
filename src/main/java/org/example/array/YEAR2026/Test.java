package org.example.array.YEAR2026;

import java.util.HashMap;

public class Test {
  static class Employee{
    int id;
    String name;
    String code;

    public Employee(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }
  }
  public static void main(String... args) {
    HashMap<Employee,Integer> map = new HashMap<>();
    Employee employee = new Employee(1,"A");
    map.put(employee,1);
    //
    System.out.println("check map");

  }
}
