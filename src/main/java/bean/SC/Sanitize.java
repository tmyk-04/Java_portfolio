package bean.SC;

public class Sanitize {
	public static String sanitize(String str) {
		if (str == null) {
			return str;
		}
		str = str.replace("&", "&amp;")
		.replace("<", "&lt;")
		.replace(">", "&gt;")
		.replace("\"", "&quot;")
		.replace("'", "&#x27;");
		return str;
	}
}
