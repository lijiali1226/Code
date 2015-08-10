#include<stdio.h>
int main()
{
    int i,j,n,a[100000],tmp;
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);        
    }
    for(i=0;i<n;i++)
    {
        for(j=n-1;j>i;j--)
        {
            if(a[j-1]>a[j])
            {
                tmp=a[j-1];
                a[j-1]=a[j];
                a[j]=tmp;
            }
        }
    }
    for(i=0;i<n;i++)
    {
        
        printf("%d ",a[i]);
         
    }
}