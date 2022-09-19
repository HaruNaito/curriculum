package check;

public class Check {
	public static void main(String[]args){}
	class printName {
		private String firstName;
		private  String lastName;

		public printName(String firstName, String lastName) {
			this.firstName = "内藤";
			this.lastName = "遼";

			System.out.println("PrintNameのメソッド→" + firstName + lastName);

		}
		class PetTester {
			public static void main(String[]args){
				Pet robot = new Pet("CHECK_CLASS_JAVA", "CHECK_CLASS_HOGE");
				RobotPet robot2 = new RobotPet("CHECK_CLASS_R2D2", "CHECK_CLASS_LUKE");
				robot.introduce();
				robot2.introduce();
				System.out.println();
			}
		}
	}
}