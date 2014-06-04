#include<stdio.h>
#include<math.h>
int prime(int m)
{
    int a[100000],i,j=0,flag=0;
    if(m%2==0)
    {
        a[0]=2;
        m=m/2;
        flag=1;
    }
    for(i=3;i<=m;i++)
    {   
        if(m%i==0)
        {
            if(flag==1) j=1;
            a[j++]=i;
            m=m/i;
            
        }
    }
    
//    for(i=1;i<j;i++)
//    printf("%d ",a[i]);
    
    return pow(2,j);
}
    

int main()
{
    int x,y,i,ret=0;
    scanf("%d %d",&x,&y);
    if (y%x!=0) ret =0;
    else ret=prime(y/x);
    printf("%d",ret);
    return 0;
}