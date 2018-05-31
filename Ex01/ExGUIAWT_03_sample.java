import java.applet.*;
import java.awt.*;
import java.awt.event.*;


//<applet code = "ExGUIAWT_03" width=400 height=400></applet>


public class ExGUIAWT_03_sample extends ExGUIAWT_02 implements MouseListener,MouseMotionListener{
    int p;

    public void init(){

        super.init();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g){

        super.paint(g);
    }

    public void mousePressed(MouseEvent e){
        p = e.getX();
    }


    public void mouseDragged(MouseEvent e){
        if(p < e.getX())lab.setText(String.valueOf(++cnt));
        else if(p > e.getX())lab.setText(String.valueOf(--cnt));
        p = e.getX();
    }

    public void mouseClicked(MouseEvent e){
    }

    public void mouseEntered(MouseEvent e){
    }

    public void mouseExited(MouseEvent e){
    }

    public void mouseReleased(MouseEvent e){
    }

    public void mouseMoved(MouseEvent e){
    }
}
