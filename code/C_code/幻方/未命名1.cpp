# include <stdio.h>
int main() {
	int array[20][20];
	int arrayT[20][20];
	int n;
	int flag = 1;
	scanf("%d", &n);
	
	if(n%2 == 0) {
		flag = 0;
	}	
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &array[i][j]);
		}
	}
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			arrayT[j][i] = array[i][j];
		}
	} 
	
	int sum = 0;
	for (int i = 0; i < n; i++) {
		sum += array[i][i];
	} 
	
	for (int i = 0; i < n; i++) {
		int sum1 = 0;
		for (int j = 0; j < n; j++) {
			sum1 += array[i][j];
		}
		if (sum1 != sum) {
			flag = 0;
		}
	}
	for (int i = 0; i < n; i++) {
		int sum1 = 0;
		for (int j = 0; j < n; j++) {
			sum1 += arrayT[i][j];
		}
		if (sum1 != sum) {
			flag = 0;
		}
	}
	
	
	if (flag != 1) {
		printf("No");
	}else {
		printf("Yes");
	}
		
	
	
	

	
	return 0;
}
