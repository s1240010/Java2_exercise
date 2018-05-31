import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class ExGUISwing_03 extends ExGUISwing_02 implements ActionListener{
  private JLabel label2;
  private int[] am_Hz= {594,954,1134,1242};
  private double[] fm_Hz = {76.1,80.0,81.3,82.5};
  private int i=0;
  private int j=0;
  private int k=0;
  private int flag=0;
  //private JPanel panel_2;
  ExGUISwing_03(){
    super();
    label2 =  new JLabel("");
    //Fm = new JLabel("FM");
    am.setContentAreaFilled(false);
    fm.setContentAreaFilled(false);
    pw.addActionListener(this);
    am.addActionListener(this);
    fm.addActionListener(this);
    cd.addActionListener(this);
    up.addActionListener(this);
    down.addActionListener(this);

    label2.setSize(50,50);
    panel.add(label2,BorderLayout.NORTH);
  }

  public void actionPerformed(ActionEvent e){
    Object o = e.getSource();
    if(o == am){
      pw.setEnabled(true);
      up.setEnabled(true);
      label2.setText("AM");
      flag=1;
      if(i == 0) down.setEnabled(false);
      label.setText(am_Hz[i]+"  kHz");
    }else if(o == fm){
      pw.setEnabled(true);
      up.setEnabled(true);
      label2.setText("FM");
      flag=2;
      label.setText(fm_Hz[j]+"  MHz");
    }
    else if(o == up){
      if(i==0 || j==0 || k==0) down.setEnabled(true);
      if(flag == 1){
        i++;
        if(i>=3){
          i=3;
          up.setEnabled(false);
        }
        label.setText(am_Hz[i]+"  kHz");
      }else if(flag == 2){
        j++;
        if(j>=3){
           j=3;
           up.setEnabled(false);
         }
        label.setText(fm_Hz[j]+"  MHz");
      }
      else if(flag == 3){
        k++;
        if(k>=20){
          k=20;
          up.setEnabled(false);
        }
        label.setText("Track"+k+"/...");
      }
    }
    else if(o == down){
      if(flag == 1){
        i--;
        if(i<=0){
          i=0;
          down.setEnabled(false);
        }
        if(i == 0) down.setEnabled(false);
        label.setText(am_Hz[i]+"  kHz");
      }else if(flag == 2){
        j--;
        if(j<=0){
           j=0;
           down.setEnabled(false);
         }
        if(j == 0) down.setEnabled(false);
        label.setText(fm_Hz[j]+"  MHz");
      }else if(flag == 3){
        k--;
        if(k<=1){
          k=1;
          down.setEnabled(false);
        }
        label.setText("Track"+k+"/...");
      }
    }
    else if(o == pw){
      label.setText("power off");
      label2.setText("");
      pw.setEnabled(false);
      up.setEnabled(false);
      down.setEnabled(false);
      i=j=k=0;
    }else if(o == cd){
      pw.setEnabled(true);
      pw.setEnabled(true);
      up.setEnabled(true);
      flag=3;
      k=1;
      label2.setText("");
      label.setText("Track"+k+"/...");
    }
  }
  public static void main(String[] args) {
    ExGUISwing_03 gui = new ExGUISwing_03();
    gui.setVisible(true);
  }
}
