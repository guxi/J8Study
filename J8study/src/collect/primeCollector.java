package collect;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class primeCollector implements Collector<Integer, 
												Map<Boolean,List<Integer>>
												,Map<Boolean,List<Integer>>>
{
	@Override
	public Supplier<Map<Boolean, List<Integer>>> supplier() {
		// TODO Auto-generated method stub
		return () -> new HashMap<Boolean, List<Integer>>(){
			{put(true,new ArrayList<Integer>());
			put(false,new ArrayList<Integer>());
					
			}};
	}

	@Override
	public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
		// TODO Auto-generated method stub
		return (Map<Boolean,List<Integer>> acc,Integer candidate)->{
			acc.get(isPrime(acc.get(true),candidate))
			.add(candidate);
		};
	}

	@Override
	public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
		// TODO Auto-generated method stub
		return (Map<Boolean,List<Integer>> map1,
				 Map<Boolean,List<Integer>> map2) -> {
					 map1.get(true).addAll(map2.get(true));
					 map1.get(false).addAll(map2.get(false));
					 return	map1;
				 };
	}

	@Override
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		// TODO Auto-generated method stub
		return Function.identity();
	}
	
	@Override
	public Set<Characteristics> characteristics() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
	}
public static boolean isPrime(List<Integer> primes, int condidate) {
	int candidateroot=(int)Math.sqrt((double)condidate);
	return IntStream.range(2, candidateroot)
			.noneMatch(i->condidate % i==0);
} 
	

}
