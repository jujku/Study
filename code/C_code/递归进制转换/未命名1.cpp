#include <stdio.h>
# define N 8
void dectobin( int n );

int main()
{
    int n;

    scanf("%d", &n);
    dectobin(n);

    return 0;
}
void dectobin( int n )
{
    if (n < N) printf("%d", n);
    else
    {
        dectobin(n / N);
        printf("%d", n % N);
    }
}

