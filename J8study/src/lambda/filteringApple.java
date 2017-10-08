package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
/**
 * 
 * @author yy
 *
 */

public class filteringApple {
	
	public static void main(String[] args) {
		List<apple> redApple=filter(
				apple.menu,
				(apple a)->"red".equals(a.getColor())  //Predicate<T> p
			);	
		
		
		for(apple a:redApple) {
			System.out.println(a);
		}
		redApple.forEach(aa->System.out.println(aa));//表达式
		redApple.forEach(System.out::println);  //方法应用
		System.out.println(redApple);   
		
		//List<String> app=apple.menu.stream().filter(d->d.getWeight()<130).collect(toList());
	}
	
	//XXX filter color 
	public static <T> List<T> filter(List<T> list , Predicate<T> p){
		List<T> result = new ArrayList<>();
		for(T e:list) {
			if(p.test(e)) result.add(e);
		}
		return result;	
	}
	
	//XXX sort
	
	public static <T> List<T> sort(List<T> list){
		List<T> result = new ArrayList<>();
		return result;	
	}

}
