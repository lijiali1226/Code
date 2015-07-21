#include<stdio.h>

int main()
{
    int n,a[100],sum=0,avg=0,step=0,i;
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
        sum+=a[i];
    }
    avg=sum/n;
    for(i=0;i<n;i++)
    {
        if(a[i]!=avg)
        {
        a[i+1]+=a[i]-avg;//重点在这里
            step++;
        }
    }
    
    printf("%d",step);
    return 0;
}