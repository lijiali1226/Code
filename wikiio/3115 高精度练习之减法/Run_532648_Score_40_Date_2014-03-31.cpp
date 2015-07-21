#include<stdio.h>
#include<string.h>
#include<algorithm>
using namespace std;
int main()
{
    char a1[500],b1[500];
    int a[500]={0},b[500]={0},c[500]={0},lena,lenb,lenc=1,i,inc=0,flag=0;
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
   //     printf("%d\n",flag);
    }  
    
    if (lena>lenb || flag==1)
    {  
        while(lenc<=lena)
        {
        c[lenc]=a[lenc]-b[lenc]-inc;      
   //     printf("%d %d %d ",a[lenc],b[lenc],c[lenc]);
        if(a[lenc]<b[lenc]) {inc=1;c[lenc]+=10;}
        else inc=0;
  //      printf("%d\n",inc);
        lenc++;
        }
    }
    else
    {
        printf("-");
        while(lenc<=lenb)
        {
        c[lenc]=b[lenc]-a[lenc]-inc;      
   //    printf("%d %d %d\n",a[lenc],b[lenc],c[lenc]);
        if(b[lenc]<a[lenc]) {inc=1;c[lenc]+=10;}
        else inc=0;
        lenc++;
   		}
        
    }
  
	if(c[lenc-1]==0) lenc--;    
    for(i=lenc-1;i>=1;i--)
    {
        printf("%d",c[i]);
    }
    return 0;
}
		