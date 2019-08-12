package threadlock;

/**
 * 取钱方法
 * 
 * @author 钱富根
 * @version 1.0 2019-08-13
 */
public class BankCard {
	int balance = 2000;

	public synchronized boolean withdraw(int money) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (balance >= 200) {
			balance -= money;
			return true;
		} else {
			return false;
		}
	}
}
