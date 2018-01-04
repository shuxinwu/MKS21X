abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
  private String author;
  private String title;
  private String ISBN;
  private String callNumber;

  public LibraryBook(String a, String t, String I, String c){
    author = a;
    title = t;
    ISBN = I;
    callNumber = c;
  }

  public String getAuthor(){ return author; }
  public String getTitle(){ return title; }
  public String getISBN(){ return ISBN; }
  public String getCallNum(){ return callNumber; }

  public void setAuthor(String a){ author = a; }
  public void setTitle(String a){ title = a; }
  public void setISBN(String a){ ISBN = a; }
  public void setCallNum(String a){ callNumber = a; }

  public abstract void checkout(String patron, String due);

  public abstract void returned();

  public abstract String circulationStatus();

  public int compareTo(LibraryBook a){
    return a.getCallNum().compareTo(this.getCallNum());
  }

  public String toString(){
    return super.toString() + "   " + circulationStatus() + "   " + callNumber;
  }

}
