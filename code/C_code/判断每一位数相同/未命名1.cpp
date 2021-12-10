#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
int is(int n)
{
	int length = 0;
	int n1;
	n1 = n;
	int val = 0;
	while (n1) {
		length++;
		n1 /= 10; 
	}
	while (length != 0) {
		val = val * 10 + n % 10;
		length--;
	}
	if (val == n) {
		return n;
	}else {
		return -1;
	}
	
}
int main()
{
	int x,i;
	for (i = 60; i <= 120000; i++)
	{
		if (is(i) != -1) {
			printf("%d\n", is(i));
		}
		 
	}
	

	return 0;
}

