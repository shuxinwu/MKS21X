public class Barcode{
  private String zip;
  String[] translation = {
    "||:::", ":::||", "::|:|",
    "::|:|", ":|::|", ":|:|:",
    ":||::", "|:::|", "|:|::",
    "|:|::"
  };

  public Barcode(String a){
    zip = a;
  }

  public String getZip(){
    return zip;
  }

  public String getCode(){
    String code = "|";
    for (int x = 0; x < zip.length(); x++){
      code += convert(zip.charAt(x));
    }
    code += convert(makeCheckSum());
    code += "|";
    return code;
  }

  public String convert(char z){
    int index = (int)z;
    if (index > translation.length){
        index -= 48;
    }
    return translation[index];
  }

  public String toString(){
    return getCode() + "\t" + getZip() + " " + (int)makeCheckSum();
  }

  public char makeCheckSum(){
    int sum = 0;
    for (int x = 0; x < zip.length(); x++){
      sum += zip.charAt(x);
    }
    sum = sum % 10;
    return (char)sum;
  }

  public int compareTo(Barcode bar){
    return this.getZip().compareTo(bar.getZip());
  }

  public boolean equalsTo(Barcode bar){
    return this.getZip().equals(bar.getZip());
  }
}
