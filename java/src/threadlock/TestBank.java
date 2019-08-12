package threadlock;

/**
 * 测试多线程取钱取钱
 * @author root
 *
 */
public class TestBank {
	public static void main(String[] args) {
		BankCard bc = new BankCard();
		PersonA a = new PersonA();
		PersonB b = new PersonB();
		a.bc = bc;
		b.bc = bc;
		a.start();
		b.start();
	}

}
