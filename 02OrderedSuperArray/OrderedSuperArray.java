public class OrderedSuperArray extends SuperArray{

    public OrderedSuperArray(){
      super();
    }

    public OrderedSuperArray(int capacity){
      super(capacity);
    }

    public OrderedSuperArray(String[] ary){
      for (int x = 0; x < ary.length; x++){
        super.add(x, ary[x]);
      }
    }

  public void add(int index, String element){
    index = findIndex(element);
    super.add(index, element);
  }

  public void add(String element){
    int index = findIndex(element);
    super.add(index, element);
  }

    private int findIndex(String element){
      int index = super.getData().length - 1;
      for (int x = 0; x < super.getData().length; x++){
        if (element.compareTo(super.getData()[x]) >= 0){
          index = x;
        }
      }
      return index;
    }

  private int findIndexBinary(String element){
    int index = super.getData().length / 2;
    for (int x = 0; x < super.getData().length / 2; x++){
      if (super.getData()[index].compareTo(element) > 0){
        index = index / 2;
      }
      if (super.getData()[index].compareTo(element) < 0){
        index = index + index / 2;
      }
      else{
        return index;
      }
    }
    return index;
  }

}
