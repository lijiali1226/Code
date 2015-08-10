#include<stdio.h>
#include<string.h>
#include<algorithm>
//using namespace std;
int main()
{
    char a1[500],b1[500];
    int a[500]={0},b[500]={0},c[500]={0},lena,lenb,lenc=1,i,inc=0,flag=0,tmp=0;
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
    if(lena==lenb)
    {
        for(i=lena;i>0;i--)
        {
            if(a[i]>b[i])
        	{flag=1;break;}
        	else if(a[i]<b[i])
            {flag=0;break;}
        }
    }  
    if (lena>lenb || flag==1)
    {  
        while(lenc<=lena)
        {
        c[lenc]=a[lenc]-b[lenc]-inc;      
        if(a[lenc]<b[lenc]) {inc=1;c[lenc]+=10;}
        else inc=0;
        lenc++;
        }
        flag=1;
    }
    else
    {
        while(lenc<=lenb)
        {
        c[lenc]=b[lenc]-a[lenc]-inc;      
        if(b[lenc]<a[lenc]) {inc=1;c[lenc]+=10;}
        else inc=0;
        lenc++;
   		}
    }
    i=lenc-1;
	while(c[i]==0 && i!=1) i--;
    if(flag==0 && c[i]!=0)printf("-");    
    for(;i>=1;i--)
    {
        printf("%d",c[i]);
    }
    return 0;
}
		