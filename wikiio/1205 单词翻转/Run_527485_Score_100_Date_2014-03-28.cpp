#include<stdio.h>
#include<string.h>
int main()
{
    char a[100][100];
    int i,n=0;
    while(scanf("%s",&a[n++])!=EOF);
    n--;
    for(i=n-1;i>=0;i--)
    {
        printf("%s ",a[i]);
    }
    return 0;
}