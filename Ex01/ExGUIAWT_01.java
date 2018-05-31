import java.applet.*;
import java.awt.*;


public class ExGUIAWT_01 extends Applet{
  public void init(){
    resize(400,300);
  }
  public void paint(Graphics g){
    g.setColor(Color.red);
    g.drawOval(100,50,200,200);
    g.drawString("April 13, 2018",150,150);
  }
}
