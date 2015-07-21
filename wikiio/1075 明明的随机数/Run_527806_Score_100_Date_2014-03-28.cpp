#include<stdio.h>
int main()
{
    int i,j,n,a[100],tmp;
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
    tmp=0;
    for(i=0;i<n;i++)
    {
        if(a[i]==a[i+1]) tmp++;
         
    }
    printf("%d\n",n-tmp);
    
    for(i=0;i<n;i++)
    {
        if(a[i]==a[i+1]);
        else printf("%d ",a[i]);
         
    }
    return 0;
    
    
}
		