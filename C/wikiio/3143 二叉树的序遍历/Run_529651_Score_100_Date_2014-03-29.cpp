#include<stdio.h>
int n,i,l[100],r[100],root=1;

void preorder(int root)
{
    if(root)
    {
        printf("%d ",root);
        preorder(l[root]);
        preorder(r[root]);
    }
}

void inorder(int root)
{
    if(root)
    {
        inorder(l[root]);
        if(root) printf("%d ",root);
        inorder(r[root]);
    }
}
void postorder(int root)
{
    if(root)
    {
        postorder(l[root]);
        postorder(r[root]);
        if(root) printf("%d ",root);
    }
}


int main()
{
    
    scanf("%d",&n);
    for(i=1;i<=n;i++)
    {
        scanf("%d %d",&l[i],&r[i]);
        
    }
    if(n)
    {
        preorder(root);
        printf("\n");
        inorder(root);
        printf("\n");
        postorder(root);
    }
    
}