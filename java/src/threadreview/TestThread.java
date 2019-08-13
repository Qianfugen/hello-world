package threadreview;

public class TestThread {
	public static void main(String[] args) {
		// 睡眠,但不一定睡眠给定的时间,有一定偏差,与系统定时器和OS调度器有准确度和精度关
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取线程名
		System.out.println(Thread.currentThread().getName());
		// 获取线程状态
		System.out.println(Thread.currentThread().getState());
		// 线程是否存活
		System.out.println(Thread.currentThread().isAlive());
		// 让出CPU
		Thread.currentThread().yield();
	}
}
