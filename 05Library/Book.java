public class Book{
  private String author;
  private String title;
  private String ISBN;

  public Book(){ }

  public Book(String a, String b, String c){
    author = a;
    title = b;
    ISBN = c;
  }

  public String getAuthor(){ return author; }
  public String getTitle(){ return title; }
  public String getISBN(){ return ISBN; }

  public void setAuthor(String a){
    author = a;
  }

  public void setTitle(String b){
    title = b;
  }

  public void setISBN(String c){
    ISBN = c;
  }

  public String toString(){
    return getTitle() + "   " + getAuthor() + "   " + getISBN();
  }
}
