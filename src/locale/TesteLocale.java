package locale;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class TesteLocale {
	private static final Locale locale = new Locale("fr","CA");
	public static void main(String[] args) {
//		ResourceBundle resourceJava = ResourceBundle.getBundle("bundles.TesteBundleJava");
//		System.out.println(resourceJava.getString("paulo"));
		ResourceBundle resource = ResourceBundle.getBundle("bundles.teste",new Locale("en"));
		System.out.println(resource.getString("bundle1"));
	}

	public static void obtemDatePadrao() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		System.out.println(dateFormat.format(new Date()));
	}
	
	public static void obtemCurrencyPadrao(){
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		System.out.println(numberFormat.format(10.5));
	}
	
	public static void dataComCalendar(){
		Calendar calendar = Calendar.getInstance(locale);
		calendar.add(Calendar.MONTH, 1);
		System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM, locale).format(calendar.getTime()));
	}
}
