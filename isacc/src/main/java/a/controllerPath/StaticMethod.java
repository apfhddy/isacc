package a.controllerPath;

public class StaticMethod {
	public static String enterToBr() {
		return "";
	}
	
	public static int parameterNullCheckToInt0(String parameterInt) {
		if(parameterInt == null || parameterInt.isEmpty()) {
			return 0;
		}else {
			return Integer.parseInt(parameterInt);
		}
	}
}
