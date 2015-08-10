#include<stdio.h>
int main()
{
    int n,m,i,flag=0;
    scanf("%d %d",&n,&m);
    i=n>m?m:n;
    for(;i>1;i--)
    {
        if (n%i==0 && m%i==0)
        {
            printf("%d",i);
            flag=1;
            break;
        }
        
    }
    if (flag==0) printf("%d",1);
    return 0;
}