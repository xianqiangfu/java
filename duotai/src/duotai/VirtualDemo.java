package duotai;

public class VirtualDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
		Employee e = new Salary("John", "Boston,MA", 2, 2400.0);
		System.out.println("Call mailCheck using Salary reference --");
		s.mailCheck();
		System.out.println("\n Call mailCheck using Employee reference--");
		e.mailCheck();
	}

}
