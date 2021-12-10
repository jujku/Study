# include <stdio.h>
double c(int n, int m);
int main () {
	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		for (int j = 1;j <= i; j++) {
			if(j == i) {
				printf("%d",int(c(i-1,j-1)));
			}else {
				printf("%d ",int(c(i-1,j-1)));
			}
			
		}
		printf("\n");
	}
	
	
	return 0;
}

double c(int n, int m) {
	double sum1 = 1, sum2 = 1, sum3 = 1;
	for (int i = 1; i <= m; i++) {
		sum1 *= i;
	}
	for (int i = 1; i <= n-m; i++) {
		sum2 *= i;
	}
	for (int i = 1; i <= n; i++) {
		sum3 *= i;
	}
	return sum3/(sum2*sum1);
	
}
