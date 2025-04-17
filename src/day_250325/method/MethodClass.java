package day_250325.method;


public class MethodClass {
	public static void main(String[] args) {
//		System.out.println("22");
//		
//		TestClass t1 = new TestClass();
//		t1.m1();
//		t1.m2();
//		
//		TestClass t2 = new TestClass();
//		t2.m1();
		
//		Savebox s1 = new Savebox();
//		Savebox s2 = new Savebox();
//		Savebox s3 = new Savebox();
//		
//		s1.deposit(100);
//		s1.deposit(100);
//		
//		s2.deposit(1000);
//		
//		s3.deposit(50);
//		s3.deposit(50);
//		s3.deposit(50);
//		s3.deposit(50);
//		s3.deposit(50);
//		
//		s1.withdraw(); // 200
//		s2.withdraw(); // 1000
//		s3.withdraw(); // 250
		
		MathClass m = new MathClass();
		int result = m.sumNumbers(0, 100);
		System.out.println("총합 : " + result);
	}
}
