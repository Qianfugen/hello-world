package draw;

public class XiaoMing extends Thread {
	Pencil pencil;
	Rubber rubber;

	@Override
	public void run() {
		synchronized (pencil) {
			System.out.println("С��ʹ��Ǧ��...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("С����ʹ����Ƥ...");
			try {
				// ���ͷ�Ǧ��
				pencil.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (rubber) {
				System.out.println("С����ʼʹ����Ƥ...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("С��������Ƥ...");
			}
			System.out.println("С������Ǧ��...");
		}
	}

}
