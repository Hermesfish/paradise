package paradise;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Members2 extends JFrame {
	int mx,my;
	int mi=0,mj=0;
	JButton btnstart;
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
	int [][] remembers={
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0},
		    {0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0},
	};
	public Members2(){
		treeInit();
		mushroomInit();
		backGroundInit();
		mybutton();
		framemain();
		btnstart.addActionListener(bl);
	}
	private void framemain(){
		 this.setTitle("�߳��Թ�V1.01"); 
		 this.setSize(700,700);
		 this.setResizable(false);//���ɸı䴰���С
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		 this.setLocationRelativeTo(null);
		 this.setVisible(true);
	}
	private void mybutton(){
		btnstart=new JButton("��ʼ");
		btnstart.setBounds(600, 250, 100,200);
		this.add(btnstart);
		setLayout(null);
	}//��ť����ʾ��̫С�ˣ�û������
	private void backGroundInit(){
		Icon i =new ImageIcon("pic/floor.png");
		JLabel lab_bg=new JLabel(i);	
		lab_bg.setBounds(0,0,600,650);
		this.add(lab_bg);
		setLayout(null);
	}//Ĭ�Ͼ����ˣ�ʲô������setLayout(null)����
	
	private void mushroomInit(){
		mx=0;
		my=1;
		Icon i=new ImageIcon("pic/mushroom.png");
		lab_m=new JLabel(i);
		lab_m.setBounds(mx*50, my*50, 50, 50);
		this.add(lab_m);
	}
	JLabel lab_m;
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
	private void remember(){
		mi=mx;
		mj=my;
		remembers[mj][mi]=1;
	}//remember�����þ��Ǽ�ס��һ����
	private void up(){
		
			remember();
		    my-=1;
		    int x =(int)lab_m.getLocation().getX();
		    int y =(int)lab_m.getLocation().getY();
		    lab_m.setLocation(x,y-50);
		    Icon i=new ImageIcon("pic/mushroom.png");
		    lab_m.setIcon(i);
		
		  
	}
	private void down(){
		
			remember();
		    my+=1;
		    int x =(int)lab_m.getLocation().getX();
		    int y =(int)lab_m.getLocation().getY();
		    lab_m.setLocation(x,y+50);
		    Icon i=new ImageIcon("pic/mushroom.png");
		    lab_m.setIcon(i);
		
		    
	}
	private void left(){
		
			remember();
		    mx-=1;
		    int x =(int)lab_m.getLocation().getX();
		    int y =(int)lab_m.getLocation().getY();
		    lab_m.setLocation(x-50,y);
		    Icon i=new ImageIcon("pic/mushroom.png");
		    lab_m.setIcon(i);
		
	}
	private void right(){
		
			remember();
		    mx+=1;
		    int x =(int)lab_m.getLocation().getX();
		    int y =(int)lab_m.getLocation().getY();
		    lab_m.setLocation(x+50,y);
		    Icon i=new ImageIcon("pic/mushroom.png");
		    lab_m.setIcon(i);
			
		 
		   
	}
	private void byleftmove(){
		//4����·��������
		if(datas[my][mx+1]==1&&datas[my][mx-1]==1
				&&datas[my+1][mx]==1&&datas[my-1][mx]==0){
			up();
		}
		if(datas[my][mx+1]==1&&datas[my][mx-1]==1
				&&datas[my-1][mx]==1&&datas[my+1][mx]==0){
			down();
		}
		if(datas[my+1][mx]==1&&datas[my-1][mx]==1
				&&datas[my][mx+1]==1&&datas[my][mx-1]==0){
			left();
		}
		if(datas[my+1][mx]==1&&datas[my-1][mx]==1
				&&datas[my][mx-1]==1&&datas[my][mx+1]==0){
			right();
		}
		
		//12��һ·�����ġ�
		//����д����upΪ�ϰ���3�������ע��Ҫ�Ѵ�����д����㡣
		if(remembers[mj][mi]==1&&datas[my][mx+1]==0&&
				datas[my-1][mx]==1&&datas[my+1][mx]==0){
			right();
		}//��������
		if(remembers[mj][mi]==1&&datas[my][mx-1]==0&&
				datas[my-1][mx]==1&&datas[my+1][mx]==0){
			down();
		}//��������
		if(remembers[mj][mi]==1&&datas[my][mx+1]==0&&
				datas[my-1][mx]==1&&datas[my][mx-1]==0){
			left();
		}//��������
		
		//����д��downΪ�ϰ���3�������
		if(datas[my+1][mx]==1&&datas[my-1][mx]==0&&
				datas[my][mx+1]==0&&remembers[mj][mi]==1){
			up();
		}//��������
		if(datas[my+1][mx]==1&&datas[my-1][mx]==0&&
				datas[my][mx-1]==0&&remembers[mj][mi]==1){
			left();
		}//��������
		if(datas[my+1][mx]==1&&datas[my][mx+1]==0&&
				datas[my][mx-1]==0&&remembers[mj][mi]==1){
			right();
		}//��������
		
		//����д����leftΪ�ϰ���3�����
		if(datas[my][mx-1]==1&&datas[my][mx+1]==0&&
				datas[my+1][mx]==0&&remembers[mj][mi]==1){
			right();
		}//��������
		if(datas[my][mx-1]==1&&datas[my][mx+1]==0&&
				datas[my-1][mx]==0&&remembers[mj][mi]==1){
			up();
		}//��������
		if(datas[my][mx-1]==1&&datas[my-1][mx]==0&&
				datas[my+1][mx]==0&&remembers[mj][mi]==1){
			down();
		}//��������
		
		//����д��rightΪ�ϰ���3�������
		if(datas[my][mx+1]==1&&datas[my][mx-1]==0&&
				datas[my+1][mx]==0&&remembers[mj][mi]==1){
			down();
		}//��������
		if(datas[my][mx+1]==1&&datas[my][mx-1]==0&&
				datas[my-1][mx]==0&&remembers[mj][mi]==1){
			left();
		}//��������
		if(datas[my][mx+1]==1&&datas[my-1][mx]==0&&
				datas[my+1][mx]==0&&remembers[mj][mi]==1){
			up();
		}//��������
		
		//12����·������
		//������1��2λ��Ϊ�ϰ������������
		if(datas[my][mx-1]==1&&datas[my-1][mx]==1&&
				datas[my+1][mx]==0&&remembers[mj][mi]==1){
			down();
		}//��������
		if(datas[my][mx-1]==1&&datas[my-1][mx]==1&&
				datas[my][mx+1]==0&&remembers[mj][mi]==1){
			right();
		}
		
		//������1��3λ��Ϊ�ϰ��ģ��������
		if(datas[my][mx-1]==1&&datas[my][mx+1]==1&&
				datas[my+1][mx]==0&&remembers[mj][mi]==1){
			down();
		}//��������
		if(datas[my][mx-1]==1&&datas[my][mx+1]==1&&
				datas[my-1][mx]==0&&remembers[mj][mi]==1){
			up();
		}//��������
		
		//������1��4λ�õģ��������
		if(datas[my][mx-1]==1&&datas[my+1][mx]==1&&
				datas[my][mx+1]==0&&remembers[mj][mi]==1){
			right();
		}//��������
		if(datas[my][mx-1]==1&&datas[my+1][mx]==1&&
				datas[my-1][mx]==0&&remembers[mj][mi]==1){
			up();
		}//��������
		
		//����2��3λ��Ϊ�ϰ������������
		if(datas[my-1][mx]==1&&datas[my][mx+1]==1&&
				datas[my+1][mx]==0&&remembers[mj][mi]==1){
			down();
		}//��������
		if(datas[my-1][mx]==1&&datas[my][mx+1]==1&&
				datas[my][mx-1]==0&&remembers[mj][mi]==1){
			left();
		}//��������
		
		//����2��4λ��Ϊ�ϰ������������
		if(datas[my+1][mx]==1&&datas[my-1][mx]==1&&
				datas[my][mx+1]==0&&remembers[mj][mi]==1){
			right();
		}//��������
		if(datas[my+1][mx]==1&&datas[my-1][mx]==1&&
				datas[my][mx-1]==0&&remembers[mj][mi]==1){
			left();
		}//��������
		
		//�������3��4��λ��Ϊ�ϰ������������
		if(datas[my][mx+1]==1&&datas[my+1][mx]==1&&
				datas[my-1][mx]==0&&remembers[mj][mi]==1){
			up();
		}//��������
		if(datas[my][mx+1]==1&&datas[my+1][mx]==1&&
				datas[my][mx-1]==0&&remembers[mj][mi]==1){
			left();
		}//��������
	}
	class ButtonListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		right();
		do{
		byleftmove();
		}
		while(my!=1||mx!=10);
	   }	
	}
	private ButtonListener bl=new ButtonListener();
	public static void main(String[] args){
		  new Members2();
	}
}
