package generics;

public class genDemo {

	public static <T> void main(String[] args) {
		gen<Integer> iOb=new gen<Integer>(88);		
		//int i=iOb.getob();
		System.out.println(iOb.toString());
		gen2<gen<Integer>> g=new gen2<gen<Integer>>(iOb);
		g.g(iOb);
		///g.g(99);

	}
}
