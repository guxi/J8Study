package collect;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.partitioningBy;
/**
 * 取质数
 * map分区 ，取值true
 * 
 * @param args
 */
public class isPrime1 {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		isPrime1 p=new isPrime1();
		//p.partitionPrime(70).values();
		
		System.out.println(p.partitionPrime(70).get(true));
		System.out.println(IntStream.rangeClosed(2, 70).boxed().collect(new primeCollector()).get(true));
		
	}
	public boolean isPrime(int candidate)
	{
		int candidateroot=(int)Math.sqrt((double)candidate);
		return IntStream.range(2, candidateroot)
				.noneMatch(i->candidate % i==0);
		
	}
	public Map<Boolean,List<Integer>> partitionPrime(int n){
		return IntStream.rangeClosed(2,n).boxed().collect(
				partitioningBy(candidate->isPrime(candidate)));
	}

}
