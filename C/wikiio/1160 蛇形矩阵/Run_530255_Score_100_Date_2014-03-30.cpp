#include<stdio.h>
int main()
{
    int n,i,j,sum=0,m[100][100],s=2;
    scanf("%d",&n);
    i=n/2; j=n/2;
    m[i][j]=1;
    for(int k=1;k<=(n+1)/2;k++)
    {
        //右
        for(int a=1;a<=2*k-1;a++)
        {
            ++j;
            m[i][j]=s;
            s++;
        }
        //上
        for(int b=1;b<=2*k-1;b++)
        {
            --i;
            m[i][j]=s;
            s++;
        }
        //左
        for(int c=1;c<=2*k;c++)
        {
            --j;
            m[i][j]=s;
            s++;
        }
        //下
        for(int d=1;d<=2*k;d++)
        {
            ++i;
            m[i][j]=s;
            s++;
        }    
    }
    for(int r=0;r<n;r++)
    {
        for(int l=0;l<n;l++)
        {
            if(l!=n-1) printf("%d ",m[r][l]);
            else printf("%d",m[r][l]);
        }
        printf("\n");
    }
    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
    {
        if(i==j || i+j==n-1)
            sum+=m[i][j];
    }
    printf("%d",sum);
}
                
    
    