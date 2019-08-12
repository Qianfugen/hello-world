package thread2;

/**
 * ¹éÍ¾ÈüÅÜ
 * @author root
 *
 */
public class TestRace {

	public static void main(String[] args) {
		Thread turtle = new Thread(new MyRunnable());
		Thread rabbit = new Thread(new MyRunnable());

		turtle.setName("½ÜÄá¹ê");
		rabbit.setName("Á÷Ã¥ÍÃ");

		turtle.start();
		rabbit.start();

	}

}
