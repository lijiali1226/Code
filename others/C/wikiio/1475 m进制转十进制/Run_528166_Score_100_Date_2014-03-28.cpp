#include<stdio.h>
#include<string.h>
#include<math.h>
int main()
{
    int m,n=0,i,length;
    char a[100];
    scanf("%s",&a);
    length=strlen(a);
    scanf("%d",&m);
    for(i=0;i<length;i++)
    {
        if(a[i]>='A' && a[i]<='Z') a[i]=a[i]-'A'+10;
        else a[i]=a[i]-'0';
    }
    for(i=0;i<length;i++)
    {
        n+=a[i]*pow(m,length-i-1);
    }
    printf("%d",n);
    
    return 0;
}
	