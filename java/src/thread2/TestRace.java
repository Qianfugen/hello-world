package thread2;

/**
 * ��;����
 * @author root
 *
 */
public class TestRace {

	public static void main(String[] args) {
		Thread turtle = new Thread(new MyRunnable());
		Thread rabbit = new Thread(new MyRunnable());

		turtle.setName("�����");
		rabbit.setName("��å��");

		turtle.start();
		rabbit.start();

	}

}
