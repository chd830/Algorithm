package Concept;

import java.util.Arrays;

public class 좋은아침 {
	static char[] chars = { 'a', 'b', 'c', 'd' };

	public static void main(String[] args) {
		// chars로 만들 수 있는 부분집합을 구해보세요.

		// chars에서 3개를 고르는 순열을 작성해보세요.
		int r = 3;
		makePermutation(r, new char[r], new boolean[chars.length]);
		//makePermutation1(r, new char[r]);
		// chars에서 3개를 고르는 조합을 작성해보세요.
	}

	/**
	 * 
	 * @param r       : 뽑아야 할 숫자
	 * @param temp    : 뽑힌 녀석들
	 */
	
	static void makePermutation1(int r, char[] temp) {
		// base rule
		if (r == 0) {
			// 솔루션 실행
			System.out.println(Arrays.toString(temp));
			return;
		}
		// inductive rule
		for (int i = 0; i < chars.length; i++) {
			temp[r - 1] = chars[i];
			makePermutation1(r - 1, temp);
		}
	}

	/**
	 * 
	 * @param r       : 뽑아야 할 숫자
	 * @param temp    : 뽑힌 녀석들
	 * @param visited : 중복 방지용
	 */
	static void makePermutation(int r, char[] temp, boolean[] visited) {
		// base rule
		if (r == 0) {
			// 솔루션 실행
			System.out.println(Arrays.toString(temp));
			return;
		}
		// inductive rule
		for (int i = 0; i < chars.length; i++) {
			boolean []cloned  = visited.clone();
			if (!cloned[i]) {
				cloned[i] = true;
				temp[r - 1] = chars[i];
				makePermutation(r - 1, temp, cloned);
				//visited[i] = false;
			}
		}
	}
}
