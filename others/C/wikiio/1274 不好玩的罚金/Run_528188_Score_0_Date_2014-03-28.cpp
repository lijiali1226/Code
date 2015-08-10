#include<stdio.h>
int main()
{
    int a,b;
    
    scanf("%d %d",&a,&b);
    printf("Enter the speed limit: Enter the recorded speed of the car:\n");
    
    if ((b-a)>=1 && (b-a)<=20) 
        printf("You are speeding and your fine is $ %d\n",100);
    else if ((b-a)>=21 && (b-a)<=30) 
        printf("You are speeding and your fine is $ %d\n",270);
    else if ((b-a)>=31)
        printf("You are speeding and your fine is $ %d\n",500);
    else printf("Congratulations, you are within the speed limit\n");
   return 0;
        
        
}