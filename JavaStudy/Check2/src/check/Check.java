package check;

public class Check {
	public static void chek(String[]args){}
	class name {
		private String firstName;
		private  String lastName;
		
		public class Main {
		    public static void main(String[] args) {
		    	int  firstName = "内藤";
		    	int lastName = "遼";
		    	int ans = printName(firstName, lastName);
		        System.out.println("PrintNameのメソッド→" + ans );
		    }
		    
		    public static int printName(int firstName, int lastName) {
		        return firstName + lastName;
		    }
		}
		class PetTester {
			public static void main(String[]args){
				Pet robot = new Pet("Constants.CHECK_CLASS_JAVA", "Constants.CHECK_CLASS_HOGE");
				RobotPet robot2 = new RobotPet("Cconstants.HECK_CLASS_R2D2", "Constants.CHECK_CLASS_LUKE");
				robot.introduce();
				robot2.introduce();
				System.out.println();
			}
		}}}



//package test6;
////public class Local {
    
// private int value=0;

//    private int value2=10;
 

//    public void Method(){

//        int num = 5;

//        System.out.println(value);