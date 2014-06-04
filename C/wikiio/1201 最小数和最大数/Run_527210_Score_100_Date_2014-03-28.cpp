#include<stdio.h>
int main()
{
    int n,i,x,min=2147483647,max=-2147483647;
    scanf("%d",&n);
    
    for(i=0;i<n;i++)
    {
        scanf("%d",&x);
        if (min>x) min=x; 
        if (max<x) max=x;
           
    }
    
    printf("%d %d\n",min,max);
    return(0);
}
		