public class ReferenceBook extends LibraryBook{
  private String collection;

  public ReferenceBook(String a, String b, String c, String d, String e){
    super(a, b, c, d);
    collection = e;
  }
  public String getCollection(){ return collection; }

  public void setCollection(String a){ collection = a; }

  public void checkout(String patron, String due){
    System.out.println("cannot check out a reference book");
  }

  public void returned(){
    System.out.println("reference book could not have been checked out--return impossible");
  }

  public String circulationStatus(){
    return "non-circulating reference book";
  }

  public String toString(){
    return super.toString() + "   " + getCollection();
  }
}
