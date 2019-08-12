package threadlock;

public class PersonA extends Thread {
	BankCard bc;
	boolean state;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			state = bc.withdraw(200);
			if (state) {
				System.out.println("AȡǮ200Ԫ,ʣ��:" + bc.balance);
			}
		}
	}

}
