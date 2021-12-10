# include <stdio.h>
int main ()
{
	char c;
	int i, n;
	char max;
	scanf("%d", &n);
	getchar();
	for (int j = 0; j < n; j++){
		i = 0;
		c = getchar();
		while (c != '\n'){
			
			if (i == 0){
				max = c;//getchar();
				i++;
				//printf("%c", max);
				
			}
			
			c = getchar();
			if(c > max){
				max = c;
			}
			i++; 
		}
		printf("%d %c\n", i-1, max);
		while (c != '\n')
		{
			char a = getchar();
		}
	}
	return 0;
}
