#include<stdio.h>
int fun(int x)
{
    if(x>=0)
        return 5;
    else 
        return fun(x+1)+fun(x+2)+1;
}
int main()
{
    int x;
    scanf("%d",&x);
    printf("%d",fun(x));
}