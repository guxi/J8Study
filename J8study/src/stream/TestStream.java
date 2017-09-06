package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStream {

	public static void main(String[] args) {
		List<String> strs=Arrays.asList("asdf","afgjh","jdfgh");
		Optional<String> i = strs.stream().
				//map(w->w.split("")).
				//flatMap(Arrays::stream).
				//distinct().
				//map(String::length).
				//anyMatch(d->d.equals("asdf")).
				findFirst();
				//forEach(System.out::println);
				//reduce(0,(a,b)->a+b);
		System.out.println(i);
		
		

	}

}
