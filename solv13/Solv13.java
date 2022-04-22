import java.util.*;
import java.io.*;

class Solv13 {
	static  String[][] array = new  String[100][5]; // 10개씩 데이터를 나누어 저장할 공간
	public static void main (String[] args) throws Exception{
		divide10Digit();
		overflowData();

	}
	static  void divide10Digit() throws Exception {
		File dataFile = new File("data.txt");
		Scanner scann = new Scanner(dataFile);
		String tempString;
		for (int i =0 ; i < 100 ; i++){
			tempString = scann.nextLine();
			for (int j=0 ; j<5 ; j++) {
				array[i][j]=tempString.substring(10*j, 10*(j+1));
			}
		}		
	}
	static void overflowData(){
		int overNum =0;
		long sum =0L;
		for (int j = 4 ; j>=0; j--){
			sum =(int)( sum / 1000000000);
			sum /= 10;
			System.out.println(sum);
			for ( int i = 0; i < 100 ; i ++){
				sum += Long.parseLong(array[i][j]);
			}
			System.out.println ( sum);
		}
	}
}
