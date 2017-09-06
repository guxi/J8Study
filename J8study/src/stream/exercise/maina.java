package stream.exercise;

//import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//import java.util.Optional;
/**
 * p98
 * @author yy
 *
 */
public class maina {

	public static void main(String ...args) {
		// TODO Auto-generated method stub
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), 
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950));

		// 1
		//List<Transaction> ans1 = 
				transactions.stream()
				.filter(a -> a.getYear() == 2011)	
				.sorted(Comparator.comparing(Transaction::getValue).reversed())	
				.forEach(System.out::println);
				//.collect(toList());
//		for (Transaction a : ans1)
//			System.out.println(a.toString());
		
		//2
		List<Trader> traders=new ArrayList<Trader>();
		traders.add(raoul);
		traders.add(mario);
		traders.add(alan);
		traders.add(brian);		
		 traders.stream()
				.map(Trader::getCity)				
				.distinct()
				.forEach(System.out::println);

				transactions.stream()
				.map(t->t.getTrader().getCity())			
				.distinct()
				.forEach(System.out::println);

		//3
				transactions.stream()
				.filter(a->a.getTrader().getCity()=="Cambridge")
				.map(t->t.getTrader())
				.distinct()
				.sorted(Comparator.comparing(Trader::getName))
				.forEach(System.out::println);
		//4
				transactions.stream()
				.map(t->t.getTrader().getName())
				.map(w->w.split(""))    //转化为数组
				.flatMap(Arrays::stream)//扁平化为单个流
				.distinct()
				.sorted()			
				.forEach(System.out::print);
				
		//5
				if(transactions.stream()
				.anyMatch(t->t.getTrader().getCity().equals("Milan")))
					System.out.println("someone in Milan!");
					else System.out.println("noman in Milan!");		

		//6 求和
			System.out.println("总交易额："+
				transactions.stream()
				.filter(a->a.getTrader().getCity()=="Cambridge")
				.map(a->a.getValue())
				//.reduce(0, (a,b)->a+b)
				.reduce(0,Integer::sum)
				);	
			
			System.out.println("总交易额："+
					transactions.stream()
					.filter(a->a.getTrader().getCity()=="Cambridge")
					.mapToInt(Transaction::getValue)					
					.sum()
					);		
			
				//.map(t->t.getValue())
			//	.forEach(t->System.out.println(t.getTrader().getName()+":"+t.getValue()));
		//7
			System.out.println("最高交易额："+
					transactions.stream()
					.map(a->a.getValue())
					.reduce(Integer::max)
					.get()
					);
			System.out.println("最高交易额："+
					transactions.stream()
					.mapToInt(Transaction::getValue)
					.max()                    //返回Optional
					.getAsInt()				
					);
			
			
		//8
			transactions.stream()
			.filter(a->a.getValue()==
					transactions.stream()
					.map(b->b.getValue())
					.reduce(Integer::min)
					.get())	
					.forEach(System.out::println);			
			
			System.out.println("最小交易："+
					transactions.stream()
					.min(Comparator.comparing(Transaction::getValue))
					.get()
					);
			
			

	}

}
