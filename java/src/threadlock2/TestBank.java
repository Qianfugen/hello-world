package threadlock2;

/**
 * ���Զ��߳�ȡǮȡǮ
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
