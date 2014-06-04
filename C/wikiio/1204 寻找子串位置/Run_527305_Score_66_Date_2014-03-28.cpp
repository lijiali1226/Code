#include<stdio.h>
#include<string.h>
int main()
{
    char text[100],pattern[100];
    int i,j,m,n,ret,a=0;
    scanf("%s %s",&text,&pattern);
	m=strlen(text);
    n=strlen(pattern);
    for(i=0;i<m;i++)
    {
        for(j=0;j<n;j++)
        {
            if (text[i]!=pattern[j]) break;
            else
            {
                ret=i;
                a++;
            }
                        
            if (a==n) printf("%d",ret+1);
                     
        }
        
    }
    return(0);
    
}