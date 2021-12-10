#include <stdio.h>
#include <math.h>
int main(void)
{
	int  m, n;
	double num = 0;
	for (m=0; m<10; m++)
	{
		
		printf("%7d", m);			//¨º?3?¡À¨ª¨ª¡¤
	}
	printf("\n");
	
	for (int i = 0; i <= 9; i++){
		printf("%d", i);
		for(int j = 0; j < 10; j++){
			printf("  %.3lf", sqrt(num++));
		}
		printf("\n");
	}
	
	/*******************Begin********************/



	/*******************End**********************/
	return 0;
}

