
import java.util.*;
import java.io.*;
//나는야 포멧몬 마스터 이다솜
public class Main {
	public static int N;
	public static int M;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		String[] array = new String[N];
		Map<String, Integer> map =new HashMap<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			map.put(str, i+1);
			array[i] = str;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			String find = br.readLine();
			boolean check = true;
			for(int j=0;j<find.length();j++) {
				if(!('0'<find.charAt(j)&&find.charAt(j)>'9')) {
					check = false;
					break;
				}
				else {
					break;
				}
			}
			if(check) {
				sb.append(map.get(find)).append("\n");
			}else {
				sb.append(array[Integer.parseInt(find)-1]).append("\n");
			}
		}
		System.out.println(sb);
	}

}
