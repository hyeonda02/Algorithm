
import java.io.*;
public class Main {
	static int[] DataArray;
	static String Data;
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Data = bf.readLine();
		DataArray = new int[Data.length()];
		Solution();
		//출력
		for(int i=0;i<DataArray.length;i++)
			System.out.print(DataArray[i]);
	}
	public static void Solution() {
		//Data(문자열 상태)를 쪼개서 정수로 바꿔서 DataArray에 저장하기
		for(int i=0;i<Data.length();i++)
			DataArray[i] = Integer.parseInt(Data.substring(i,i+1));
		//DataArray를 내림차순으로 정렬
		for(int i= DataArray.length-1;i>=0;i--) {
			for(int j=0;j<i;j++) {
				if(DataArray[j]<DataArray[j+1]) {
					int temp=DataArray[j];
					DataArray[j] = DataArray[j+1];
					DataArray[j+1]=temp;
				}
			}
		}		
	}
}
