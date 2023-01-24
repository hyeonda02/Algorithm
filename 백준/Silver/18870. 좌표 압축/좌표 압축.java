
import java.util.*;
import java.io.*;
//좌표 압축
public class Main {
	static int N;
	static int[] data;
	static int[] sort;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data =new int[N];	//원본
		sort = new int[N];	//정렬된것
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<data.length;i++) {
			data[i] = Integer.parseInt(st.nextToken());
			sort[i] = data[i];
		}
		//정렬
		Arrays.sort(sort);
		
		//map 이용하여 <좌표값,좌표값의 최소 인덱스> 저장하기
		HashMap<Integer,Integer>map = new HashMap<>();
		int index =0;
		
		for(int i=0;i<sort.length;i++) {
			if(!map.containsKey(sort[i]))
				map.put(sort[i],index++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<data.length;i++) {
			sb.append(map.get(data[i])).append(' ');
		}
		System.out.println(sb);
		
	}
}
