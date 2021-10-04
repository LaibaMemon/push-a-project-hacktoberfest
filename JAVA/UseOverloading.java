class Overloading
{
	public void areaSquare(int length,int breath)
	{
	    System.out.println("The area of rectangle="+length*breath);

	}
	public void areaSquare(int length)
	{
	    System.out.println("The area of square="+length*length);
	}
}
class UseOverloading
{
	public static void main(String args[])
	{
        Overloading t=new Overloading();
        t.areaSquare(3,4);
        t.areaSquare(4);
	}
}