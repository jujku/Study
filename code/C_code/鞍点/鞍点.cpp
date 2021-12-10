# include <stdio.h>
int main() {
	int array[10][10];
	int m, n;
	int a,b;
	scanf("%d %d", &m, &n);
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &array[i][j]);
		}
	}
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			a=0;
			b=0;
			int maxr = array[i][j],minc = array[i][j];
			for (int k = 0; k < n; k++) {
				if(array[i][k] > maxr) {
					a= -1;
				}
			}
			for (int o = 0; o < m; o++) {
				if(array[o][j] < minc) {
					b=-1;
				}
					
			}
			
			
			if((a == 0) && (b == 0)) {
				
				printf("Array[%d][%d]=%d", i, j, array[i][j]);
			}
		}
		
	}
	
	return 0;
}



//int f(int m, int n, int *array[]) {
//	int maxr = array[0][n],minc = array[m][0];
//	for (int i = 1; i < n; i++) {
//		if(array[i][n] > array[m][n]) {
//			return -1;
//		}
//	}
//	for (int i = 1; i < m; i++) {
//		if(array[m][i] < array[m][n]) {
//			return -1;
//		}
//		return 0;
//	}
//	
//	
//}
