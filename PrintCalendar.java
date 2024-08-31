import java.util.Scanner;
public class PrintCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter full year（请输入年份）, 例如 2012: ");
		int year = input.nextInt();
		System.out.println("Entern integers between 1 to 12（请输入月份数字1-12）: ");
		int month = input.nextInt();
		printMonth(year, month);
		
        input.close();
	}
	public static void printMonth(int year, int month) {
		printMonthTitle(year, month);
		printMonthBody(year, month);
	}
	public static void printMonthTitle(int year, int month) {
		System.out.println("          "+ getMonthName(month) +"    " + year);
		System.out.println("==============================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		
		
		
		
	}
	public static String getMonthName(int month) {
		String monthName = "";
		switch(month) {
		case 1: monthName = "Jan";
		       break;
		case 2: monthName = "Feb";
		        break;
		case 3: monthName = "Mar";
	            break;
	    case 4: monthName = "Apr";
	              break;
	    case 5: monthName = "May";
	             break;
	   case 6: monthName = "Jun";
	        break;
	   case 7: monthName = "Jul";
                 break;
       case 8: monthName = "Aug";
                 break;
       case 9: monthName = "Sep";
                  break;
        case 10: monthName = "Oct";
                  break;
       case 11: monthName = "Nov";
                  break;
       case 12: monthName = "Dec";
                  break;
		}
		return monthName;
		
	}
	
	public static void printMonthBody(int year, int month) {
		int startDay = getStartDay(year, month);
		for(int i = 1; i <= startDay; i++) {
			String whiteSpace = "";
			System.out.printf("%4s", whiteSpace);}
		int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
		for(int i = 1; i <= numberOfDaysInMonth; i ++) {
			System.out.printf("%4d",i );
			if((i + startDay)%7 ==0)
				System.out.println();
		}
		
		
	}
	public static int getStartDay(int year, int month) {
		final int FIRST_DAY_IN_1800 = 3;
	    int totalNumberOfDay = getTotalNumberOfDays(year,month);
	    return(totalNumberOfDay + FIRST_DAY_IN_1800)% 7;
	    }

	
	
	public static int getTotalNumberOfDays(int year, int month) {
		
     int total = 0;
     for(int i = 1800; i < year; i++) {
    	 if(isLeapYear(year))
    		 total += 366;
    	 else
    		 total+= 365;}
    for(int j = 1; j< month; j++) {
    		 total += getNumberOfDaysInMonth(year, month);
    	 }
        return total;
	}
	
	
	public static int getNumberOfDaysInMonth(int year, int month) {
		if(month == 1 ||month ==3 || month ==5||month== 7 || month == 8 || month== 10 ||month ==12)
			return 31;
		if(month == 4 || month == 6 ||month ==9 || month ==11 )
			return 30;
	    if(month==2)
		return isLeapYear(year)?29:28;
	    return 0;
		
	}
	
	public static boolean isLeapYear(int year) {
		return year % 400 ==0||(year % 4 == 0 && year % 100 !=0);
	}

}
