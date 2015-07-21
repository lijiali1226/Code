#include<stdio.h>
int n,i,l[16],r[16],width=0,height=0,number[16];//number[i]第i层节点数

void dfs(int i,int h)
{
    number[h]++;//遍历到第h层，第h层节点数加1
    if(height<h) height=h;
    if(l[i]) dfs(l[i],h+1);//遍历下一层的左子节点
    if(r[i]) dfs(r[i],h+1);
}
int main()
{
    
    scanf("%d",&n);
    for(i=1;i<=n;i++)
    {
        scanf("%d %d",&l[i],&r[i]);
        
    }
    dfs(1,1);
    
    for(i=1;i<=n;i++)
    {
        if (number[i]>width) width=number[i];
    }
        printf("%d %d",width,height);
        
    
    
}