#include<stdio.h>
int a=1,b=1;
void cantor(int n)
{
    int i,k,m;
    for(i=1;i<=n;i++)
    {
        if(n<=i*(i+1)/2) {k=i;break;}//第几条斜线
    }
    m=n-k*(k-1)/2;//第k条斜线第几个
    
    if(k%2==0) {a=m;b=k+1-m;}
    else {a=k+1-m;b=m;}
}         
    
int main()
{
    int n;
    scanf("%d",&n);
    cantor(n);
    printf("%d/%d",a,b);
}