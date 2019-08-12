package anno;

import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("all")
public class ValidateUtil {
	public static boolean init(Object obj) throws Exception {
		Class objClass = obj.getClass();
		// �����ȡ����
		Field[] fs = objClass.getDeclaredFields();
		for (Field f : fs) {
			if (f.getAnnotation(Validate.class) != null) {
				// ����get������
				String ageMethod = "get" + (f.getName().charAt(0) + "").toUpperCase() + f.getName().substring(1);
				// �����ȡ����
				Method getAgeMethod = objClass.getMethod(ageMethod, null);
				int age = (int) getAgeMethod.invoke(obj, null);
				Validate vd = f.getAnnotation(Validate.class);
				if (age < vd.min()) {
					System.out.print("����С��");
					return false;
				} else if (age > vd.max()) {
					System.out.println("�������");
					return false;
				} else {
					System.out.println("�������");
				}
			}
		}
		return true;
	}
}
