#include<stdio.h>
#include<string.h>
int main()
{
    char a1[500],b1[500];
    int a[500],b[500],c[500],lena,lenb,lenc=1,i,inc=0;
 //   memset(a,0,sizeof(a));
 //   memset(b,0,sizeof(b));
 //   memset(c,0,sizeof(c));
    scanf("%s %s",&a1,&b1);
    lena=strlen(a1);lenb=strlen(b1);
    
    for(i=0;i<lena;i++)
    {
        a[lena-i]=a1[i]-48;
    }
    for(i=0;i<lenb;i++)
    {
        b[lenb-i]=b1[i]-48;
    }
    while(lenc<=lena || lenc<=lenb)
    {
        c[lenc]=a[lenc]+b[lenc]+inc;
        inc=c[lenc]/10;
        c[lenc]%=10;
        lenc++;
    }
    c[lenc]=inc;
    if(c[lenc]==0) lenc--;
    for(i=lenc;i>=1;i--)
        printf("%d",c[i]);
    return 0;
}