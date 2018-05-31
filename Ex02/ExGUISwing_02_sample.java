import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


class ExGUISwing_02_sample extends ExGUISwing_01 {
    JButton bp,ba,bf,bc,bu,bd;
    JPanel panel;
    JLabel label;

    ExGUISwing_02_sample(){
        super("ExGUISwing_02");
        Container cp = new Container();
        BevelBorder bo = new BevelBorder(BevelBorder.LOWERED);
        label = new JLabel("power off");
        panel = new JPanel();
        bp = new JButton("PW");
        ba = new JButton("AM");
        bf = new JButton("FM");
        bc = new JButton("CD");
        bu = new JButton("Up");
        bd = new JButton("Down");

        label.setFont(new Font("Century", Font.BOLD,33));
        cp.setLayout(null);

        cp.add(bp);
        cp.add(ba);
        cp.add(bf);
        cp.add(bc);
        cp.add(bu);
        cp.add(bd);



        label.setSize(140,100); label.setForeground(new Color(0,100,0,255));//RGB of DARK_GREEN
        panel.setLocation(100,10); panel.setSize(190,150); panel.setBorder(bo); panel.setLayout(new BorderLayout());

        bp.setLocation(10,10);  bp.setSize(80,30);
        ba.setLocation(10,60); ba.setSize(80,30);
        bf.setLocation(10,120); bf.setSize(80,30);
        bc.setLocation(300,10); bc.setSize(80,30);
        bu.setLocation(300,60); bu.setSize(80,30);
        bd.setLocation(300,120); bd.setSize(80,30);

        panel.add(label,BorderLayout.CENTER);
        cp.add(panel);

        add(cp);

    }


    public static void main(String argv[]){
        new ExGUISwing_02().setVisible(true);
    }


}
