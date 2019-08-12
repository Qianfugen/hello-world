package draw;

public class XiaoMing extends Thread {
	Pencil pencil;
	Rubber rubber;

	@Override
	public void run() {
		synchronized (pencil) {
			System.out.println("小明使用铅笔...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("小明想使用橡皮...");
			try {
				// 先释放铅笔
				pencil.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (rubber) {
				System.out.println("小明开始使用橡皮...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("小明用完橡皮...");
			}
			System.out.println("小明用完铅笔...");
		}
	}

}
