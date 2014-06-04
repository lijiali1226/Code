#include<stdio.h>
#include<math.h>
int main()
{
    float a,b;
    scanf("%f %f",&a,&b);
    if (fabs(a-b)<1e-9) printf("yes");
    else printf("no");
    return(0);
}