package generics;

public class main {
	public static <E> void printArray(E[] inputArray)
	{
		for (E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArray = { 1, 2, 3, 4, 5};
		Double[]  doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
		
		System.out.println( "Array integerArray contains:" );
        printArray( intArray  ); // 传递一个整型数组

        System.out.println( "\nArray doubleArray contains:" );
        printArray( doubleArray ); // 传递一个双精度型数组

        System.out.println( "\nArray characterArray contains:" );
        printArray( charArray ); // 传递一个字符型型数组
	}

}
