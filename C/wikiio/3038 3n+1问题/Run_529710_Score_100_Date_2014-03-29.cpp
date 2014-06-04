#include<stdio.h>
int fun(int n)
{
    
    if(n==1) return 0;
    else 
    {
        if(n%2!=0) return fun(3*n+1)+1;
        if(n%2==0) return fun(n/2)+1;
    }
    
}

int main()
{
    int t,n[100],i;
    scanf("%d",&t);
    for(i=0;i<t;i++)
        scanf("%d",&n[i]);
    
    for(i=0;i<t;i++)
    {
        printf("%d\n",fun(n[i]));
    }         
}