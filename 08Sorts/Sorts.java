import java.util.Arrays;

public class Sorts{

  public static String name(){
    return "01.Wu.ShuXin";
  }

  public static void selectionSort(int[] data){
    int[] sorted;
    sorted = new int[data.length];

    for (int i = 0; i < data.length; i++){
      int current = data[i];
      for (int x = i; x < data.length; i++){
        if (data[x] < current){
          current = data[x];
        }
      }
      sorted[i] = current;
    }
    data = sorted;
    System.out.println(data);
  }

  public static void insertionSort(int[] data){
    //  int[] sorted;
    //  sorted = new int[data.length];

    for (int i = 0; i < data.length; i++){
      for (int x = i; x > 0; x--){
        if (data[x] < data[x - 1]){
          data = data.swap(data, i, i - 1);
        }
      }
    }

  }

  public void swap(int[] ary, int a, int b){
    int c = a;
    ary[a] = ary[b];
    ary[b] = ary[c];
  }

}
