package classtest1;

public class classtest1 {
	int puppyAge;
	public classtest1(String name)
	{
		System.out.println("Passed Name is : " + name);
	}
	
	public void setAge(int age)
	{
		puppyAge = age;
	}
	
	public int getAge()
	{
		System.out.println("Puppy's age is: " + puppyAge);
		return puppyAge;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		classtest1 c1 = new classtest1("Tom");
		c1.setAge(2);
		c1.getAge();
		System.out.println("Variable Value:" + c1.getAge());
	}

}
