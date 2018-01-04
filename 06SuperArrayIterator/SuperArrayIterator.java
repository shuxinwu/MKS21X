import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
  private SuperArray a;
  private int current;

  public SuperArrayIterator(SuperArray b, int c){
    a = b;
    current = c;
  }

  // true if iteration has more elements
  public boolean hasNext(){
    return current < a.size();
  }

  // next element in iteration
  public String next(){
    if (hasNext()){
      current++;
    }
    else{
      System.exit(0);
    }
    return a.get(current - 1);
  }

  // unsupported
  public void remove(){
    throw new UnsupportedOperationException();
  }

}
