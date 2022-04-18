import java.util.*;

class solv10 {
	public static void main (String [] args){
		Scanner input_number = new Scanner(System.in);
		System.out.printf("input number:");
		int number = input_number.nextInt();
		ArrayList<Integer> value = new ArrayList<Integer>();
		long startTime = System.currentTimeMillis();
		value = primeCheck(number);
		long sum = 0;
		for (int i : value){
			//System.out.printf("[%d],",i);
			sum = sum + i;
		}

		System.out.printf ( "%nThs sum of Prime is %d%n", sum);
		long endTime = System.currentTimeMillis();
		System.out.println ("Result time : " +(endTime -startTime) );
	}

	public static ArrayList<Integer> primeCheck(int num){
		ArrayList<Integer> primeList = new ArrayList<Integer>();

		for (int i = 2; i <= num ; i++ ){
			boolean primebool = true;
			if ( i < 4)
				primeList.add(i);
			else if ( i % 2 == 0 ) continue;
			else {
				for ( int j = 3 ; j < i ; j=j+2 )
				{
					if (i % j == 0 ){
						primebool = false;
						break;
					}
				}	
				if (primebool)
					primeList.add(i);
			}
		}

		return primeList;
	}
}
