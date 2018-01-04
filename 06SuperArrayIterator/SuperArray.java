import java.util.*;
import java.util.Iterator;

public class SuperArray implements Iterable<String>{
  private String[] data;
  private int size;

  public SuperArray(){
    size = 10;
    data = new String[size];
  }

  public SuperArray(int startingCapacity){
    size = startingCapacity;
    data = new String[startingCapacity];
  }

  // phase 1

  public void clear(){
    for (int i = 0; i < data.length; i++){
      data[i] = null;
    }
  }

  public int size(){
    int count = 0;
    for (int i = 0; i < data.length; i++){
      if (data[i] != null){
        count++;
      }
    }
    return count;
  }

  public boolean isEmpty(){
    return size() == 0;
  }

  public boolean add(String a){
    for (int i = 0; i < data.length; i++){
      if (data[i] == null){
        data[i] = a;
        return true;
      }
    }
    return true;
  }

  public String toString(){
    String a = "[";
    for (int i = 0; i < data.length; i++){
      if (data[i] != null){
        a += data[i];
        a += ", ";
      }
    }
    if (a.length() > 1){
      a = a.substring(0, a.length()-2);
    }
    a += "]";
    return a;
  }

  public String get(int a){
    if (a < 0 || a >= size()){
      throw new IndexOutOfBoundsException();
    }
    return data[a];
  }

  public String set(int a, String b){
    if (a < 0 || a >= size()){
      throw new UnsupportedOperationException();
    }
    String old = data[a];
    data[a] = b;
    return old;
  }

  // phase 2

  public void resize(){
    String[] newData;
    size = size * 2;
    newData = new String[size];
    for (int i = 0; i < data.length; i++){
      newData[i] = data[i];
    }
    data = newData;
  }

  // phase 3

  public boolean contains(String target){
    for (int i = 0; i < data.length; i++){
      if (data[i] == target){
        return true;
      }
    }
    return false;
  }

  public int indexOf(String target){
    for (int i = 0; i < data.length; i++){
      if (data[i] == target){
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(String target){
    for (int i = data.length; i >= 0; i--){
      if (data[i] == target){
        return i;
      }
    }
    return -1;
  }

  public void add(int a, String b){
    if (a < 0 || a >= size()){
      throw new IndexOutOfBoundsException();
    }
    String[] newData;
    size += 1;
    newData = new String[size];
    for (int i = 0; i < newData.length; i++){
      if (i < a){
        newData[i] = data[i];
      }
      if (i == a){
        newData[i] = b;
      }
      if (i > a){
        newData[i] = data[i - 1];
      }
    }
    data = newData;
  }

  public String remove(int a){
    if (a < 0 || a >= size()){
      throw new IndexOutOfBoundsException();
    }
    String[] newData;
    newData = new String[size];
    String removed = "";
    for (int i = 0; i < newData.length; i++){
      if (i < a){
        newData[i] = data[i];
      }
      if (i == a){
        removed = data[i];
        newData[i] = data[i + 1];
      }
      if (i > a){
        newData[i] = data[i + 1];
      }
    }
    data = newData;
    return removed;
  }

  public boolean remove(String a){
    for (int x = 0; x < data.length; x++){
      if (data[x].equals(a)){
        String[] newData;
        newData = new String[size];
        for (int i = 0; i < newData.length; i++){
          if (i < x){
            newData[i] = data[i];
          }
          if (i == x){
            newData[i] = data[i + 1];
          }
          if (i > x){
            newData[i] = data[i + 1];
          }
        }
        data = newData;
        return true;
      }
    }
    return false;
  }

  //iterator
  public Iterator<String> iterator(){
    return new SuperArrayIterator(this, 0);
  }

}
