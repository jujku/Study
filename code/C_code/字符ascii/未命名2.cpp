# include <stdio.h>
int main () {
	int sum1 = 0;
	int sum2 = 0;
	char ch1[100];
	char ch2[100];
	scanf("%s %s",ch1,ch2);
	for (int i = 0; ch1[i] !='\0'; i++) {
		sum1 += ch1[i];
	}
	for (int i = 0; ch2[i] !='\0'; i++) {
		sum2 += ch2[i];
	}
//	printf("%d %d", sum1, sum2);
	if (sum1 == sum2) {
		printf("0");
	}else if (sum1 > sum2) {
		printf("%d", sum1-sum2);
	}else {
		printf("%d", sum1-sum2);
	}
	
	
	return 0;
}
