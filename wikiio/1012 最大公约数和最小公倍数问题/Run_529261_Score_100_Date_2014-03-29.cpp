#include<stdio.h>
int gcd(int m,int n)
{
    int i;
    i=n>m?m:n;
    for(;i>=1;i--)
    {
        if (n%i==0 && m%i==0)
        {
            return i;
        }
    }
}
int lcm(int m,int n)
{
    return m*n/gcd(m,n);
}

int main()
{
    int x,y,i,ret=0,tmp;
    scanf("%d %d",&x,&y);
    if (y%x!=0) ret =0;
    else 
    {
        for(i=x;i<=y;i+=x)
        {
            tmp=x*y/i;
            if(lcm(i,tmp)==y && gcd(i,tmp)==x)
                ret++;
                
        }
    }
    printf("%d",ret);
    return 0;
}
	