class Solv14{

	public static void main ( String[] args){
		long searchNum = 0;
		long maxCount = 0;
		long currentCount = 0;
		for ( int i=1 ; i <= 1000000; i++){
			currentCount = searchCount(i);
			if ( maxCount < currentCount){
				maxCount = currentCount;
				searchNum = i;
			} 
			
		}
		System.out.println(" searchNumber is " + searchNum + ", Count is :" +maxCount);
	}

	static long searchCount(long number){
		if ( number ==1) { return (long)1;}
		else {
			if( number%2 == 0 ){
				return (long)(searchCount(number/2) +1);
			} else {
				return (long)(searchCount(number*3 +1) +1);
			}
		}
	}
}

