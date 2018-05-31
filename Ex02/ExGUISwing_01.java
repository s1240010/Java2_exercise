import javax.swing.JFrame;

public class ExGUISwing_01 extends JFrame{
  ExGUISwing_01(String s){
      super(s);    //親クラスがJFrameなので
      setSize(400,200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    ExGUISwing_01 gui = new ExGUISwing_01("ExGUISwing-01");
    gui.setVisible(true);
  }
}
