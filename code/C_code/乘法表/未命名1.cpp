# include <stdio.h>
int main (){
	
	printf("   1   2   3   4   5   6   7   8   9\n");
	printf("   -   -   -   -   -   -   -   -   -\n");
	int p, i, j;
	for (i = 1; i <= 9; i++){
		for (p = 10 - i; p < 9; p++ ){
			printf("    ");
		}
		for(j = i; j <= 9; j++){
			printf("%4d", i * j);
		}
		printf("\n");
	}
	
	return 0;
}
