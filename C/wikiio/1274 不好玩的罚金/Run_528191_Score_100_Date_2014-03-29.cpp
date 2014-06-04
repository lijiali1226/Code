#include<stdio.h>
int main()
{
    int a,b;
    
    scanf("%d %d",&a,&b);  
    if ((b-a)>=1 && (b-a)<=20) 
        printf("Enter the speed limit: Enter the recorded speed of the car: You are speeding and your fine is $ %d\n",100);
    else if ((b-a)>=21 && (b-a)<=30) 
        printf("Enter the speed limit: Enter the recorded speed of the car: You are speeding and your fine is $ %d\n",270);
    else if ((b-a)>=31)
        printf("Enter the speed limit: Enter the recorded speed of the car: You are speeding and your fine is $ %d\n",500);
    else printf("Enter the speed limit: Enter the recorded speed of the car: Congratulations, you are within the speed limit\n");
   return 0;
        
        
}