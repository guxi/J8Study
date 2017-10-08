package collect;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
//import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;//导入所有静态方法

import stream.Dish;

public class exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
long i=Dish.menu.stream().collect(counting());
//System.out.println(i);
Comparator<Dish> aa=Comparator.comparingInt(Dish::getCalories);
Optional<Dish> a=Dish.menu.stream().collect(maxBy(aa));

Optional<Dish> b=Dish.menu.stream().
			collect(maxBy(Comparator.
							comparingInt(Dish::getCalories)));

int c=Dish.menu.stream().collect(summingInt(Dish::getCalories));
System.out.println(""+i+a.get()+b.get()+c);
IntSummaryStatistics  MS=Dish.menu.stream().
		collect(summarizingInt(Dish::getCalories)
				);
System.out.println(MS.toString());
	}

}
