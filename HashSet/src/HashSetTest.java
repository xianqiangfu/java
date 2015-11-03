import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet hashset = new HashSet();
		String a = new String("A");
		String b = new String("B");
		String c = new String("C");
		
		hashset.add(a);
		hashset.add(b);
		hashset.add(c);
		System.out.println(hashset.size());
		
		String cz = hashset.add(c) ? "�˶��󲻴���":"�Ѿ�����";
		System.out.println("�����Ƿ������Ӷ���: "+ cz);
		
		System.out.println(hashset.isEmpty());
		System.out.println(hashset.contains("A"));
		
		Iterator ir = hashset.iterator();
		while (ir.hasNext())
		{
			System.out.println(ir.next());
		}
		
		System.out.println(hashset.remove("a"));
		System.out.println(hashset.remove("A"));
		
		ir = hashset.iterator();
		
		while(ir.hasNext())
		{
			System.out.println(ir.next());
		}
	}

}
