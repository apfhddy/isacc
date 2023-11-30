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
	
	public static String textLineChange(String text) {
		if(text.isEmpty())return text;
		String[] lines = text.split("\r\n");
		StringBuilder changeText = new StringBuilder();
		for(int i = 0; i < lines.length; i++) {
			if(lines[i].substring(0,1).equals("\t")){
				changeText.append("\t⚬ "+lines[i].substring(1));
			}else {
				changeText.append("• "+lines[i]);
			}
			if(i != lines.length-1)
				changeText.append("<br>");
		}
		return changeText.toString();
	}
	
	public static int mybatisMapObjectToInt(Object ObjInt) {
		return Integer.parseInt(String.valueOf(ObjInt));
	}
}
