import java.util.*;
import java.io.*;
//버블 소트
public class Main {
	static int N;
	static mdata [] data;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new mdata[N];
		for(int i=0;i<N;i++) {
			data[i] = new mdata( Integer.parseInt(br.readLine()),i);
		}
		Arrays.sort(data);
		Solution();
		
	}
	public static void Solution() {
		int Max = 0;
		for(int i=0;i<N;i++) {
			if(Max<data[i].index-i)
				Max = data[i].index-i;
		}
		System.out.println(Max+1);
	}
}
class mdata implements Comparable<mdata> {
	int value;
	int index;
	
	public mdata(int value, int index) {
		super();
		this.value=value;
		this.index=index;
	}
	@Override
	public int compareTo(mdata o) {	//value 기준 오름차순 정리하기
		return this.value - o.value;
	}
	
}
