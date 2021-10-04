class Triangle
{
	private double hyp;
	private double prep;
	private  double base;

	public double getHyp(double length,double angle)
	{
        hyp=Math.hypot(length,angle);
        return hyp;
	}
	public double getPrep(double hyp,double base)
	{
	    prep=Math.sqrt(Math.pow(hyp,2)-Math.pow(base,2));
	    return prep;
	}
	public double getBase(double hyp,double base)
	{
	    base=Math.sqrt(Math.pow(hyp,2)-Math.pow(perp,2));
	    return base;
	}
}
class UseTriangle
{
	public static void main(String args[])
	{
	   Triangle t=new triangle();
	   System.out.println("Hypotenous"+t.getHyp(10,30));
	   System.out.println("Prependiculae"+t.getPrep(6,2));
	   System.out.println("Base"+t.getBase(6,4));

	}
}