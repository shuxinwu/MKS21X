import java.util.Arrays;

public class Sorts{

  public static String name(){
    return "10.Wu.ShuXin";
  }

  public static boolean isSorted(int[] data){
    for (int i = 0; i < data.length - 1 ; i++){
      if (data[i] > data[i+1]){
        return false;
      }
    }
    return true;
  }

  public static void bogoSort(int[] data){
    while (!isSorted(data)){
      for (int i = 0; i < data.length; i++){
        int temp = data[i];
        int newSpot = (int)(Math.random()*data.length);
        data[i] = data[newSpot];
        data[newSpot] = temp;
      }
    }
  }

  public static void selectionSort(int[] data){


    for (int i = 0; i < data.length; i++){
      int current = data[i];
      int index = i;

      for (int x = i; x < data.length; x++){
        if (data[x] < current){
          current = data[x];
          index = x;
        }
      }
      swap(data, i, index);
      //     data[index] = data[i];
      //      data[i] = current;
    }

  }

  public static void insertionSort(int[] data){
    //  int[] sorted;
    //  sorted = new int[data.length];

    for (int i = 0; i < data.length; i++){
      for (int x = i; x > 0; x--){
        if (data[x] < data[x - 1]){
          int current = data[x];
          swap(data, x, x - 1);
        }
      }
    }

  }

  private static void swap(int[] data, int a, int b){
    int c = data[a];
    data[a] = data[b];
    data[b] = c;
  }

  public static void main(String[] args){
    int[] randish = new int[5];

    for (int i = 0; i < randish.length; i++){
      randish[i] = (int)(Math.random()*100);
    }

    System.out.println(Arrays.toString(randish));
    insertionSort(randish);
    // selectionSort(randish);
    // bogoSort(randish);
    System.out.println(Arrays.toString(randish));
  }
}
