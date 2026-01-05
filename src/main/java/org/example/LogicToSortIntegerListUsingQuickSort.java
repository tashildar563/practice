package org.example;

public class LogicToSortIntegerListUsingQuickSort implements Solution{

  @Override
  public void logic() {
    int[] list = {1,8,3,4,6,2};
    int n = list.length;
    quickSort(list,0,n-1);
  }

  private void quickSort(int[] list, int l, int r) {
    if(l<r){
      int pi = partition(list,l, r);
      quickSort(list,l,pi-1);
      quickSort(list,pi+1,r);
    }
  }

  private int partition(int[] list, int l, int r) {
    int pivot = list[r];
    int i= l-1;

    for(int j=l;j<=r-1;j++){
      if(list[j]<pivot){
        i++;
        swapListEle(list,i,j);
      }
    }
    swapListEle(list,i+1,r);
    return i+1;
  }

  private void swapListEle(int[] list, int i, int j) {
    int temp = list[i];
    list[i]  = list[j];
    list[j]=temp;
  }

  @Override
  public String description() {
    return "50";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
