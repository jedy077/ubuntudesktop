import java.math.BigInteger;
class LatticePath{
	public static void main (String[] args){
		System.out.println(factorial(40).divide(factorial(20).multiply(factorial(20))));
	}

	static BigInteger factorial(int num){
		if (num > 1 )
			return factorial(num-1).multiply(new BigInteger(""+num));
		else
			return BigInteger.ONE;
	}
}
