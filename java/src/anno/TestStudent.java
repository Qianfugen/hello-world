package anno;

public class TestStudent {

	public static void main(String[] args) {
		Student stu = new Student();
		//ÉèÖÃÄêÁä(5-80)
		stu.setAge(100);
		stu.setId(1);
		stu.setName("pipixia");
		try {
			ValidateUtil.init(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
