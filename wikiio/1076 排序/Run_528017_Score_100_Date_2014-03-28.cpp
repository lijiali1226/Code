#include<stdio.h>
int partition(int a[],const int start,const int end)
    {
        int i=start;
        int j=end-1;
        const int pivot=a[i];
        while(i<j)
        {
            while(i<j && a[j]>=pivot) j--;
            a[i]=a[j];
            while(i<j && a[i]<=pivot) i++;
            a[j]=a[i];
        }
        a[i]=pivot;
        return i;
    }
    
    void quick_sort(int a[],const int start,const int end)
    {
        if(start<end-1)
        {
            const int pivot=partition(a,start,end);
            quick_sort(a,start,pivot);
            quick_sort(a,pivot+1,end);
        }
    }
int main()
{
    int i,n,a[100000];
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);        
    }
    quick_sort(a,0,n);
   
    for(i=0;i<n;i++)
        printf("%d ",a[i]);

    return 0;
}