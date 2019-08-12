package draw;

public class TestDraw {

	public static void main(String[] args) {
		Pencil pencil = new Pencil();
		Rubber rubber = new Rubber();
		XiaoMing xm = new XiaoMing();
		XiaoHong xh = new XiaoHong();
		xm.pencil = pencil;
		xm.rubber = rubber;
		xh.pencil = pencil;
		xh.rubber = rubber;
		xm.start();
		xh.start();

	}

}
