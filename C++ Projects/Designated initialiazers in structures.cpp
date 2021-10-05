#include <stdio.h>
typedef struct structure{
    int a;
    int b,c;
}Structure;
int main()
{
    Structure mystr={.c=7,.a=5,.b=6};
    Structure mystr2={7,5,6};
    printf("%d %d %d\n",mystr.a,mystr.b,mystr.c);
    printf("%d %d %d",mystr2.a,mystr2.b,mystr2.c);

	return 0;


}
