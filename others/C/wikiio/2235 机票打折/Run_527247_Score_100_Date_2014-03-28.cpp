#include<stdio.h>
#include<math.h>
int main()
{
    int a;
    float b;
    scanf("%d %f",&a,&b);
    printf("%d",int(round(a*b/100)*10));
    return(0);
}