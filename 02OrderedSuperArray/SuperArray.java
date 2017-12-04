public class SuperArray{
  private String[] data;
  private int size;

  public SuperArray(){
    size = 10;
    data = new String[10];
  }

  public SuperArray(int startingCapacity){
    data = new String[startingCapacity];
  }

  public void clear(){
    for (int x = 0; x < data.length; x++){
      data[x] = null;
    }
  }

  public int size(){
    return size;
  }

  public String[] getData(){
    return data;
  }

  public boolean isEmpty(){
    int count = 0;
    for (int x = 0; x < data.length; x++){
      if (data[x] == null){
        count++;
      }
    }
    return count == data.length;
  }
  /*
  public boolean add(String a){
    if (data[data.length - 1] != null){
      resize();
    }
    for (int x = 0; x < data.length; x++){
      if (data[x] == null){
        data[x] = a;
        x = data.length;
      }
    }
    return true;
  }
  */
  public String get(int index){
    if (index < 0 || index >= size()){
      return null;
    }
    return data[index];
  }

  public String set(int index, String element){
    if (index < 0 || index >= size()){
      throw new UnsupportedOperationException();
    }
    String oldElement = data[index];
    data[index] = element;
    return oldElement;
  }

  public String toString(){
    String g = "";
    String f = "[";
    for (int x = 0; x < data.length; x++){
      if (x == data.length - 1){
        f = f + data[x];
      }
      else{
        f = f + data[x] + ", ";
      }
    }
    f = f + "]";
    for (int x = 0; x < f.length(); x++){
      if (f.charAt(x) != '"'){
        g = g + f.charAt(x);
      }

    }
    return g;
  }

  private void resize(){
    String[] newData;
    int newLength = 2 * size;
    newData = new String[newLength];
    for (int x = 0; x < data.length; x++){
      newData[x] = data[x];
    }
    data = newData;
    size = newLength;
  }

  public boolean contains(String target){
    return indexOf(target) >= 0;
  }

  public int indexOf(String target){
    for (int x = 0; x < data.length; x++){
      if (data[x] == target){
        return x;
      }
    }
    return -1;
  }

  public int lastIndexOf(String target){

    for (int x = 0; x < data.length; x++){
      if (data[data.length - x - 1] == target){
        return data.length - x - 1;
      }
    }
    return -1;
  }

  public void add(int index, String element){
    if (data[data.length - 1] != null){
      resize();
    }
    String[] dataShift;
    dataShift = new String[size];
    for (int x = 0; x <  data.length; x++){
      if (x < index){
        dataShift[x] = data[x];
      }
      if (x == index){
        dataShift[x] = element;
      }
      if (x > index){
        dataShift[x] = data[x - 1];
      }
    }
    data = dataShift;
  }

  public String remove(int index){
    if (index < 0 || index >= size()){
      return null;
    }
    String[] dataShift;
    dataShift = new String[size];
    for (int x = 0; x < data.length - 1; x++){
      if (x < index){
        dataShift[x] = data[x];
      }
      else{
        dataShift[x] = data[x + 1];
      }
    }
    dataShift[data.length - 1] = null;
    data = dataShift;
    return data[index];
  }

  public boolean remove(String element){
    if (indexOf(element) >= 0){
      remove(indexOf(element));
      return true;
    }
    return false;
  }

}
