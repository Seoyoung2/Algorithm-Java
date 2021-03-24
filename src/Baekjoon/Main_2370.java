package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 2370. 시장 선거 포스터 (LinkedList 쓰니까 시간초과, ArrayList 써야함)
public class Main_2370 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int[] left = new int[N];
		int[] right = new int[N];

		int l, r;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			left[i] = Integer.parseInt(st.nextToken());
			right[i] = Integer.parseInt(st.nextToken());
			if(!list.contains(left[i]))		list.add(left[i]);
			if(!list.contains(right[i]))	list.add(right[i]);
		}
		Collections.sort(list);
		
		int[] res = new int[list.size()];
		for (int i = 0; i < N; i++) {
			l = list.indexOf(left[i]);
			r = list.indexOf(right[i]);
			for (int j = l; j <= r; j++)	res[j] = i;
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 0, end = list.size(); i < end; i++)	set.add(res[i]);
		System.out.println(set.size());
	}
}
