package threadlock;

public class PersonB extends Thread {
	BankCard bc;
	boolean state;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			state = bc.withdraw(200);
			if (state) {
				System.out.println("BȡǮ200Ԫ,ʣ��:" + bc.balance);
			}
		}
	}

}
