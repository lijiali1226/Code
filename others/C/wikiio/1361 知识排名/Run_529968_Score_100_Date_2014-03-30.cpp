#include<stdio.h>
int main()
{
    int id,n,m,a[1000][1000],sum[1000],ret=0,i,j,score[1000],final[1000];
    scanf("%d %d %d",&id,&n,&m);
    for(i=0;i<n;i++) {final[i]=0;}
    for(j=0;j<m;j++) {sum[j]=0;score[j]=0;}
    for(i=0;i<n;i++)
    {
        for(j=0;j<m;j++)
        {
        	scanf("%d",&a[i][j]);
            if(a[i][j]==0) score[j]++;
        }
        
    }   
  //      for(j=0;j<m;j++)
        {
    //        score[j]=m-sum[j];
   //       printf("%d ",score[j]);
        }
    
    for(i=0;i<n;i++)
    {
        for(j=0;j<m;j++)
        {
            final[i]+=a[i][j]*score[j];
            
        }
       
    }
 //   for(i=0;i<n;i++) printf("%d ",final[i]);
    
     for(i=0;i<n;i++)
    {         
         if ( (final[i]>final[id-1]) || ( (i<id-1) && (final[i]==final[id-1]) )) ret++;
     
    }
    printf("%d",ret+1);
}