package generics;

public class gen<T> {
	T ob;
	gen(T o){
		ob=o;
	}
	T getob() {
		return ob;
	}
	
	@Override
	public String toString() {
		return "Type T is "+ob.getClass().getName()+";ob Value is "+ob;
	}
	

}
