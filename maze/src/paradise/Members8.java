package paradise;

import java.awt.*;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Members8 extends JFrame implements ActionListener,Runnable{
	
	int mx,my;
	int mi=0,mj=0;
	JButton btnstart;
	int count=1;
	int [][] datas={
			{1, 1, 1 ,1 ,1 ,1, 1, 1, 1 ,1 ,1, 1},
			{0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0, 0, 1},
			{1 ,0 ,1 ,1, 0, 1, 1, 1 ,1, 1, 0, 1},
			{1 ,0 ,0 ,1, 0, 1, 0, 0, 0, 0, 0 ,1},
			{1, 1, 1 ,1 ,0 ,1 ,0, 1 ,1 ,1 ,1 ,1},
			{1 ,0, 0, 0, 0, 1, 0 ,0, 0, 0 ,0, 1},
			{1 ,0, 1 ,1 ,1 ,1, 0, 1, 1, 1, 0, 1},
			{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1 ,0, 1 ,0 ,1 ,1, 1 ,1, 1, 1, 0, 1},
			{1 ,0 ,1, 0, 0 ,1 ,0 ,1, 0, 1 ,0, 1},
			{1, 0, 1 ,0, 1, 1, 0 ,0 ,0 ,0, 1, 1},
			{1 ,0 ,0 ,0, 0 ,0, 0, 1 ,1, 0, 0, 0},
			{1 ,1, 1, 1 ,1, 1, 1, 1, 1 ,1 ,1 ,1},
	};
	
	int [][] route = new int [2][100];
/*
	int [][] remembers={
			{0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
			{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0 ,0 ,0 ,0},
			{0 ,0, 0, 0 ,0 ,0 ,0 ,0, 0 ,0 ,0 ,0},
			{0, 0, 0 ,0, 0, 0, 0, 0 ,0 ,0 ,0 ,0},
			{0 ,0 ,0, 0 ,0 ,0 ,0 ,0 ,0 ,0, 0, 0},
		    {0, 0, 0, 0 ,0, 0, 0 ,0 ,0 ,0, 0 ,0},
			{0, 0 ,0, 0, 0, 0 ,0 ,0, 0 ,0, 0 ,0},
			{0, 0, 0, 0 ,0, 0 ,0, 0 ,0 ,0 ,0 ,0},
			{0 ,0 ,0, 0, 0, 0 ,0 ,0 ,0, 0, 0, 0},
			{0, 0, 0 ,0 ,0, 0 ,0 ,0 ,0 ,0, 0 ,0},
			{0, 0 ,0 ,0, 0 ,0 ,0, 0 ,0 ,0 ,0 ,0},
			{0, 0 ,0 ,0 ,0, 0, 0 ,0 ,0 ,0 ,0 ,0},
			{0, 0 ,0 ,0 ,0, 0, 0, 0 ,0 ,0 ,0, 0},
	};
*/
	public Members8(){
		Thread t=new Thread();
		t.start();
		treeInit();
		mushroomInit();
		backGroundInit();
		mybutton();
		framemain();
		btnstart.addActionListener(this);
	}
	public void run(){
		
		route[0][0] = 0;
		route[1][0] = 1;
		dfsMaze(1, 0, datas);
		/*
			try{
				Thread.sleep(300);
				// byleftmove();
				dfsMaze(1, 0, datas);
			}catch (InterruptedException e) {
			    e.printStackTrace();
			   }
		*/
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
		Icon i=new ImageIcon("pic/wolf-front.png");
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
/*
	private void remember(){
		mi=mx;
		mj=my;
		remembers[mj][mi]=1;
	}//remember�����þ��Ǽ�ס��һ����
*/
	
	private void victory(){
		for(int k = 0; k+1 < count; k++) {
			// System.out.println("(" + route[0][k+1] + "," + route[1][k+1] + ")" + "-");
			try{
				Thread.sleep(300);
				int locate_x =(int)lab_m.getLocation().getX();
			    int locate_y =(int)lab_m.getLocation().getY();
			    if(route[0][k]==route[0][k+1]) {
			    	if(route[1][k]==route[1][k+1]+1) {
			    		lab_m.setLocation(locate_x-50,locate_y);
			    		Icon i=new ImageIcon("pic/wolf-left.png");
			    		lab_m.setIcon(i);
			    	}
			    	else if(route[1][k]==route[1][k+1]-1) {
			    		lab_m.setLocation(locate_x+50,locate_y);
			    		Icon i=new ImageIcon("pic/wolf-right.png");
			    		lab_m.setIcon(i);
			    	}
			    }
			    if(route[1][k]==route[1][k+1]) {
			    	if(route[0][k]==route[0][k+1]+1) {
			    		lab_m.setLocation(locate_x,locate_y-50);
			    		Icon i=new ImageIcon("pic/wolf-back.png");
			    		lab_m.setIcon(i);
			    	}
			    	else if(route[0][k]==route[0][k+1]-1) {
			    		lab_m.setLocation(locate_x,locate_y+50);
			    		Icon i=new ImageIcon("pic/wolf-front.png");
			    		lab_m.setIcon(i);
			    	}
			    }
		
			}catch (InterruptedException e) {
			    e.printStackTrace();
			   }
		}
		
		Icon i=new ImageIcon("pic/wolf.png");
		JOptionPane.showMessageDialog(null,"��Ϸ����","�߳��Թ�",2,i);
	}
	
	private void dfsMaze(int x, int y, int[][] maze) {
        /*
         * ��þ���Ĵ�С
         * */
        int m=maze.length;
        int n=maze[0].length;
        //���ý�������
        if (x < 0 || y < 0)
            return;
        // �������Խ�磬���� maze[x][y]==1 ��ʾ�����ϰ�
        if (x > m - 1 || y > n - 1 || maze[x][y] ==1)
            return;
        //��ʾ�����ϰ�
        if (maze[x][y] == 1)
            return; // �ж��Ƿ�ͨ·��Խ��
        
        maze[x][y] = 1; // ���߹���·���
        route[0][count] = x;
        route[1][count] = y;
        count++;
        
        if (x == 11 && y == 11) { // �ж��Ƿ�ִ����
            victory();
            return;
        }
        //System.out.println("(" + x + "," + y + ")" + "-");
/*
        try{
			Thread.sleep(300);
			int locate_x =(int)lab_m.getLocation().getX();
		    int locate_y =(int)lab_m.getLocation().getY();
		    lab_m.setLocation(locate_x,locate_y);
		    Icon i=new ImageIcon("pic/wolf-back.png");
		    lab_m.setIcon(i);
		}catch (InterruptedException e) {
		    e.printStackTrace();
		   }
*/
        // ���ĸ���������
        	dfsMaze(x + 1, y, maze);  //��������
        
			dfsMaze(x, y + 1, maze);  //��������
		
			dfsMaze(x, y - 1, maze);  //��������
        
			dfsMaze(x - 1, y, maze);  //��������
        // ��·�ߺͱ�ǻָ�����һ�ε�״̬
        maze[x][y] = 0;
        //���
        count--;
    }

	
	public void actionPerformed(ActionEvent e){
		
		
		new Thread(this).start();
    }	
	
	
	public static void main(String[] args){
		new Members8();
	}
}

