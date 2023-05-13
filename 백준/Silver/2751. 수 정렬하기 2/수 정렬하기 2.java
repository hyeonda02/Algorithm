
//수 정렬하기 (병합정렬)
import java.io.*;
public class Main {
	static int[] temp,Data;
	static int result;
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		Data = new int[N+1];
		temp = new int[N+1];
		for(int i=1;i<=N;i++)
			Data[i]=Integer.parseInt(bf.readLine());
		merge(1,N);
		for(int i=1;i<=N;i++)
			bw.write(Data[i]+"\n");
		bw.flush();
		bw.close();
	}
	public static void merge(int start,int end) {
		if(end-start<1)
			return;
		int m = start+(end-start)/2;	//중간 지점
		merge(start,m);	//구간 나누기
		merge(m+1,end);
		for(int i=start;i<=end;i++)
			temp[i]=Data[i];
		int k = start;
		int index1 = start;
		int index2 = m+1;
		//그룹 두개 병합하기
		while(index1<=m&&index2<=end) {
			if(temp[index1]>temp[index2]) {
				Data[k]=temp[index2];
				k++;
				index2++;
			}
			else {
				Data[k]=temp[index1];
				k++;
				index1++;
			}
		}
		while(index1<=m) {
			Data[k]=temp[index1];
			k++;
			index1++;
		}
		while(index2<=end) {
			Data[k]=temp[index2];
			k++;
			index2++;
		}
		
	}

}
