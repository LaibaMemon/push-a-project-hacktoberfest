#include<iostream>
#include<stdio.h>
using namespace std;
void login(){
	int i;
	string cuser="your-username";
    string user;
    cout<<"\n\n\n\n\n\n\t\t\t\t\tEnter Username: ";
    cin>>user;
    if(user!=cuser){
    	for(i=1;i<4;i++){

    		cout<<"Username is incorrect.\n";
    		cout<<"Enter Username again: ";
    		cin>>user;
    		if(i==1 && user!=cuser)
			continue;
			if(i==2 && user!=cuser)
			continue;
    		if(user==cuser){
    			break; //to break loop
			} //end of if inside for loop
			else {
				cout<<"****************************************************************"<<endl;
				cout<<"Sorry too many wrong username's entered, Please try again later."<<endl;
				cout<<"xxxxxxx============xxxxxxxxxxxxxxx================xxxxxxxxxxxxxx;";
				exit(0);
			} // end of else
		} // end of for loop
	} // end of if

    if(user==cuser){
    	system("cls");  // to clear the screen
    	int j;
    	string cpass="your-pass";
    	string pass;
    	cout<<"\n\n\n\n\n\n\t\t\t\t\tEnter Password: ";
        cin>>pass;
        if(pass!=cpass){
    	for(j=1;j<4;j++){

    		cout<<"Password is incorrect.\n";
    		cout<<"Re-type Password: ";
    		cin>>pass;
    		if(j==1 && pass!=cpass)
			continue;
			if(j==2 && pass!=cpass)
			continue;
    		if(pass==cpass){
    			break; //to break loop
			} //end of if inside for loop
			else {
				cout<<"****************************************************************"<<endl;
				cout<<"Sorry too many wrong passwords entered, Please try again later."<<endl;
				cout<<"xxxxxxx============xxxxxxxxxxxxxxx================xxxxxxxxxxxxxx;";
				exit(0);
			} // end of else
		} // end of for loop
	} // end of main if when password is incorrect
    if(pass==cpass){
		system("cls");
	}
} //end of if when username is correct
}// end of log in

int main()
{
    login();
    cout<<endl;
    cout<<"\t\t***********************************************************************************"<<endl;
    cout<<"\t\t***********************************************************************************"<<endl;
    cout<<"\t\t***-----------------------------------------------------------------------------***"<<endl;
    cout<<"\t\t***|                                                                           |***"<<endl;
    cout<<"\t\t***|                                                                           |***"<<endl;
    cout<<"\t\t***|                                                                           |***"<<endl;
    cout<<"\t\t***|                      Welcome To Parking System                            |***"<<endl;
    cout<<"\t\t***|                      -------------------------                            |***"<<endl;
    cout<<"\t\t***|                                                                           |***"<<endl;
    cout<<"\t\t***|   Details of Project Maker:                                               |***"<<endl;
    cout<<"\t\t***|                                                                           |***"<<endl;
    cout<<"\t\t***|           Name       : Waqar Ali Siyal                                    |***"<<endl;
    cout<<"\t\t***|           Roll no    : 18SW82                                             |***"<<endl;
    cout<<"\t\t***|           Department : Software Engineering                               |***"<<endl;
    cout<<"\t\t***|           Batch      : 18                                                 |***"<<endl;
    cout<<"\t\t***|           Section    : 2                                                  |***"<<endl;
    cout<<"\t\t***|           University : MUET, Jamshoro.                                    |***"<<endl;
    cout<<"\t\t***|                                                                           |***"<<endl;
    cout<<"\t\t***|                                                                           |***"<<endl;
    cout<<"\t\t***-----------------------------------------------------------------------------***"<<endl;
    cout<<"\t\t***********************************************************************************"<<endl;
    cout<<"\t\t***********************************************************************************"<<endl;
    cout<<endl;
    cout<<"_____________________________________________________________________________________________________"<<endl;
	cout<<"***************  Amounts of Parking for different Vehicles  ************************\n";
	cout<<"\tFor Bike parking      : Rs. 100\n";
	cout<<"\tFor Rikshaw parking   : Rs. 200\n";
	cout<<"\tFor Car parking       : Rs. 400\n";
	cout<<"\tFor Van parking       : Rs. 600\n";
	cout<<"\tFor Bus parking       : Rs. 1000"<<endl;
	cout<<"*************************************************************************************"<<endl;
	cout<<"\tThere is place for maximum 100 vehicles to park.\n";
	cout<<"*************************************************************************************"<<endl;

	int b=0,r=0,c=0,v=0,bb=0 ; // b is for bike and bb is for bus

	int n,amount=0,count=0;

	// menu
	while(true)
	{

	cout<<"\tIf you want to park a Bike.        Press 1\n";
	cout<<"\tIf you want to park a Rikshaw.     Press 2\n";
	cout<<"\tIf you want to park a Car.         Press 3\n";
	cout<<"\tIf you want to park a Van.         Press 4\n";
	cout<<"\tIf you want to park a Bus.         Press 5\n";
	cout<<"\tIf you want to see the record.     Press 6\n";
	cout<<"\tIf you want to delete the record.  Press 7\n";
	cout<<"\tIf you want to exit.               Press 8\n";
	cout<<"\tYour selected option is ";
	cin>>n;
	cout<<endl;
	switch(n){
	case 1: if(count<100){
		    b++;
		    amount+=100;
		    count++;
		    cout<<"-------------------------------------------------------------"<<endl;
		    cout<<"\t\tBike is parked."<<endl;
		    cout<<"-------------------------------------------------------------"<<endl;
	        }
	        else {
	        	cout<<"***********************************************************"<<endl;
	        	cout<<"\tParking is full, there is no place for more vehicles."<<endl;
	        	cout<<"xxxxxxx=========xxxxxxxxx==========xxxxxxx=====xxxxxx"<<endl<<endl;
			}
	        break;
	case 2: if(count<100){
		    r++;
		    amount+=200;
		    count++;
		    cout<<"-------------------------------------------------------------"<<endl;
		    cout<<"\t\tRikshaw is parked."<<endl;
		    cout<<"-------------------------------------------------------------"<<endl;
	        }
			else {
	        	cout<<"***********************************************************"<<endl;
	        	cout<<"\tParking is full, there is no place for more vehicles."<<endl;
	        	cout<<"xxxxxxx=========xxxxxxxxx==========xxxxxxx=====xxxxxx"<<endl<<endl;
			}
	        break;
	case 3: if(count<100){
		    c++;
		    amount+=400;
		    count++;
		    cout<<"-------------------------------------------------------------"<<endl;
		    cout<<"\t\tCar is parked."<<endl;
		    cout<<"-------------------------------------------------------------"<<endl<<endl;
	        }
			else {
	        	cout<<"***********************************************************"<<endl;
	        	cout<<"\tParking is full, there is no place for more vehicles."<<endl;
	        	cout<<"xxxxxxx=========xxxxxxxxx==========xxxxxxx=====xxxxxx"<<endl<<endl;
			}
	        break;
	case 4: if(count<100){
		    v++;
		    amount+=600;
		    count++;
		    cout<<"-------------------------------------------------------------"<<endl;
		    cout<<"\t\tVan is parked."<<endl;
		    cout<<"-------------------------------------------------------------"<<endl;
		    }
		    else {
	        	cout<<"***********************************************************"<<endl;
	        	cout<<"\tParking is full, there is no place for more vehicles."<<endl;
	        	cout<<"xxxxxxx=========xxxxxxxxx==========xxxxxxx=====xxxxxx"<<endl<<endl;
			}
	        break;
	case 5: if(count<100){
		    bb++;
		    amount+=1000;
		    count++;
		    cout<<"-------------------------------------------------------------"<<endl;
		    cout<<"\t\tBus is parked."<<endl;
		    cout<<"-------------------------------------------------------------"<<endl;
		    }
		    else {
	        	cout<<"***********************************************************"<<endl;
	        	cout<<"\tParking is full, there is no place for more vehicles."<<endl;
	        	cout<<"xxxxxxx=========xxxxxxxxx==========xxxxxxx=====xxxxxx"<<endl<<endl;
			}
	        break;
	case 6: cout<<"********************  Parked Vehicles  **************************\n";
	        cout<<"\tTotal number of vehicles parked   : "<<count<<endl;
	        cout<<"\tTotal number of Bikes parked      : "<<b<<endl;
	        cout<<"\tTotal number of Rikshaws parked   : "<<r<<endl;
	        cout<<"\tTotal number of cars parked       : "<<c<<endl;
	        cout<<"\tTotal number of Vans parked       : "<<v<<endl;
	        cout<<"\tTotal number of Buses parked      : "<<bb<<endl;
	        cout<<"*****************************************************************"<<endl;
	        cout<<"\tTotal amount of vehicles= "<<amount<<endl;
	        cout<<"*****************************************************************"<<endl<<endl;
	        break;
	case 7: amount=0;
	        count=0;
	        cout<<"********************************************************"<<endl;
	        cout<<"\tToatal amount          = "<<amount<<endl;
			cout<<"\tTotal vehicles parked  = "<<count<<endl;
			cout<<"\tThe area is clear, there is no any vehicle parked."<<endl;
			cout<<"****************  Record Deleted  *********************"<<endl<<endl;
			break;
	case 8: cout<<"*****************  Program Ended  *********************"<<endl<<endl;
	        cout<<"xxxxxxx=========xxxxxxxx=========xxxxxx=======xxxxxxxxx";
	        exit(0);
	default: cout<<"-----------------------------------------------------------"<<endl;
	         cout<<"\n\tInvalid Selected option."<<endl;
			 cout<<"-----------------------------------------------------------"<<endl;
			 break;
	}// end of switch
} // end of while

}// end of program
