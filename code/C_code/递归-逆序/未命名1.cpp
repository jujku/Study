# include <stdio.h>
void exchange(int num); 
int main () {
	
	
	int num;//ÊäÈëµÄÊı×Ö
	scanf("%d", &num);
	exchange(num);
	
	return 0;
}


void exchange(int num) {
		if(num/10 == 0){
			printf("%d", num);
		}else {
			printf("%d", num%10);
			exchange(num / 10);
		}			
}
