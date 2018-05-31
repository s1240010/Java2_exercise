import java.awt.event.*;
import java.applet.*;
import java.awt.*;

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener{
    int cnt=0;
    Button bm = new Button("-");
    Label lab = new Label(String.valueOf(cnt));
    Button bp = new Button("+");
    public void init(){
	// Ex01の継承
	super.init();

	//部品クラスの作成
	bm.addActionListener(this);
	bp.addActionListener(this);

	//setLayout(null);

	//アプレット内にGUIの部品を追加

	add(bm);
	add(lab);
	add(bp);

	//部品を指定した位置に
	/*
	bm.setBounds(10,10,50,50);
	bp.setBounds(100,10,50.50);
	lab.setBounds(50,10,50,50);
	*/

    }


    public void actionPerformed(ActionEvent e){
	     Object o = e.getSource();
	      if(o == bm)
	       cnt--;
	      if(o == bp)
	       cnt++;
	     lab.setText(String.valueOf(cnt));
    }
    public void paint(Graphics g){
      super.paint(g);
    }

}
