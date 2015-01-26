import java.util.HashMap;
/**
 * This class is to save the variable, and save there offsets.
 * So if later we need to use that function we can check if variable exsist
 * @author waqas
 *
 */
public class hashMaper {

	HashMap<String, HashMap<String, String[]>> Table = new HashMap<>();
	HashMap<Integer, Integer> variables = new HashMap<>();

	String cFunction;
	int currentVal;

	/**
	 * 
	 * @param key
	 *            = Name of Function
	 * @param subKey
	 *            = identifier
	 * @param SubValue
	 *            = type int , bool
	 */
	public void add(String key, String subKey, String SubValue) {

		boolean isContain = Table.containsKey(key);
		String vals[] = new String[5];
		if (isContain) {
			boolean alreadyHaveId = Table.get(key).containsKey(subKey);
			if (alreadyHaveId) {
				return;
			}
			// vals.add(0, SubValue);
			// vals.add(1, "0");
			vals[0] = SubValue;
			vals[1] = "0";
			Table.get(key).put(subKey, vals);
		} else {
			currentVal = 3;
			cFunction = key;
			HashMap<String, String[]> subTable = new HashMap<>();
			// vals.add(0, SubValue);
			// vals.add(1, "0");
			vals[0] = SubValue;
			vals[1] = "0";
			subTable.put(subKey, vals);
			Table.put(key, subTable);
		}

		// currentidentifier = subKey;

	}

	public String getRegister(String currentFunction) {
		// System.out.println("ddddddd"+cFunction + " " + currentFunction);
		if (cFunction == currentFunction || cFunction == "Global") {
			currentVal++;
			return "r" + currentVal;
		}
		return null;
	}

	/**
	 * 
	 * @param currentFunction
	 * @param currentidentifier
	 * @return
	 */

	public String getValue(String currentFunction, String currentidentifier,
			int location) {
		// this.getTable();

		String vals[];

		// System.out.println(Table.get("Global"));

		if (Table.get("Global") == null
				|| Table.get("Global").get(currentidentifier) == null) {
			vals = Table.get(currentFunction).get(currentidentifier);
			vals[4] = "sp";
			// System.out.println(vals[location]);
			return vals[location];

		} else if (Table.get("Global").get(currentidentifier) != null) {
			vals = Table.get("Global").get(currentidentifier);
			vals[4] = "ip";
			return vals[location];

		} else {
			System.err.println("Error: Variable undeclared ");
			System.exit(0);
			return null;
		}

	}

	/**
	 * This will return whole subtable
	 * 
	 * @param currentFunction
	 * @param currentidentifier
	 * @param location
	 * @return
	 */
	public String[] getValueall(String currentFunction, String currentidentifier) {
		// this.getTable();

		String vals[];

		if (Table.get(currentFunction) == null
				|| Table.get(currentFunction).get(currentidentifier) == null) {
			if (Table.get("Global") == null
					|| Table.get("Global").get(currentidentifier) == null) {
				this.add("Global", currentidentifier, null);
				vals = Table.get("Global").get(currentidentifier);
				return vals;
			}
		} else {
			vals = Table.get(currentFunction).get(currentidentifier);

			return vals;
		}
		return null;
	

	}

	/**
	 * 
	 * Check for return for a funtion. See if int has a return in the body
	 * @param currentFunction
	 * @param returnId
	 */
	public void checkReturn(String currentFunction, String returnId) {
		String retVal = Table.get(currentFunction).get("_R")[0];

		String variableretVal = Table.get(currentFunction).get(returnId)[0];

		if (retVal != variableretVal) {
			System.err
					.println("Error: A value returned from a function has the wrong type.");
			System.exit(0);
		}
	}

	public String getTable() {
		for (String entry : Table.keySet()) {
			System.out.print(entry.toString() + " {");
			for (String e : Table.get(entry).keySet()) {
				System.out.print(e.toString() + " =[");
				for (String arr : Table.get(entry).get(e)) {
					System.out.print(arr + " ");

				}
				System.out.print("] ");
			}
			System.out.println("}\n");
		}

		return null;
	}
}
