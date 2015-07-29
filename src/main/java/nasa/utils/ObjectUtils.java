package nasa.utils;

public class ObjectUtils {

	private static ObjectUtils	instance;

	private ObjectUtils() {
	}

	public synchronized static ObjectUtils getInstance() {
		if (instance == null) {
			instance = new ObjectUtils();
		}

		return instance;
	}

	public boolean isNull(Object obj) {
		return obj == null ? true : false;
	}

	public boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

}
