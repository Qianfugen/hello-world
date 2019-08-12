package threadlock2;

/**
 * È¡Ç®·½·¨
 * 
 * @author root
 *
 */

public class BankCard {
	int balance = 2000;

	public boolean withdraw(int money) {
		synchronized (this) {
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
}
