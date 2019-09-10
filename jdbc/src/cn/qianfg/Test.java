package cn.qianfg;

/**
 * 主方法
 */
import cn.qianfg.menu.Menu;

public class Test {
    public static void main(String[] args) {
        Menu menu = new Menu();
        while (true) {
            menu.mainMenu();
        }
    }
}
