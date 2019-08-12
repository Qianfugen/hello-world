package draw;

public class XiaoHong extends Thread {
	Pencil pencil;
	Rubber rubber;

	@Override
	public void run() {
		synchronized (rubber) {
			System.out.println("小红使用橡皮...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("小红想使用铅笔...");
			synchronized (pencil) {
				System.out.println("小红开始使用铅笔...");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("小红用完铅笔...");
				// 释放铅笔
				pencil.notifyAll();
			}
			System.out.println("小红用完橡皮...");

		}
	}

}
