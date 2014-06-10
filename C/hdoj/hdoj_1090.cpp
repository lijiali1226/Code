#include<stdio.h>
int main()
{
    int n,i,a,b;
    scanf("%d\n",&n);
    for(i=0;i<n;i++)
    {
     while(scanf("%d %d",&a,&b)!=EOF)
     printf("%d\n",a+b);
    }
}
