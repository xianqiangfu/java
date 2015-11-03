package yingyong;

class test {
	public int a = 0;
	public int b = 0;
}

public class yingyongmain {

	public static void testFunc(test t) {
		t.a = 222;
		t.b = 222;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test t = new test();
		System.out.println("t.a = " + t.a);
		System.out.println("t.b = " + t.b);
		t.a = 111;
		t.b = 111;
		System.out.println("t.a = " + t.a);
		System.out.println("t.b = " + t.b);
		testFunc(t);
		System.out.println("t.a = " + t.a);
		System.out.println("t.b = " + t.b);
	}

}
