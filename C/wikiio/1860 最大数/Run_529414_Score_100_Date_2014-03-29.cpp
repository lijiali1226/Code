#include<stdio.h>
int compare(int a,int b)
{
    int la=10,lb=10;
    while(a/la)
        la*=10;
    while(b/lb)
        lb*=10;
    return (a*lb+b)-(b*la+a);
}

int main()
{
    int a[20];
 	int n,i,j;
    
    scanf("%d",&n);
    
    for(i=0;i<n;i++)
    {
       scanf("%d",&a[i]);
    }
          
    for(i=0;i<n-1;i++)
    {
        for(j=0;j<n-i-1;j++)
        {
           	int tmp;
  		  	if (compare(a[j],a[j+1])<0)
 		   	{
  		      tmp=a[j+1];
  		      a[j+1]=a[j];
   		      a[j]=tmp;
   			}
         }
    }
    for(i=0;i<n;i++)
    	printf("%d",a[i]);
    return 0;
}