import java.util.*;
import java.io.*;

class Solv11{
	public static void main (String[] args) throws Exception {
		int data[][] = initData();  // Data Init 20* 20 Grid
		splitGrid(data);
	}

	static int[][] initData() throws Exception{
		File metrixData = new File ("metrix.txt");
		Scanner metrixScan = new Scanner(metrixData);
		int metrixArray[][] = new int[20][20];
		for ( int i = 0 ; i < 20 ; i++ ){
			for ( int j = 0 ; j < 20 ; j++) {
				metrixArray[i][j]= metrixScan.nextInt();
			}
		}
		return metrixArray;
	}

	// Grid 20 * 20 데이터를 4* 4 나누는 작업이 필요하다. 
	//
	static void splitGrid(int[][] gridData){
		int[][] tempGrid = new int[4][4];
		ArrayList<Integer> maxList = new ArrayList<Integer>();
		for (int i=0 ; i < 17; i++){
			for (int j=0; j< 17; j++){
				tempGrid[0][0] = gridData[i][j];
				tempGrid[0][1] = gridData[i][j+1];
				tempGrid[0][2] = gridData[i][j+2];
				tempGrid[0][3] = gridData[i][j+3];
				tempGrid[1][0] = gridData[i+1][j];
				tempGrid[1][1] = gridData[i+1][j+1];
				tempGrid[1][2] = gridData[i+1][j+2];
				tempGrid[1][3] = gridData[i+1][j+3];
				tempGrid[2][0] = gridData[i+2][j];
				tempGrid[2][1] = gridData[i+2][j+1];
				tempGrid[2][2] = gridData[i+2][j+2];
				tempGrid[2][3] = gridData[i+2][j+3];
				tempGrid[3][0] = gridData[i+3][j];
				tempGrid[3][1] = gridData[i+3][j+1];
				tempGrid[3][2] = gridData[i+3][j+2];
				tempGrid[3][3] = gridData[i+3][j+3];
				maxList.add(gridMux(tempGrid));
			}
		}
		int maxData =0;
		for (int i : maxList){
			if ( maxData < i )
				maxData = i;
		}
		System.out.println("size :" + maxList.size());
		System.out.println("Max value is " + maxData);
	}

	static int gridMux( int[][] gridSmallData){      // 4*4 mux 중 인접한 4개의 곱의 결과중 맥스 결과를 리턴한다. 
		int tmpMuxData=0;
		int max =0;
		for ( int i = 0 ; i < 4; i++){
			tmpMuxData = gridSmallData[i][0]* gridSmallData[i][1]* gridSmallData[i][2] * gridSmallData[i][3];
			if ( max < tmpMuxData) {
				max = tmpMuxData;
			}
		}

		for ( int i = 0 ; i < 4; i++){
			tmpMuxData = gridSmallData[0][i]* gridSmallData[1][i]* gridSmallData[2][i] * gridSmallData[3][i];
			if ( max < tmpMuxData) {
				max = tmpMuxData;
			}
		}

		tmpMuxData = gridSmallData[0][0]* gridSmallData[1][1]* gridSmallData[2][2] * gridSmallData[3][3]; 
		if ( max < tmpMuxData)
			max = tmpMuxData;
		tmpMuxData = gridSmallData[3][0]* gridSmallData[2][1]* gridSmallData[1][2] * gridSmallData[0][3];
		if ( max < tmpMuxData)
			max = tmpMuxData;

		return max;
	}
}
