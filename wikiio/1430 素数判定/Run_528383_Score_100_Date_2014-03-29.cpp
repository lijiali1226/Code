#include<stdio.h>
int main()
{
    int n,i,flag=0;
    scanf("%d",&n);
    
    for(i=n-1;i>1;i--)
    {
        if (n%i==0)
        {
            printf("\\n");
            flag=1;
            break;
        }
        
    }
    if(flag==0) printf("\\t");
    return 0;
}
    
    
        