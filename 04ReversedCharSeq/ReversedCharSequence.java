import java.lang.*;

class ReversedCharSequence implements CharSequence{
  private String orig;
  private String flipped;

  public ReversedCharSequence(String a){
    orig = a;
    String s = "";
    for (int i = a.length() - 1; i >= 0; i--){
      s += a.charAt(i);
    }
    flipped = s;
  }

  public char charAt(int index){
    return flipped.charAt(index);
  }

  public int length(){
    return flipped.length();
  }

  public CharSequence subSequence(int start, int end){
    return flipped.substring(start, end);
  }

  public String toString(){
    return flipped;
  }
}
