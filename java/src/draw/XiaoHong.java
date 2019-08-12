package draw;

public class XiaoHong extends Thread {
	Pencil pencil;
	Rubber rubber;

	@Override
	public void run() {
		synchronized (rubber) {
			System.out.println("С��ʹ����Ƥ...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("С����ʹ��Ǧ��...");
			synchronized (pencil) {
				System.out.println("С�쿪ʼʹ��Ǧ��...");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("С������Ǧ��...");
				// �ͷ�Ǧ��
				pencil.notifyAll();
			}
			System.out.println("С��������Ƥ...");

		}
	}

}
