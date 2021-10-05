#include<iostream>
using namespace std;

char board[3][3]={{'1','2','3'},{'4','5','6'},{'7','8','9'}};
char turn='X';
int row,column;
bool draw=false;
void login();


void login(){
	int i;
	string cuser="you-username";
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

void display_board(){
	    
	    system("cls");
	    
	cout<<"_____________________________________________________________________________________________"<<endl;
	cout<<"**********************************  Tic Tac Toe Game  ***************************************"<<endl;
	cout<<"\tPlayer 1 [X]                                                    Player 2 [O]               "<<endl;
	    
	    cout<<endl;
	    cout<<endl;
	    cout<<"\t\t\t\t\t     |     |     "<<endl;
	    cout<<"\t\t\t\t\t  "<<board[0][0]<<"  |  "<<board[0][1]<<"  |  "<<board[0][2]<<"  "<<endl;
	    cout<<"\t\t\t\t\t-----|-----|-----"<<endl;
	    cout<<"\t\t\t\t\t     |     |     "<<endl;
	    cout<<"\t\t\t\t\t  "<<board[1][0]<<"  |  "<<board[1][1]<<"  |  "<<board[1][2]<<"  "<<endl;
	    cout<<"\t\t\t\t\t-----|-----|-----"<<endl;
	    cout<<"\t\t\t\t\t  "<<board[2][0]<<"  |  "<<board[2][1]<<"  |  "<<board[2][2]<<"  "<<endl;
	    cout<<"\t\t\t\t\t     |     |     "<<endl;
	    
	    
	    
} // end of display_board
 void player_turn(){
		
 	     int choice;
 	     if(turn=='X')
 	     cout<<"\n\n\t\t\t\tPlayer 1 [X] turn: ";
		 if(turn=='O')
		 cout<<"\n\n\t\t\t\tPlayer 2 [O] turn: ";
		 cin>>choice;
		 switch(choice){
		 	case 1: row=0; column=0;
		 	        break;
		 	case 2: row=0; column=1;
		 	        break;
		 	case 3: row=0; column=2;
		 	        break;
		 	case 4: row=1; column=0;
		 	        break;
		 	case 5: row=1; column=1;
		 	        break;
		 	case 6: row=1; column=2;
		 	        break;
		 	case 7: row=2; column=0;
		 	        break;
		 	case 8: row=2; column=1;
		 	        break;
		 	case 9: row=2; column=2;
		 	        break;
		 	default: 
			         cout<<"\n\t\t\t\tInvalid Choice";
			         player_turn();
		 	         break;
		 	         
		 } // end of switch

	if(turn=='X' && board[row][column]!='X' && board[row][column]!='O'){
		board[row][column]='X';
		turn='O';
	}
	else if(turn=='O' && board[row][column]!='X' && board[row][column]!='O'){
		board[row][column]='O';
		turn='X';
	}
	
	else {
		   cout<<"\n\t\t\t\tBox is already filled, try another box.\n";
		   player_turn();
	}
	
	display_board();
	

} // end of player turn

bool gameover(){
	
	// checking of win
	
	  for(int i=0;i<3;i++){
	  	if(board[i][0]==board[i][1] && board[i][0]==board[i][2] || board[0][i]==board[1][i] && board[0][i]==board[2][i]){
	          return false; // returning false so that a player wins therefore game over
		  } 
	  }
	  if(board[0][0]==board[1][1] && board[0][0]==board[2][2] || board[0][2]==board[1][1] && board[0][2]==board[2][0]){
	  	return false; // returning false so that a player wins therefore game over
	  }
	  
	  // checking for game, game is finised or still in process
	  
	  for(int i=0;i<3;i++){
	  	for(int j=0;j<3;j++){
	  		 if(board[i][j]!='X' && board[i][j]!='O')
			   return true; //this means game is in process because all boxes are not filled.
			   // therefore it returns true so that game can further continue  
	  		
		  } // end of for loop for j 
	  } // end of for loop for i 
	  
	// checking for draw
	draw=true; //when all boxes filled game will draw and it reutrns false so thath game can exist
	return false;  
	
} // end of gameover



int main(){
	
	//login();
	
	
	while(gameover()){
	
	display_board();
	player_turn();
	gameover();
	
	if(turn=='X' && draw==false){
		cout<<"\n\t\t\t\tPlayer 2 [O] wins. Congartulations!!"<<endl; //because if player 1 has turn means
		// player 2 has already win the game
	}
    else if(turn=='O' && draw==false){
		cout<<"\n\t\t\t\tPlayer 1 [X] wins. Congartulations!!"<<endl; // because if player 2 has turn means
		// player 1 has already win the game
    }
    else {
    	cout<<"\n\t\t\t\t\t  Game draw!!";
	}
	
	
    } //end of while
    
    
    cout<<"\n****************************************************************************************************************"<<endl;
    cout<<"\n\t\t\t\t  Thank You for playing game."<<endl;
    cout<<"\nxxxxxxxxxxxxxxxxxx===========================xxxxxxxxxxxxxxxxxxxxxx======================xxxxxxxxxxxxxxxxxxxxxxx"<<endl;
	cout<<"\n\nCoded By : Waqar Ali Siyal"<<endl<<"Roll no: 18SW82";
}
