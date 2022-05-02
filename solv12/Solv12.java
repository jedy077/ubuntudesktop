import java.util.*;

class Solv12 {
	static long lastPa=3;
	public static void main (String[] args){
		ArrayList<Long> paList = new ArrayList<>();
		paList.add(1L);
		paList.add(2L);
		long index = 3L;
		while (true){
			lastPa = paFuct(index);
			paList.add(lastPa);
			int count = pactorization(lastPa);
			if (count >= 500) {
				System.out.println( "당신이 찾는 숫자는 :" + lastPa + "  COUNT = "+count);
				break;
			}
			System.out.println("아직 값을 찾지 못했어요, paNum:" + lastPa +", count:"+count);
			index++;
		}
	}
	static long paFuct(long index){
	/*	if ( index == 1) return 1;
		else if ( index ==2) return 3;
		else 
			return paFuct(index -1) + index;
			*/
		return lastPa + index;
			
	}

	static int pactorization (long pactor){
		int count = 0;
		for (int i=1; i <= pactor; i++ ){
			if ( pactor % i == 0){
				count++;
			}
		}
		return count;
	}
	
}
