#include<stdio.h>
int main()
{
    int i,j,n,a[100000],tmp;
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
   	 	scanf("%d",&a[i]);
    }
    for(i=1;i<n;i++)
    {
        tmp=a[i];
        for(j=i-1;j>=0;j--)
        {
            if(tmp<a[j])
            {
                a[j+1]=a[j];
                a[j]=tmp;
            }
 
        }
        
    }
    for(i=0;i<n;i++)
        printf("%d ",a[i]);
    return 0;
}
                
        
    