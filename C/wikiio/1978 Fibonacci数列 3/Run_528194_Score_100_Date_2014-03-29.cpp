#include<stdio.h>
int fab(int a)
{
    if (a==1 || a==2)
        return 1;
    else
        return fab(a-1)+fab(a-2);
}
int main()
{
    int n;
    scanf("%d",&n);
    printf("%d",fab(n));
    
}
    