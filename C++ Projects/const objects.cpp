#include<iostream>
using namespace std;
class calculator
   {
	private:
		int no_of_digits;
	public:
		calculator(){ no_of_digits=0;		}
		calculator(const int a){ no_of_digits=a;		}
	void setno_of_digits(int b){ no_of_digits=b;	}
	int getno_of_digits() const{ return no_of_digits;	}
	void increament () 
	{ 
	   no_of_digits++;
	}
	
                 };
    int main()
    {
    	calculator casio,casio1(5);
    	cout<<casio.getno_of_digits();    //0
    	cout<<" "<<casio1.getno_of_digits();  //5
    const calculator casio3(6);      //cant be modified
          casio.increament();
          cout<<endl<<casio.getno_of_digits()<<" ";
          casio1.increament();
          cout<<casio1.getno_of_digits()<<" ";
          
         // casio3.increament();  //error like being const cant be modified
         cout<<casio3.getno_of_digits();
    	//cout<<" "<<casio3.getno_of_digits();   //4
    	//cout<<" ";casio3.setno_of_digits();
    	//cout<<" "<<casio3.getno_of_digits();    //8

	}
