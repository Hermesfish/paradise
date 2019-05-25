package paradise;

import java.awt.*;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Members3 extends JFrame implements KeyListener{
	int wx,wy;
	int [][] datas={
			{1, 1, 1 ,1 ,1 ,1, 1, 1, 1 ,1 ,1, 1},
			{0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0, 0, 1},
			{1 ,0 ,1 ,1, 0, 1, 1, 1 ,1, 1, 0, 1},
			{1 ,0 ,0 ,1, 0, 1, 0, 0, 0, 0, 0 ,1},
			{1, 1, 1 ,1 ,0 ,1 ,0, 1 ,1 ,1 ,1 ,1},
			{1 ,0, 0, 0, 0, 1, 0 ,0, 0, 0 ,0, 1},
			{1 ,0, 1 ,1 ,1 ,1, 1, 1, 1, 1, 0, 1},
			{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1 ,0, 1 ,0 ,1 ,1, 1 ,1, 1, 1, 0, 1},
			{1 ,0 ,1, 0, 0 ,1 ,0 ,1, 0, 1 ,0, 1},
			{1, 0, 1 ,1, 1, 1, 0 ,0 ,0 ,1, 1, 1},
			{1 ,0 ,0 ,0, 0 ,0, 0, 1 ,0, 0, 0, 0},
			{1 ,1, 1, 1 ,1, 1, 1, 1, 1 ,1 ,1 ,1},
	};
	public Members3(){
		treeInit();
		mushroomInit();
		backGroundInit();
		framemain();
		this.addKeyListener(this);
	}
	private void framemain(){
		 this.setTitle("�߳��Թ�V1.01"); 
		 this.setSize(700,700);
		 this.setResizable(false);//���ɸı䴰���С
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		 this.setLocationRelativeTo(null);
		 this.setVisible(true);
	}
	private void backGroundInit(){
		Icon i =new ImageIcon("pic/floor.png");
		JLabel lab_bg=new JLabel(i);	
		lab_bg.setBounds(0,0,600,650);
		this.add(lab_bg);
		setLayout(null);
	}//Ĭ�Ͼ����ˣ�ʲô������setLayout(null)����
	private void mushroomInit(){
		wx=0;
		wy=1;
		Icon i=new ImageIcon("pic/wolf-front.png");
		lab_w=new JLabel(i);
		lab_w.setBounds(wx*50, wy*50, 50, 50);
		this.add(lab_w);
	}
	JLabel lab_w;
	private void treeInit(){
		Icon k=new ImageIcon("pic/tree.png");
		JLabel t =null;
		for (int i=0;i<datas.length;i++){
			for (int j=0;j<datas[i].length;j++){
				if (datas[i][j]==1){
					t=new JLabel(k);
					t.setBounds(j*50,i*50,50,50);
					this.add(t);
				}
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e){
		
	}
	@Override
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		  if(key==37){
			  if(datas[wy][wx-1]==0){
			  wx-=1;
				 int x =(int)lab_w.getLocation().getX();
				 int y =(int)lab_w.getLocation().getY();
				 lab_w.setLocation(x-50,y);
				 Icon i=new ImageIcon("pic/wolf-left.png");
				 lab_w.setIcon(i);
			  }
			  if(datas[wy][wx-1]==1){
				  return;
			  }
		}
		  if(key==38){
			  if(datas[wy-1][wx]==0){
			  wy-=1;
				 int x =(int)lab_w.getLocation().getX();
				 int y =(int)lab_w.getLocation().getY();
				 lab_w.setLocation(x,y-50);
				 Icon i=new ImageIcon("pic/wolf-back.png");
				 lab_w.setIcon(i);	
			  }
			  if(datas[wy-1][wx]==1){
				  return;
			  }
	    }
		  if(key==39){
			  if(datas[wy][wx+1]==0){
		       wx+=1;
		        int x =(int)lab_w.getLocation().getX();
		        int y =(int)lab_w.getLocation().getY();
		        lab_w.setLocation(x+50,y);
		        Icon i=new ImageIcon("pic/wolf-right.png");
		        lab_w.setIcon(i);
			  }
			  if(datas[wy][wx-1]==1){
				  return;
			  }
		}
		  if(key==40){
			  if(datas[wy+1][wx]==0){
			  wy+=1;
				 int x =(int)lab_w.getLocation().getX();
				 int y =(int)lab_w.getLocation().getY();
				 lab_w.setLocation(x,y+50);
				 Icon i=new ImageIcon("pic/wolf-front.png");
				 lab_w.setIcon(i);	
			  }
			  if(datas[wy+1][wx]==1){
				  return;
			  }
	    }
		//else����û�� 
		//��β�Խ�� 
	}
	@Override 
	public void keyReleased(KeyEvent e){
		
	}
	public static void main(String[] args){
		  new Members3();
	}
}
//�������в����Ǽ��д��룡����
