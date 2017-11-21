import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordSearch{
  private char[][] data;
  public ArrayList<String> wordsToAdd = new ArrayList<String>();
  private ArrayList<String> wordsAdded = new ArrayList<String>();
  private Random randgen;
  private int val;
  public char[][] key;
  public boolean answers;

  //set everything to _
  public void clear(){
    for(int i = 0; i < data.length; i++){
      for (int x = 0; x < data[i].length; x++){
        data[i][x] = '_';
      }
    }
  }

  //format
  public String toString(){
    String grid = "";
    for (int i = 0; i < data.length; i++){
      for (int x = 0; x < data[i].length; x++){
        //        if (!answers && data[i][x] == '_'){
        //          data[i][x] = randLetter();
        //        }
        grid = grid + data[i][x] + ' ';
      }
      grid += "\n";
    }
    String words = "";
    for (int i = 0; i < wordsAdded.size(); i++){
      if (i % 3 == 0){
        words += "\n";
      }
      words = words + wordsAdded.get(i) + "\t";
    }
    return grid + words;
  }

  //initialize the stuff
  public WordSearch(int rows, int cols, String fileName){
    data = new char[rows][cols];
    for(int i = 0; i < data.length; i++){
      for (int x = 0; x < data[i].length; x++){
        data[i][x] = '_';
      }
    }
    try{
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      while(in.hasNext()){
      String line = in.nextLine();
      wordsToAdd.add(line);
      }
    }
    catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(1);
    }
  }

  public boolean addWord(int r, int c, String word, int rowIncrement, int colIncrement){
    if (rowIncrement == 0 && rowIncrement == colIncrement){
      return false;
    }
    int tries = 0;
    if (tries > 500){
      return false;
    }
    try{
      for (int i = 0; i < word.length(); i++){
        if ((r + rowIncrement < 0) || (c + colIncrement < 0) || (data[r + rowIncrement][c + colIncrement] != '_')){
          int a = randIncrement();
          int b = randIncrement();
          tries++;
          addWord(randStart(), randStart(), word, a, b);
        }
        r += rowIncrement;
        c += colIncrement;
      }
    }
    catch (ArrayIndexOutOfBoundsException e){
      int a = randIncrement();
      int b = randIncrement();
      tries++;
      addWord(randStart(), randStart(), word, a, b);
    }
    /*
    try{
      for (int i = 0; i < word.length(); i++){
        data[r + rowIncrement][c + colIncrement] = word.charAt(i);
        r += rowIncrement;
        c += colIncrement;
      }
    }
    catch (ArrayIndexOutOfBoundsException e){
      int a = randIncrement();
      int b = randIncrement();
      tries++;
      addWord(randStart(), randStart(), word, a, b);
    }
    */
    wordsAdded.add(word);
    wordsToAdd.remove(word);
    return true;
  }

  public boolean addAllWords(){
    for (int x = 0; x < wordsToAdd.size(); x++){
      int a = randIncrement();
      int b = randIncrement();
      addWord(randStart(), randStart(), wordsToAdd.get(x), a, b);
    }
    key = data.clone();
    return true;
  }

  public int randIncrement(){
    int[] incre = {-1, 0, 1};
    Random rng = new Random();
    int x = rng.nextInt() % 3;
    if (x < 0){
      x = x * -1;
    }
    return incre[x];
  }

  public char randLetter(){
    char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                      'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                      's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    Random rng = new Random();
    int x = rng.nextInt() % 26;
    if (x < 0){
      x = x * -1;
    }
    return letters[x];
  }

  public int randStart(){
    Random rng = new Random();
    int x = rng.nextInt() % 20;
    if (x < 0){
      x = x * -1;
    }
    return x;
  }

  //lengthy messages
  public static void main(String[] args){
    try{
      if (args.length == 0){
        throw new ArrayIndexOutOfBoundsException();
      }
    }
    catch(ArrayIndexOutOfBoundsException e){
      System.out.println("Hi. Seems like a lot of info is missing. Please enter the number of rows, the number of columns, and the name of the file you want for this word search, in that order.");
    }
  }
}
