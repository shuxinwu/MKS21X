public class CirculatingBook extends LibraryBook{
  private String currentHolder;
  private String dueDate;

  public CirculatingBook(String a, String b, String c, String d){
    super(a, b, c, d);
    currentHolder = null;
    dueDate = null;
  }

  public String getCurrentHolder(){ return currentHolder; }
  public String getDueDate(){ return dueDate; }

  public void setCurrentHolder(String a){ currentHolder = a; }
  public void setDueDate(String a){ dueDate = a; }

  public void checkout(String patron, String due){
    currentHolder = patron;
    dueDate = due;
  }

  public void returned(){
    currentHolder = null;
    dueDate = null;
  }

  public String circulationStatus(){
    if (dueDate != null){
      return getCurrentHolder() + "   " + getDueDate();
    }
    else{
      return "book available on shelves";
    }
  }

  public String toString(){
    if (dueDate != null){
      return super.toString() + "   " + getCurrentHolder() + "   " + getDueDate();
    }
    else{
      return super.toString();
    }

  }

}
