class Array5StarsReverse
{
	public static void main(String args[])
	{
	// char matrix[][]={{'*'},{'*','*'},{'*','*','*'}}
		char matrix[][]= new char[][]{new char []{'*'} , new  char[]{'*', '*'} , new char[]{'*' , '*' , '*'} , new char[]{'*','*','*','*'} , new char[]{'*','*','*','*','*'}};
	for(int i=matrix.length-1;i>=0;i--)
	{
	  for(int j=0;j<matrix[i].length;j++)
	  {

	  System.out.print(matrix[i][j]);
	  }
	  System.out.println();
	
	}
	
	}
}