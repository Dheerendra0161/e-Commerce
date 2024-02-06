package eCom.Utils;


	import java.util.Random;

	public class TestData_Generation {

		static Random random;

		public static String Email_ID_TestData(String prefix) {

			random = new Random();
			String email = prefix + random.nextInt(10000) + "@gmail.com";
			return email;
		}

		public static String UniqueName(String Name) {

			random = new Random();
			String UserName = Name + random.nextInt(1000) + "Kumar";
			return UserName;
		}
		
		public static String UniqueMobiled(String PreMobile) {

			random = new Random();
			String Password = PreMobile + random.nextInt(10000) + 8561;
			return Password;
		}

		public static String UniquePassWord(String Password) {

			random = new Random();
			String UserName = Password + random.nextInt(10000) + "8561";
			return UserName;
		}

		
		
		public static void main(String[] args) {
			System.out.println(TestData_Generation.Email_ID_TestData("Dheerendra"));
			System.out.println(TestData_Generation.UniqueName("Vivek"));
		}


	}


