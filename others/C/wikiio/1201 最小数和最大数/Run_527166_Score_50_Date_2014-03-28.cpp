#include<stdio.h>
int main()
{
    int n,i,a[100],min=8388607,max=0;
    scanf("%d",&n);
    
    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
        if (min>a[i])
            min=a[i];
        if (max<a[i])
            max=a[i];
    }
    
    printf("%d %d\n",min,max);
}