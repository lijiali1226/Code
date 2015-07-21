#include<stdio.h>
#include<string.h>
int main()
{
    char a[500],b[500];
    int m,n,i,j,num1[500],num2[500],ans[500],len=1,inc=0;
    scanf("%s %s",&a,&b);
    m=strlen(a);
    n=strlen(b);
//    memset(num1,0,sizeof(num1));
 //   memset(num2,0,sizeof(num2));
 //   memset(ans,0,sizeof(ans));
    for(i=0;i<m;i++)
    {
       num1[i]=a[i]-48;
    }
    for(j=0;j<n;j++)
    {
        num2[j]=b[j]-48;
    }
     	while(len<=m||len<=n)
    	{
            ans[len]=num1[m-len]+num2[n-len]+inc;
            inc=ans[len]/10;
        	ans[len]%=10;
            len++;
    	}
       ans[len]=inc;
       if(inc==0) len--;
       for(i=len;i>0;i--)
	   printf("%d",ans[i]);      
        
}
    