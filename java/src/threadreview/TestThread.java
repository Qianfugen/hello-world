package threadreview;

public class TestThread {
	public static void main(String[] args) {
		// ˯��,����һ��˯�߸�����ʱ��,��һ��ƫ��,��ϵͳ��ʱ����OS��������׼ȷ�Ⱥ;��ȹ�
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ��ȡ�߳���
		System.out.println(Thread.currentThread().getName());
		// ��ȡ�߳�״̬
		System.out.println(Thread.currentThread().getState());
		// �߳��Ƿ���
		System.out.println(Thread.currentThread().isAlive());
		// �ó�CPU
		Thread.currentThread().yield();
	}
}
