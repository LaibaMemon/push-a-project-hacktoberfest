#include <stdio.h>
#include <math.h>
int main()
{
	int number,val;

	do{
		printf("Enter Positive number to check if it's a Prime Number: ");
		scanf("%d",&number);
		val= ceil(sqrt(number));		
		
		for (int i = 2; i <= val; ++i)
		{
			if (number%i==0 && number!=2)
			{
				printf("%d is not a Prime Number\n",number);
				break;
			}
			else
				if (i==val)
				{
					printf("%d is a Prime Number\n",number);
				}
		}
	
	}while(number>0);
	return 0;

}
