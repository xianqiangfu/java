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
        printArray( intArray  ); // ����һ����������

        System.out.println( "\nArray doubleArray contains:" );
        printArray( doubleArray ); // ����һ��˫����������

        System.out.println( "\nArray characterArray contains:" );
        printArray( charArray ); // ����һ���ַ���������
	}

}
