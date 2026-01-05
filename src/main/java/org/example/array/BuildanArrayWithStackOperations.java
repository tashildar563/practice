package org.example.array;

import org.example.Solution;

public class BuildanArrayWithStackOperations implements Solution {

  @Override
  public void logic() {
    int[] target = {1, 3};
    int n = 3;
    int [] fr = new int[n+1];
    for (int k : target) {
      fr[k]++;
    }
    String[] res = new String[3];
    int j=1;
    while(j<fr.length){
      if(fr[j]>=1){
        res[j-1]="Push";
      }else {
        res[j-1]="Pop";
      }
      j++;
    }
    int m=0;
    while(m<res.length){
      System.out.println(res[m]);
      m++;
    }

  }

  @Override
  public String description() {
    return "Q1. Build an Array With Stack Operations";
  }

  @Override
  public String problemStatement() {
    return "You are given an integer array target and an integer n.\n"
        + "\n"
        + "You have an empty stack with the two following operations:\n"
        + "\n"
        + "\"Push\": pushes an integer to the top of the stack.\n"
        + "\"Pop\": removes the integer on the top of the stack.\n"
        + "You also have a stream of the integers in the range [1, n].\n"
        + "\n"
        + "Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target. You should follow the following rules:\n"
        + "\n"
        + "If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.\n"
        + "If the stack is not empty, pop the integer at the top of the stack.\n"
        + "If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.\n"
        + "Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "Input: target = [1,3], n = 3\n"
        + "Output: [\"Push\",\"Push\",\"Pop\",\"Push\"]\n"
        + "Explanation: Initially the stack s is empty. The last element is the top of the stack.\n"
        + "Read 1 from the stream and push it to the stack. s = [1].\n"
        + "Read 2 from the stream and push it to the stack. s = [1,2].\n"
        + "Pop the integer on the top of the stack. s = [1].\n"
        + "Read 3 from the stream and push it to the stack. s = [1,3].\n"
        + "Example 2:\n"
        + "\n"
        + "Input: target = [1,2,3], n = 3\n"
        + "Output: [\"Push\",\"Push\",\"Push\"]\n"
        + "Explanation: Initially the stack s is empty. The last element is the top of the stack.\n"
        + "Read 1 from the stream and push it to the stack. s = [1].\n"
        + "Read 2 from the stream and push it to the stack. s = [1,2].\n"
        + "Read 3 from the stream and push it to the stack. s = [1,2,3].\n"
        + "Example 3:\n"
        + "\n"
        + "Input: target = [1,2], n = 4\n"
        + "Output: [\"Push\",\"Push\"]\n"
        + "Explanation: Initially the stack s is empty. The last element is the top of the stack.\n"
        + "Read 1 from the stream and push it to the stack. s = [1].\n"
        + "Read 2 from the stream and push it to the stack. s = [1,2].\n"
        + "Since the stack (from the bottom to the top) is equal to target, we stop the stack operations.\n"
        + "The answers that read integer 3 from the stream are not accepted.\n"
        + " ";
  }

  @Override
  public String getToughness() {
    return "Easy";
  }

  class Stack {

    int[] elements=new int[10];
    int size = 0;

    public void push(int s) {
      if(size>(elements.length/2)){
        int [] newArr = new int[(elements.length*2)];
        for(int k=0;k<elements.length;k++){
          newArr[k]=elements[k];
        }
        elements=newArr;
      }
      elements[size] = s;
      size++;
    }

    public int pop() {
      int pop = elements[size - 1];
      int[] revised = new int[size - 1];
      if ((size - 1) != 0) {
        for(int i=0;i<size-1;i++){
          revised[i]=elements[i];
        }
      }
      elements = revised;
      size--;
      return pop;
    }

  }
}
