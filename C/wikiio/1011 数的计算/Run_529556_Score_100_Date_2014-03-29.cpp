#include<stdio.h> 
int fun(int n)
{
    int ret=0,i;
    if (n==1) return 1;
    for(i=1;i<=n/2;i++)
    {
        ret+=fun(i);        
    }
    return ret+1;
           
}
int main()
{
    int n;
    scanf("%d",&n);
    printf("%d",fun(n));
}