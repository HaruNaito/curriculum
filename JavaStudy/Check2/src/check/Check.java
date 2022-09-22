package check;

import constants.Constants;

public class Check {

	private static String firstName= "内藤";
	private static String lastName = "遼";

	private static String printName(String firstName, String lastName) {
		return firstName + lastName;
	}

	public static void main(String[] args) {
		
		System.out.println("PrintNameのメソッド→" + printName(firstName, lastName));
		Pet robot = new Pet(Constants.CHECK_CLASS_JAVA, Constants.CHECK_CLASS_HOGE);
		RobotPet robot2 = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
		robot.introduce();
		robot2.introduce();
	}
}

