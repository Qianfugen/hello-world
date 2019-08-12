package thread3;

public class TestRace {

	public static void main(String[] args) {
		TurtleThread turtle = new TurtleThread();
		RabbitThread rabbit = new RabbitThread();
		rabbit.turtle = turtle;
		rabbit.start();
		turtle.start();
	}

}
