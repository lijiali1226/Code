#include<stdio.h>
int prime(int m,int n)
{
    int flag=0,i=m>n?n:m;
    for(;i>2;i--)
    {
        if (m%(i-1)==0 || n%(i-1)==0 )
        {
            flag=1;
            break;
        }
        
    }
    return !flag;
    
}
    


int main()
{
    int x,y,i,ret=0;
    scanf("%d %d",&x,&y);
    if (y%x!=0) ret =0;
    for(i=1;i<=y/x;i++)
    {
        if((y/x)%i==0)
        {
        	if(prime(i,(y/x)/i))
       		{
           		ret++;
     		}
        }
    }
    printf("%d",ret);
    return 0;
}