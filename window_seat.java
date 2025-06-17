import java.util.Scanner;
class Main
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int no_seat=sc.nextInt();
		int seat_no=sc.nextInt();
		System.out.println("enter the no of seats in a row");
		int n=sc.nextInt();
		int total=n*no_seat;
		if(seat_no>total)
		{
			System.out.println("invalid seatno");
		}
		else if(seat_no%no_seat==0||seat_no%no_seat==1)
		{
			System.out.println("it is a window seat");
		}
		else{
			System.out.println("it is not a window seat");
		}
	}
}