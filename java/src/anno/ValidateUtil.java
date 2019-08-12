package anno;

import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("all")
public class ValidateUtil {
	public static boolean init(Object obj) throws Exception {
		Class objClass = obj.getClass();
		// 反射获取属性
		Field[] fs = objClass.getDeclaredFields();
		for (Field f : fs) {
			if (f.getAnnotation(Validate.class) != null) {
				// 构造get方法名
				String ageMethod = "get" + (f.getName().charAt(0) + "").toUpperCase() + f.getName().substring(1);
				// 反射获取方法
				Method getAgeMethod = objClass.getMethod(ageMethod, null);
				int age = (int) getAgeMethod.invoke(obj, null);
				Validate vd = f.getAnnotation(Validate.class);
				if (age < vd.min()) {
					System.out.print("年龄小了");
					return false;
				} else if (age > vd.max()) {
					System.out.println("年龄大了");
					return false;
				} else {
					System.out.println("年龄合适");
				}
			}
		}
		return true;
	}
}
