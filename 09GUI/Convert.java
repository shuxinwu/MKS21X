import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Convert extends JFrame implements ActionListener{
  private Container pane;
  private JButton b1, b2;
  private JTextField t;

  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();

  }

  public Convert(){
    this.setTitle("Converting...");
    this.setSize(400, 500);
    this.setLocation(100, 100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
    b1 = new JButton("F to C");
    b2 = new JButton("C to F");
    t = new JTextField(15);

    b1.addActionListener(this);
    b2.addActionListener(this);
    t.addActionListener(this);

    pane.add(t);
    pane.add(b1);
    pane.add(b2);

  }

  public static double CtoF(double t){
    return t * 9.0 / 5.0 + 32.0;
  }

  public static double FtoC(double t){
    return (t - 32.0) * 5.0 / 9.0;
  }

  public static void main(String[] args){
    System.out.println(CtoF(-40.0)); //-40.0
    System.out.println(CtoF(100.0)); //212.0
    System.out.println(FtoC(212.0)); //100.0
  }
}
