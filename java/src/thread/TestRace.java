package thread;

/**
 * ¹êÍÃÈüÅÜ
 * @author root
 *
 */
public class TestRace {
	public static void main(String[] args) {
		
		TurtleThread turtle=new TurtleThread();
		RabbitThread rabbit=new RabbitThread();
		
		turtle.start();
		rabbit.start();
	}
	
	
}
