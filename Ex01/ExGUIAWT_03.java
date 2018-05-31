import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ExGUIAWT_03 extends ExGUIAWT_02 implements MouseListener,MouseMotionListener{
  int point;
  public void init(){
    super.init();
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  public void paint(Graphics g){
    super.paint(g);
  }


  public void mouseClicked(MouseEvent e){}
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}
  public void mouseMoved(MouseEvent e){}

  public void mousePressed(MouseEvent e){
    point = e.getX();
  }
  public void mouseDragged(MouseEvent e){
    if(point < e.getX())
       lab.setText(String.valueOf(++cnt));
    else if(point > e.getX())
         lab.setText(String.valueOf(--cnt));
    point = e.getX();
  }
}
