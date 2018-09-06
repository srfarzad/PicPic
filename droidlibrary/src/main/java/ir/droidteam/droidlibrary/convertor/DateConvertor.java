package ir.droidteam.droidlibrary.convertor;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateConvertor {
	private int irYear; // Year part of a Iranian date
	private int irMonth; // Month part of a Iranian date
	private int irDay; // Day part of a Iranian date
	private int gYear; // Year part of a Gregorian date
	private int gMonth; // Month part of a Gregorian date
	private int gDay; // Day part of a Gregorian date
	private int hDay;
	private int hMonth;
	private int hYear;
	private int juYear; // Year part of a Julian date
	private int juMonth; // Month part of a Julian date
	private int juDay; // Day part of a Julian date
	private int leap; // Number of years since the last leap year (0 to 4)
	private int JDN; // Julian Day Number
	private int march; // The march day of Farvardin the first (First day of jaYear)
	
	private String[] weekDayNames = {
	        "یکشنبه","دوشنبه",
	        "سه شنبه", "چهارشنبه",
	        "پنج شنبه", "جمعه", "شنبه"
	};
	private String[] monthNames ={
	        "فروردین","اردیبهشت","خرداد","تیر", "مرداد","شهریور",
	         "مهر", "آبان", "آذر","دی", "بهمن","اسفند"
	};
	
	private String[] monthNamesGreg = {"ژانویه", "فوریه", "مارچ", "آپریل", "می", "ژوئن", "جولای", "آگوست", "سپتامبر", "اکتبر", "نوامبر", "دسامبر"};
	
	private String[] monthNamesHijri = {"", "محرم", "صفر",
        "ربيع‌الاول", "ربيع‌الثاني", "جمادي‌الاول", "جمادي‌الثاني", "رجب",
        "شعبان", "رمضان", "شوال", "ذي‌القعده", "ذي‌الحجه"};
	
	private final int[] daysOfMonth = new int[] { 31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29 };
	
	/**
	* JavaSource_Calendar:
	* The default constructor uses the current Gregorian date to initialize the
	* other private memebers of the class (Iranian and Julian dates).
	*/
	public DateConvertor()
	{
		Calendar calendar = new GregorianCalendar();
		setGregorianDate(calendar.get(Calendar.YEAR),
		calendar.get(Calendar.MONTH)+1,
		calendar.get(Calendar.DAY_OF_MONTH));
	}

	/**
	* JavaSource_Calendar:
	* This constructor receives a Gregorian date and initializes the other private
	* members of the class accordingly.
	* @param year int
	* @param month int
	* @param day int
	*/
	public DateConvertor(int year, int month, int day)
	{
		setGregorianDate(year,month,day);
	}

	public String getMonthName(int month){
		return this.monthNames[month];
	} 

	public Integer getDaysInMonth(){
		return this.daysOfMonth[this.getIranianMonth()];
		//return 0;
	}
	public Integer getDaysInMonth(int month){
		return this.daysOfMonth[month];
	}
	public String getIranianDayOfWeekName(){
		GregorianCalendar cal = new GregorianCalendar(getGregorianYear(), getGregorianMonth()-1, getGregorianDay());
		////
		int currentWeekDay = cal.get(Calendar.DAY_OF_WEEK)-1;
		
		return this.weekDayNames[currentWeekDay];
	}
	
	/**
	* getIranianYear:
	* Returns the 'year' part of the Iranian date.
	* @return int
	*/
	public int getIranianYear() {
		return irYear;
	}

	/**
	* getIranianMonth:
	* Returns the 'month' part of the Iranian date.
	* @return int
	*/
	public int getIranianMonth() {
		return irMonth;
	}

	/**
	* getIranianDay:
	* Returns the 'day' part of the Iranian date.
	* @return int
	*/
	public int getIranianDay() {
		return irDay;
	}

	/**
	* getGregorianYear:
	* Returns the 'year' part of the Gregorian date.
	* @return int
	*/
	public int getGregorianYear() {
		return gYear;
	}

	/**
	* getGregorianMonth:
	* Returns the 'month' part of the Gregorian date.
	* @return int
	*/
	public int getGregorianMonth() {
		return gMonth;
	}

	/**
	* getGregorianDay:
	* Returns the 'day' part of the Gregorian date.
	* @return int
	*/
	public int getGregorianDay() {
		return gDay;
	}

	/**
	* getJulianYear:
	* Returns the 'year' part of the Julian date.
	* @return int
	*/
	public int getJulianYear() {
		return juYear;
	}

	/**
	* getJulianMonth:
	* Returns the 'month' part of the Julian date.
	* @return int
	*/
	public int getJulianMonth() {
		return juMonth;
	}

	/**
	* getJulianDay()
	* Returns the 'day' part of the Julian date.
	* @return int
	*/
	public int getJulianDay() {
		return juDay;
	}

	public int getHijriDay(){
		return this.hDay;
	}
	
	public int getHijriMonth(){
		return this.hMonth;
	}
	
	public int getHijriYear(){
		return this.hYear;
	}
	
	public String getHijriMonthName(int month){
		return this.monthNamesHijri[month -1];
	}
	
	/**
	* getIranianDate:
	* Returns a string version of Iranian date
	* @return String
	*/
	public String getIranianDate()
	{
		return (irYear+"/"+irMonth+"/"+irDay);
	}

	/**
	* getGregorianDate:
	* Returns a string version of Gregorian date
	* @return String
	*/
	public String getGregorianDate()
	{
		return (gYear+"/"+gMonth+"/"+gDay);
	}

	/**
	* getJulianDate:
	* Returns a string version of Julian date
	* @return String
	*/
	public String getJulianDate()
	{
		return (juYear+"/"+juMonth+"/"+juDay);
	}

	/**
	* getWeekDayStr:
	* Returns the week day name.
	* @return String
	*/
	public String getWeekDayStr()
	{
		String weekDayStr[]={
		"Monday",
		"Tuesday",
		"Wednesday",
		"Thursday",
		"Friday",
		"Saturday",
		"Sunday"};
		return (weekDayStr[getDayOfWeek()]);
	}

	/**
	* toString:
	* Overrides the default toString() method to return all dates.
	* @return String
	*/
	public String toString()
	{
		return (getWeekDayStr()+
		", Gregorian:["+getGregorianDate()+
		"], Julian:["+getJulianDate()+
		"], Iranian:["+getIranianDate()+"]");
	}

	/**
	* getDayOfWeek:
	* Returns the week day number. Monday=0..Sunday=6;
	* @return int
	*/
	public int getDayOfWeek()
	{
		return (JDN % 7);
	}

	/**
	* nextDay:
	* Go to next julian day number (JDN) and adjusts the other dates.
	*/
	public void nextDay()
	{
		JDN++;
		JDNToIranian();
		JDNToJulian();
		JDNToGregorian();
	}
	
	/**
	* nextDay:
	* Overload the nextDay() method to accept the number of days to go ahead and
	* adjusts the other dates accordingly.
	* @param days int
	*/
	public void nextDay(int days)
	{
		JDN+=days;
		JDNToIranian();
		JDNToJulian();
		JDNToGregorian();
	}

	/**
	* previousDay:
	* Go to previous julian day number (JDN) and adjusts the otehr dates.
	*/
	public void previousDay()
	{
		JDN--;
		JDNToIranian();
		JDNToJulian();
		JDNToGregorian();
	}

	/**
	* previousDay:
	* Overload the previousDay() method to accept the number of days to go backward
	* and adjusts the other dates accordingly.
	* @param days int
	*/
	public void previousDay(int days)
	{
		JDN-=days;
		JDNToIranian();
		JDNToJulian();
		JDNToGregorian();
	}

	/**
	* setIranianDate:
	* Sets the date according to the Iranian calendar and adjusts the other dates.
	* @param year int
	* @param month int
	* @param day int
	*/
	public void setIranianDate(int year, int month, int day)
	{
		irYear =year;
		irMonth = month;
		irDay = day;
		JDN = IranianDateToJDN();
		JDNToIranian();
		JDNToJulian();
		JDNToGregorian();
		JDNToIslamic();
	}

	/**
	* setGregorianDate:
	* Sets the date according to the Gregorian calendar and adjusts the other dates.
	* @param year int
	* @param month int
	* @param day int
	*/
	public void setGregorianDate(int year, int month, int day)
	{
		gYear = year;
		gMonth = month;
		gDay = day;
		JDN = gregorianDateToJDN(year,month,day);
		JDNToIranian();
		JDNToJulian();
		JDNToGregorian();
		JDNToIslamic();
	}

	/**
	* setJulianDate:
	* Sets the date according to the Julian calendar and adjusts the other dates.
	* @param year int
	* @param month int
	* @param day int
	*/
	public void setJulianDate(int year, int month, int day)
	{
		juYear = year;
		juMonth = month;
		juDay = day;
		JDN = julianDateToJDN(year,month,day);
		JDNToIranian();
		JDNToJulian();
		JDNToGregorian();
	}

	/**
	* IranianCalendar:
	* This method determines if the Iranian (Jalali) year is leap (366-day long)
	* or is the common year (365 days), and finds the day in March (Gregorian
	* Calendar)of the first day of the Iranian year ('irYear').Iranian year (irYear)
	* ranges from (-61 to 3177).This method will set the following private data
	* members as follows:
	* leap: Number of years since the last leap year (0 to 4)
	* Gy: Gregorian year of the begining of Iranian year
	* march: The March day of Farvardin the 1st (first day of jaYear)
	*/
	private void IranianCalendar()
	{
		// Iranian years starting the 33-year rule
		int Breaks[]=
		{-61, 9, 38, 199, 426, 686, 756, 818,1111,1181,
		1210,1635,2060,2097,2192,2262,2324,2394,2456,3178}  ;
		int jm,N,leapJ,leapG,jp,j,jump;
		gYear = irYear + 621;
		leapJ = -14;
		jp = Breaks[0];
		// Find the limiting years for the Iranian year 'irYear'
		j=1;
		do{
		jm=Breaks[j];
		jump = jm-jp;
		if (irYear >= jm)
		{
		leapJ += (jump / 33 * 8 + (jump % 33) / 4);
		jp = jm;
		}
		j++;
		} while ((j<20) && (irYear >= jm));
		N = irYear - jp;
		// Find the number of leap years from AD 621 to the begining of the current
		// Iranian year in the Iranian (Jalali) calendar
		leapJ += (N/33 * 8 + ((N % 33) +3)/4);
		if ( ((jump % 33) == 4 ) && ((jump-N)==4))
		leapJ++;
		// And the same in the Gregorian date of Farvardin the first
		leapG = gYear/4 - ((gYear /100 + 1) * 3 / 4) - 150;
		march = 20 + leapJ - leapG;
		// Find how many years have passed since the last leap year
		if ( (jump - N) < 6 )
		N = N - jump + ((jump + 4)/33 * 33);
		leap = (((N+1) % 33)-1) % 4;
		if (leap == -1)
		leap = 4;
	}

	/**
	 * */
	public String getGregorianMonthName(int month){
		return this.monthNamesGreg[month - 1];
	}
	
	 
	/**
	* IsLeap:
	* This method determines if the Iranian (Jalali) year is leap (366-day long)
	* or is the common year (365 days), and finds the day in March (Gregorian
	* Calendar)of the first day of the Iranian year ('irYear').Iranian year (irYear)
	* ranges from (-61 to 3177).This method will set the following private data
	* members as follows:
	* leap: Number of years since the last leap year (0 to 4)
	* Gy: Gregorian year of the begining of Iranian year
	* march: The March day of Farvardin the 1st (first day of jaYear)
	*/
	public boolean IsLeap(int irYear1)
	{
		// Iranian years starting the 33-year rule
		int Breaks[]=
		{-61, 9, 38, 199, 426, 686, 756, 818,1111,1181,
		1210,1635,2060,2097,2192,2262,2324,2394,2456,3178}  ;
		int jm,N,leapJ,leapG,jp,j,jump;
		gYear = irYear1 + 621;
		leapJ = -14;
		jp = Breaks[0];
		// Find the limiting years for the Iranian year 'irYear'
		j=1;
		do{
		jm=Breaks[j];
		jump = jm-jp;
		if (irYear1 >= jm)
		{
		leapJ += (jump / 33 * 8 + (jump % 33) / 4);
		jp = jm;
		}
		j++;
		} while ((j<20) && (irYear1 >= jm));
		N = irYear1 - jp;
		// Find the number of leap years from AD 621 to the begining of the current
		// Iranian year in the Iranian (Jalali) calendar
		leapJ += (N/33 * 8 + ((N % 33) +3)/4);
		if ( ((jump % 33) == 4 ) && ((jump-N)==4))
		leapJ++;
		// And the same in the Gregorian date of Farvardin the first
		leapG = gYear/4 - ((gYear /100 + 1) * 3 / 4) - 150;
		march = 20 + leapJ - leapG;
		// Find how many years have passed since the last leap year
		if ( (jump - N) < 6 )
		N = N - jump + ((jump + 4)/33 * 33);
		leap = (((N+1) % 33)-1) % 4;
		if (leap == -1)
		leap = 4;
		if (leap==4 || leap==0)
		    return true;
		    else
		        return false;

	}

	/**
	* IranianDateToJDN:
	* Converts a date of the Iranian calendar to the Julian Day Number. It first
	* invokes the 'IranianCalender' private method to convert the Iranian date to
	* Gregorian date and then returns the Julian Day Number based on the Gregorian
	* date. The Iranian date is obtained from 'irYear'(1-3100),'irMonth'(1-12) and
	* 'irDay'(1-29/31).
	* @return long (Julian Day Number)
	*/
	private int IranianDateToJDN()
	{
		IranianCalendar();
		return (gregorianDateToJDN(gYear,3,march)+ (irMonth-1) * 31 - irMonth/7 * (irMonth-7) + irDay -1);
	}

	/**
	* JDNToIranian:
	* Converts the current value of 'JDN' Julian Day Number to a date in the
	* Iranian calendar. The caller should make sure that the current value of
	* 'JDN' is set correctly. This method first converts the JDN to Gregorian
	* calendar and then to Iranian calendar.
	*/
	private void JDNToIranian()
	{
		JDNToGregorian();
		irYear = gYear - 621;
		IranianCalendar(); // This invocation will update 'leap' and 'march'
		int JDN1F = gregorianDateToJDN(gYear,3,march);
		int k = JDN - JDN1F;
		if (k >= 0)
		{
		if (k <= 185)
		{
		irMonth = 1 + k/31;
		irDay = (k % 31) + 1;
		return;
		}
		else
		k -= 186;
		}
		else
		{
		irYear--;
		k += 179;
		if (leap == 1)
		k++;
		}
		irMonth = 7 + k/30;
		irDay = (k % 30) + 1;
	}


	/**
	* julianDateToJDN:
	* Calculates the julian day number (JDN) from Julian calendar dates. This
	* integer number corresponds to the noon of the date (i.e. 12 hours of
	* Universal Time). This method was tested to be good (valid) since 1 March,
	* -100100 (of both calendars) up to a few millions (10^6) years into the
	* future. The algorithm is based on D.A.Hatcher, Q.Jl.R.Astron.Soc. 25(1984),
	* 53-55 slightly modified by K.M. Borkowski, Post.Astron. 25(1987), 275-279.
	* @param year int
	* @param month int
	* @param day int
	* @return int
	*/
	private int julianDateToJDN(int year, int month, int day)
	{
		return (year + (month - 8) / 6 + 100100) * 1461/4 + (153 * ((month+9) % 12) + 2)/5 + day - 34840408;
	}

	/**
	* JDNToJulian:
	* Calculates Julian calendar dates from the julian day number (JDN) for the
	* period since JDN=-34839655 (i.e. the year -100100 of both calendars) to
	* some millions (10^6) years ahead of the present. The algorithm is based on
	* D.A. Hatcher, Q.Jl.R.Astron.Soc. 25(1984), 53-55 slightly modified by K.M.
	* Borkowski, Post.Astron. 25(1987), 275-279).
	*/
	private void JDNToJulian()
	{
		int j= 4 * JDN + 139361631;
		int i= ((j % 1461)/4) * 5 + 308;
		juDay = (i % 153) / 5 + 1;
		juMonth = ((i/153) % 12) + 1;
		juYear = j/1461 - 100100 + (8-juMonth)/6;
	}

	/**
	* gergorianDateToJDN:
	* Calculates the julian day number (JDN) from Gregorian calendar dates. This
	* integer number corresponds to the noon of the date (i.e. 12 hours of
	* Universal Time). This method was tested to be good (valid) since 1 March,
	* -100100 (of both calendars) up to a few millions (10^6) years into the
	* future. The algorithm is based on D.A.Hatcher, Q.Jl.R.Astron.Soc. 25(1984),
	* 53-55 slightly modified by K.M. Borkowski, Post.Astron. 25(1987), 275-279.
	* @param year int
	* @param month int
	* @param day int
	* @return int
	*/
	private int gregorianDateToJDN(int year, int month, int day)
	{
		int jdn = (year + (month - 8) / 6 + 100100) * 1461/4 + (153 * ((month+9) % 12) + 2)/5 + day - 34840408;
		jdn = jdn - (year + 100100+(month-8)/6)/100*3/4+752;
		return (jdn);
	}
	
	/**
	* JDNToGregorian:
	* Calculates Gregorian calendar dates from the julian day number (JDN) for
	* the period since JDN=-34839655 (i.e. the year -100100 of both calendars) to
	* some millions (10^6) years ahead of the present. The algorithm is based on
	* D.A. Hatcher, Q.Jl.R.Astron.Soc. 25(1984), 53-55 slightly modified by K.M.
	* Borkowski, Post.Astron. 25(1987), 275-279).
	*/
	private void JDNToGregorian()
	{
		int j= 4 * JDN + 139361631;
		j = j + (((((4* JDN +183187720)/146097)*3)/4)*4-3908);
		int i= ((j % 1461)/4) * 5 + 308;
		gDay = (i % 153) / 5 + 1;
		gMonth = ((i/153) % 12) + 1;
		gYear = j/1461 - 100100 + (8-gMonth)/6;
	}
	
	/*
	 * JDN To Islamic
	 * */
	private void JDNToIslamic() {

        int year = this.juYear;
        int month = this.juMonth;
        int day = this.juDay;

        long k = (long) Math.floor(0.6 + (year + (month % 2 == 0 ? month : month - 1) / 12d
                + day / 365f - 1900) * 12.3685);

        double mjd;
        do {
            mjd = visibility(k);
            k = k - 1;
        } while (mjd > (this.JDN - 0.5));

        k = k + 1;
        long hm = k - 1048;

        year = 1405 + (int) (hm / 12);
        month = (int) (hm % 12) + 1;

        if (hm != 0 && month <= 0) {
            month = month + 12;
            year = year - 1;
        }

        if (year <= 0)
            year = year - 1;

        day = (int) Math.floor(this.JDN - mjd + 0.5);

        this.hYear = year;
        this.hMonth = month + 1;
        this.hDay = day;
    }

	private double visibility(long n) {

        // parameters for Makkah: for a new moon to be visible after sunset on
        // a the same day in which it started, it has to have started before
        // (SUNSET-MINAGE)-TIMZ=3 A.M. local time.
        final float TIMZ = 3f, MINAGE = 13.5f, SUNSET = 19.5f, // approximate
                TIMDIF = (SUNSET - MINAGE);

        double jd = tmoonphase(n, 0);
        long d = (long) Math.floor(jd);

        double tf = (jd - d);

        if (tf <= 0.5) // new moon starts in the afternoon
            return (jd + 1f);
        else { // new moon starts before noon
            tf = (tf - 0.5) * 24 + TIMZ; // local time
            if (tf > TIMDIF)
                return (jd + 1d); // age at sunset < min for visiblity
            else
                return jd;
        }

    }
	private double tmoonphase(long n, int nph) {

        final double RPD = (1.74532925199433E-02); // radians per degree
        // (pi/180)

        double xtra = 0;

        double k = n + nph / 4d;
        double T = k / 1236.85;
        double t2 = T * T;
        double t3 = t2 * T;
        double jd = 2415020.75933 + 29.53058868 * k - 0.0001178 * t2
                - 0.000000155 * t3 + 0.00033
                * Math.sin(RPD * (166.56 + 132.87 * T - 0.009173 * t2));

        // Sun's mean anomaly
        double sa = RPD
                * (359.2242 + 29.10535608 * k - 0.0000333 * t2 - 0.00000347 * t3);

        // Moon's mean anomaly
        double ma = RPD
                * (306.0253 + 385.81691806 * k + 0.0107306 * t2 + 0.00001236 * t3);

        // Moon's argument of latitude
        double tf = RPD
                * 2d
                * (21.2964 + 390.67050646 * k - 0.0016528 * t2 - 0.00000239 * t3);

        // should reduce to interval 0-1.0 before calculating further
        switch (nph) {
            case 0:
            case 2:
                xtra = (0.1734 - 0.000393 * T) * Math.sin(sa) + 0.0021
                        * Math.sin(sa * 2) - 0.4068 * Math.sin(ma) + 0.0161
                        * Math.sin(2 * ma) - 0.0004 * Math.sin(3 * ma) + 0.0104
                        * Math.sin(tf) - 0.0051 * Math.sin(sa + ma) - 0.0074
                        * Math.sin(sa - ma) + 0.0004 * Math.sin(tf + sa) - 0.0004
                        * Math.sin(tf - sa) - 0.0006 * Math.sin(tf + ma) + 0.001
                        * Math.sin(tf - ma) + 0.0005 * Math.sin(sa + 2 * ma);
                break;
            case 1:
            case 3:
                xtra = (0.1721 - 0.0004 * T) * Math.sin(sa) + 0.0021
                        * Math.sin(sa * 2) - 0.628 * Math.sin(ma) + 0.0089
                        * Math.sin(2 * ma) - 0.0004 * Math.sin(3 * ma) + 0.0079
                        * Math.sin(tf) - 0.0119 * Math.sin(sa + ma) - 0.0047
                        * Math.sin(sa - ma) + 0.0003 * Math.sin(tf + sa) - 0.0004
                        * Math.sin(tf - sa) - 0.0006 * Math.sin(tf + ma) + 0.0021
                        * Math.sin(tf - ma) + 0.0003 * Math.sin(sa + 2 * ma)
                        + 0.0004 * Math.sin(sa - 2 * ma) - 0.0003
                        * Math.sin(2 * sa + ma);
                if (nph == 1)
                    xtra = xtra + 0.0028 - 0.0004 * Math.cos(sa) + 0.0003
                            * Math.cos(ma);
                else
                    xtra = xtra - 0.0028 + 0.0004 * Math.cos(sa) - 0.0003
                            * Math.cos(ma);

                break;
            default:
                return 0;
        }
        // convert from Ephemeris Time (ET) to (approximate)Universal Time (UT)
        return jd + xtra - (0.41 + 1.2053 * T + 0.4992 * t2) / 1440;
    }
}
