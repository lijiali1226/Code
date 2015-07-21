#include<stdio.h>
#include<string.h>
int main()
{
    char a[500],b[500];
    int m,n,i,j,num1[500],num2[500],ans[500];
    scanf("%s %s",&a,&b);
    m=strlen(a);
    n=strlen(b);
    memset(num1,0,sizeof(num1));
    memset(num2,0,sizeof(num2));
    memset(ans,0,sizeof(ans));
    for(i=0;i<m;i++)
    {
       num1[i]=int(a[i])-48;
    }
    for(j=0;j<n;j++)
    {
        num2[j]=int(b[j])-48;
    }
    ans[0]=0;
    if(m>n)
    {
    	for(i=m-1,j=n-1;j>=0;i--,j--)
    	{
            if(num1[i]+num2[j]+ans[i+1]>=10) {ans[i+1]=(num1[i]+num2[j]+ans[i+1])%10; ans[i]++;}
        	else ans[i+1]=num1[i]+num2[j];

    	}
        for(j=m-n-1;j>=0;j--)
        {
            ans[j+1]+=num1[j];

        }
        
        if(ans[0]!=0)
        {
        		for(i=0;i<=m;i++)
	           	printf("%d",ans[i]);
        }
        else
        {
            	for(i=1;i<=m;i++)
            	printf("%d",ans[i]);
        }
    
    }
    else
    {
    	for(i=m-1,j=n-1;i>=0;i--,j--)
    	{   
            if(num1[i]+num2[j]+ans[j+1]>=10) {ans[j+1]=(num1[i]+num2[j]+ans[j+1])%10; ans[j]++;}
        	else ans[j+1]=num1[i]+num2[j];
               
    	}
         for(j=n-m-1;j>=0;j--)
         {
            ans[j+1]+=num2[j];
     
         }
        
       if(ans[0]!=0)
        {
        		for(i=0;i<=n;i++)
	           	printf("%d",ans[i]);
        }
        else
        {
            	for(i=1;i<=n;i++)
            	printf("%d",ans[i]);
        }
    
    }
        
}
    
		