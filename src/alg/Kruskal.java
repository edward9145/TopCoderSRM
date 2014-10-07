package alg;

import java.util.Arrays;

/**
 * http://www.cnblogs.com/yesun/p/3200052.html
 */
public class Kruskal {

	public static void main(String[] args) {
		int[][] map = new int[][] {
				{ 0, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX },
				{ 10, 0, 18, MAX, MAX, MAX, 16, MAX, 12 },
				{ MAX, MAX, 0, 22, MAX, MAX, MAX, MAX, 8 },
				{ MAX, MAX, 22, 0, 20, MAX, MAX, 16, 21 },
				{ MAX, MAX, MAX, 20, 0, 26, MAX, 7, MAX },
				{ 11, MAX, MAX, MAX, 26, 0, 17, MAX, MAX },
				{ MAX, 16, MAX, MAX, MAX, 17, 0, 19, MAX },
				{ MAX, MAX, MAX, 16, 7, MAX, 19, 0, MAX },
				{ MAX, 12, 8, 21, MAX, MAX, MAX, MAX, 0 } };
		System.out.println(Arrays.deepToString(map));
		kruskal(map);
	}

	static int MAX = Integer.MAX_VALUE;

	public static int kruskal(int[][] arcs) {
		// 顶点个数
		int num = arcs.length;
		// 存放对应顶点所在连通图标识
		int[] group = new int[num];

		int sum = 0, n1 = 0, n2 = 0;
		boolean finished = false;
		int groupNum = 1;

		while (!finished) {
			int min = Integer.MAX_VALUE;
			// 找出所有边中最小值
			for (int i = 0; i < num; i++) {
				for (int j = i + 1; j < num; j++) {
					if (arcs[i][j] > 0 && arcs[i][j] < min) {
						// 如果group相同，则表示处理过，不相同或都为0都表示没处理过
						if (group[i] != group[j]
								|| (group[i] == 0 && group[j] == 0)) {
							min = arcs[i][j];
							n1 = i;
							n2 = j;
						}
					}
				}
			}

			if (min == Integer.MAX_VALUE) {
				continue;
			}

			System.out.println(n1 + " ---> " + n2 + " " + min);
			sum += min;

			// 找到了最小值，设置连通标记
			if (group[n1] == 0 && group[n2] == 0) {
				group[n1] = groupNum;
				group[n2] = groupNum;
				groupNum++;
			} else if (group[n1] > 0 && group[n2] > 0) {
				int tmp = group[n2];
				for (int m = 0; m < group.length; m++) {
					if (group[m] == tmp) {
						group[m] = group[n1];
					}
				}
			} else {
				if (group[n1] == 0) {
					group[n1] = group[n2];
				} else {
					group[n2] = group[n1];
				}
			}

			for (int i = 0; i < group.length; i++) {
				if (group[i] != group[0]) {
					finished = false;
					break;
				} else {
					finished = true;
				}
			}

			if (finished) {
				break;
			}
		}

		System.out.println(" sum:" + sum);
		return sum;
	}

}
