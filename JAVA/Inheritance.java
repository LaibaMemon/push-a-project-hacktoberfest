class person
{
	private String name;

	public void setName(String n)
	{
	    name=n;
	}
	public String getName()
	{
	   return name;
	}
}
class student extends person
{
	private String nameofSchool;

	public void setSchoolname(String name)
	{
	    nameofSchool=name;
	}
	public String getSchoolname()
	{
	    return nameofSchool;
	}
}
class Inheritance
{
	public static void main(String args[])
	{
	     person p=new person();
	     p.setName("laiba");
	    String s= p.getName();
	    System.out.println(s);

	     student s1=new student();
	     s1.setSchoolname("MUET");
 		 String k=s1.getSchoolname();
 		 System.out.println(k);
	     
	}
}