package paradise;
//��ǽ ˯�� ��ǽ ˯�� ��ǽ ��ǽ ˯�� ��ǽ �Ҵ��� �����أ�������
//һ����ǽ��һ��˯��
public class SleepDemo {
	 public static void main(String[] args) {
	  Thread t = new Thread() {
	   public void run() {
	    for (int i = 0; i < 5; i++) {
	     System.out.println("˯��");
	     try {
	      Thread.sleep(10000);
	     } catch (InterruptedException e) {
	      // e.printStackTrace();
	      System.out.println("�����أ�������");
	      break;
	     }
	    }
	   }
	  };
	  t.start();
	  for (int i = 0; i < 5; i++) {
	   System.out.println("��ǽ");
	   try {
	    Thread.sleep(5000);
	   } catch (InterruptedException e) {
	    e.printStackTrace();
	   }
	  }
	  System.out.println("�Ҵ���");
	  t.interrupt();// ����߳�t��sleep
	 }
	}
