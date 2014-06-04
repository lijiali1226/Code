#include<stdio.h>
int main()
{
    int id,n,m,a[1000][1000],sum[1000],ret=0,i,j;
    scanf("%d %d %d",&id,&n,&m);
    for(i=0;i<n;i++) sum[i]=0;
    for(i=0;i<n;i++)
    {
        for(j=0;j<m;j++)
        {
        	scanf("%d",&a[i][j]);
            sum[i]+=a[i][j];
        }
    }
    
    for(i=0;i<n;i++)
    {
        if (sum[i]>sum[id-1] || ( (i<id-1) && sum[i]==sum[id-1] )) ret++;
    }
    printf("%d",ret+1);
}
        
    
        