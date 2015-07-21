#include<stdio.h>
#include<math.h>
int prime(int m)
{
    int a[100],i,j=1;
    if(m%2==0 && m!=2)
    {
        a[0]=2;
        m=m/2;
    }
    for(i=3;i<m;i++)
    {   
        if(m%i==0)
        {
            a[j]=i;
            m=m/i;
            j++;
        }
    }
//    for(i=0;i<j;i++)
//    printf("%d",a[i]);
    
    return pow(2,j);
}
    

int main()
{
    int x,y,i,ret=0;
    scanf("%d %d",&x,&y);
    if (y%x!=0) ret =0;
    printf("%d",prime(y/x));
    return 0;
}