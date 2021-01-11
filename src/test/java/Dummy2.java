
public class Dummy2{
	 public static String name(Object a) {
		
		 System.out.println(a);
		 
		 return a.getClass().getSimpleName();

		
	}

	 public static void main(String[] args) {
		
		// Dummy2 d = new Dummy2();
		 
		 System.out.println(name(10.01));
		
			}

}
