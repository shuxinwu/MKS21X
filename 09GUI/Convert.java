import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Convert extends JFrame implements ActionListener{
  private Container pane;
  private JButton b1, b2;
  private JTextField t1, t2;

  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    String text = t1.getText();
    double d = Double.parseDouble(text);
    //    System.out.println(s);
    //    System.out.println(text);
    //    System.out.println(d);

    if (s.equals("F to C")){
      String v = String.valueOf(FtoC(d));
      t2.setText(v);
    }
    else{
      String v = String.valueOf(CtoF(d));
      t2.setText(v);
    }
  }

  public Convert(){
    this.setTitle("Converting...");
    this.setSize(600, 150);
    this.setLocation(800, 100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
    b1 = new JButton("F to C");
    b2 = new JButton("C to F");
    t1 = new JTextField(50);
    t2 = new JTextField(50);

    b1.addActionListener(this);
    b2.addActionListener(this);
    t1.addActionListener(this);

    pane.add(t1);
    pane.add(b1);
    pane.add(b2);
    pane.add(t2);

    t2.setEditable(false);

  }

  public static void main(String[] args){
    Convert g = new Convert();
    g.setVisible(true);
  }

  public static double CtoF(double t){
    return t * 9.0 / 5.0 + 32.0;
  }

  public static double FtoC(double t){
    return (t - 32.0) * 5.0 / 9.0;
  }

  /* test for conversion methods
  public static void main(String[] args){
    System.out.println(CtoF(-40.0)); //-40.0
    System.out.println(CtoF(100.0)); //212.0
    System.out.println(FtoC(212.0)); //100.0
  }
  */
}
