package stream.exercise;
import java.util.stream.*;
public class gg {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Stream<double[]> pSteeam = IntStream.range(1, 100).boxed()
				.flatMap(a->IntStream.rangeClosed(a,100)
									 .mapToObj(b->new double[]{a,b,Math.sqrt(a*a+b*b)}) //生成三元数组
									 .filter(t->t[2]%1 == 0)
						);
		pSteeam.forEach(a->System.out.println(a[0]+" "+a[1]+" "+a[2]));
						
	}

}
