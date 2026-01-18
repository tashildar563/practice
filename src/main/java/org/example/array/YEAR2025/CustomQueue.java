package org.example.array.YEAR2025;

public class CustomQueue {

  private int arr[];
  private int size;
  public CustomQueue(int size){
    this.arr = new int[size];
    this.size =size;
  }

  public void enque(int element){
    if(size<0){
      System.out.println("Queue Over flow ");
      return;
    }
    arr[size-1]=element;
    size--;
  }

  public boolean isPresent(){
    return arr.length>0;
  }

  public Integer deque() {
    int s = arr.length;
    if(s<1){
      System.out.println("Queue underflow");
    }
    int element = arr[s-1];
    int arrC[] = new int[s-1];
    for(int i=0;i<arr.length-1;i++){
      arrC[i] = arr[i];
    }
    arr = arrC;
    return element;
  }

  public int getSize() {
    return size;
  }
}
