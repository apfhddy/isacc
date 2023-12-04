package a.controllerPath;

public class StaticMethod {
	
	
	public static int parameterNullCheckToInt0(String parameterInt) {
		if(parameterInt == null || parameterInt.isEmpty()) {
			return 0;
		}else {
			return Integer.parseInt(parameterInt);
		}
	}
	
	
	
	public static int mybatisMapObjectToInt(Object ObjInt) {
		return Integer.parseInt(String.valueOf(ObjInt));
	}
}
