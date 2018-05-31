import java.awt.*;
import  javax.swing.*;
import javax.swing.border.*;

public class ExGUISwing_02 extends ExGUISwing_01{
  protected JButton pw;
  protected JButton am;
  protected JButton fm;
  protected JButton cd;
  protected JButton up;
  protected JButton down;
  protected JPanel panel;
  protected JLabel label;
  Container contentPane;
  BevelBorder bd;
  ExGUISwing_02(){
    super("ExGUISwing_02");
    contentPane = new Container();
    bd = new BevelBorder(BevelBorder.LOWERED);
    label = new JLabel("power off");
    panel = new JPanel();
    pw =new JButton("PW");
    am =new JButton("AM");
    fm =new JButton("FM");
    cd =new JButton("CD");
    up =new JButton("Up");
    down =new JButton("Down");

    label.setFont(new Font("Century",Font.BOLD,33));
    contentPane.setLayout(null);


    //panel.setBorder(new LineBorder(Color.RED , 5));

    contentPane.add(pw);
    contentPane.add(am);
    contentPane.add(fm);
    contentPane.add(cd);
    contentPane.add(up);
    contentPane.add(down);

    label.setSize(140,100);
    label.setForeground(new Color(0,100,0,255));//RGB of DARK_GREEN
    panel.setLocation(100,10);
    panel.setSize(190,150);
    panel.setBorder(bd);
    panel.setLayout(new BorderLayout());

       pw.setLocation(10,10);  pw.setSize(80,30);
       am.setLocation(10,60); am.setSize(80,30);
       fm.setLocation(10,120); fm.setSize(80,30);
       cd.setLocation(300,10); cd.setSize(80,30);
       up.setLocation(300,60); up.setSize(80,30);
       down.setLocation(300,120); down.setSize(80,30);

       panel.add(label,BorderLayout.CENTER);
       contentPane.add(panel);

    add(contentPane);

  }
  public static void main(String[] args) {
    ExGUISwing_02 gui = new ExGUISwing_02();
    gui.setVisible(true);
  }
}
