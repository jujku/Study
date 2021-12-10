# include <stdio.h>
int main () {
	int sum1 = 0;
	int sum2 = 0;
	char ch1;
	char ch2;
	while ((ch1 = getchar()) != ' ') {
		sum1 += ch1;
	}
	
	while ((ch2 = getchar()) != '\n') {
		sum2 += ch2;
	}
	
	if (sum1 == sum2) {
		printf("0");
	}else if (sum1 > sum2) {
		printf("%d", sum1-sum2);
	}else {
		printf("%d", sum1-sum2);
	}
	
//	printf("%d %d", sum1, sum2);
	
	
	return 0;
}
