#include<stdio.h>
int main()
{
    int m,n,a[100],i=0,k;
    char tran[]={ '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F' };
    while(scanf("%d %d",&n,&m)!=EOF)
    {
        while(n!=0)
        {
        k=n%m;
        a[i++]=k;
        n=n/m;
        }
        for(;i>0;i--)
        {
 
            printf("%c",tran[a[i-1]]);
        }
    }
    return 0;
}

    