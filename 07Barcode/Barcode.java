import java.util.Arrays;

public class Barcode implements Comparable<Barcode>{
  private String zip;
  private String code;
  String[] translation = {
    "||:::", ":::||", "::|:|",
    "::||:", ":|::|", ":|:|:",
    ":||::", "|:::|", "|::|:",
    "|:|::"
  };

  public Barcode(String z){
    if (zipCheck(z)){
      zip = z;
    }
    else{
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < zip.length(); i++){
      code += translation[zip.charAt(i) - 48];
    }
  }

  public boolean zipCheck(String z){
    int count = 0;
    for (int i = 0; i < z.length(); i++){
      if (Character.isDigit(z.charAt(i))){
        count++;
      }
    }
    return count == 5;
  }

  public int compareTo(Barcode other){
    return this.getZip().compareTo(other.getZip());
  }

  public static String toCode(String z){
    String c = "";
    String[] t = {
    "||:::", ":::||", "::|:|",
    "::||:", ":|::|", ":|:|:",
    ":||::", "|:::|", "|::|:",
    "|:|::"
    };
    int count = 0;
    for (int i = 0; i < z.length(); i++){
      if (Character.isDigit(z.charAt(i))){
        count++;
      }
    }
    if (count != 5){
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < z.length(); i++){
      c += t[z.charAt(i) - 48];
    }
    count = 0;
    for (int i = 0; i < z.length(); i++){
      count += z.charAt(i) - 48;
    }
    c += t[count % 10];

    return "|"+ c + "|";
  }

  public static String toZip(String c){
    String z = "";
    String checkSum = "";
    String[] t = {
    "||:::", ":::||", "::|:|",
    "::||:", ":|::|", ":|:|:",
    ":||::", "|:::|", "|::|:",
    "|:|::"
    };

    if (c.charAt(0) != '|' || c.charAt(c.length() - 1) != '|'){
      throw new IllegalArgumentException();
    }
    int count = 0;
    for (int i = 0; i < c.length(); i++){
      if (c.charAt(i) == '|' || c.charAt(i) == ':'){
        count++;
      }
    }
    if (count != 32){
      throw new IllegalArgumentException();
    }
    for (int i = 1; i < 26; i+=5){
      if (c.substring(i, i + 5).equals("|||||") || c.substring(i, i + 5).equals(":::::")){
        throw new IllegalArgumentException();
      }
    }
    for (int i = 1; i < 26; i+=5){
      for (int x = 0; x < t.length; x++){
        if (c.substring(i, i + 5).equals(t[x])){
          z += x;
        }
      }
    }
    for (int x = 0; x < t.length; x++){
      if (c.substring(26, 31).equals(t[x])){
        checkSum += t[x];
      }
    }
    count = 0;
    for (int i = 0; i < z.length(); i++){
      count += z.charAt(i) - 48;
    }
    if (!(t[count % 10].equals(checkSum))){
      throw new IllegalArgumentException();
    }
    return z;
  }

  public String getCode(){
    return "|" + code.substring(4) + checkSum(zip) + "|";
  }

  public String getZip(){
    return zip;
  }

  public String toString(){
    return getCode() + " (" + getZip() + ")";
  }

  public String checkSum(String z){
    int count = 0;
    for (int i = 0; i < z.length(); i++){
      count += z.charAt(i) - 48;
    }
    return translation[count % 10];
  }
}
