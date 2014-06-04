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
        if(text[i]==pattern[0]) ret=i;
        {
        for(j=1;j<n;j++)
        {
            if (text[i+j]!=pattern[j]) break;

            else 
            {
                a++;
                if (a==n-1) printf("%d",ret+1);
            }
        }
        }
        
    }
    
    return(0);

}
			