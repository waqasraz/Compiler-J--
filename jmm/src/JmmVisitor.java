import java.util.ArrayList;
import java.util.Stack;

import AST.*;
/**
 * This is main class that will do the most work.
 * @author waqas
 *
 */
public class JmmVisitor extends VisitorAdaptor {

	
	ArrayList<String> stack = new ArrayList<String>();
	//to put the value of the variables
	ArrayList<Integer> compute = new ArrayList<Integer>();

	// this is if the value is i = i + 1 n = t + j
	Stack<String> computeExp = new Stack<>();
	
	hashMaper map = new hashMaper();
	//current identifier i, j k etc
	String currIdentifier;
	String typeInfo = new String();
	//save the current function, this will help to manage the scope
	String currentFunction;
	public codeGenerator generate = new codeGenerator();
	//stack offset counter
	int strcount = 0;
	//loop counter LP0, LP0
	int loopCounter = 0;
	int variableCount = 0;
	//Globale variable counter
	int globalvariablecount = 0;
	FormalparameterlistDerived1 visitor;

	/**
	 * Check if there are 2 main functions
	 */
	@Override
	public void visit(MainFunction mainFunction) {

		if (!stack.contains("main")) {
			stack.add(mainFunction.getMainfunctiondeclarator().getIdentifier()
					.getVal());
		} else {
			System.err.println("Error: You cannot have 2 main function!");
			System.exit(0);
		}

		// System.out.println(stack);

		// checkForReturn();
		// System.out.println(mainFunction);
	}

	/**
	 * This will generate code for printing sting
	 */
	@Override
	public void visit(StringVal stringVal) {
		currIdentifier = null;
		generate.lprints(stringVal.getVal(), strcount);
		strcount++;
		// generate.writeToFile();

	}

	/**
	 * if see true or false change them to 0 and 1 and save them in compute 
	 * that is being declared globally
	 */
	@Override
	public void visit(PrimaryDerived2 primaryDerived2) {
		// System.out.println(primaryDerived2);

		if (primaryDerived2.getLiteral2().equals("true")) {
			compute.add(1);
		} else if (primaryDerived2.getLiteral2().equals("true")) {
			compute.add(0);
		}
	}

	/**
	 * If see constant value just update the compute stack
	 * If there is expression then use another stack named computeExp
	 */
	@Override
	public void visit(Constant constant) {

		// map.getTable();
		// System.out.println(constant);

		if (computeExp.isEmpty()) {
			compute.add((int) Long.parseLong(constant.getVal()));
			// compute.add(Integer.parseInt(constant.getVal()));
		} else {
			computeExp.push(constant.getVal());
		}

		// System.out.println(currentFunction+ " " + compute);
		// System.out.println(map.Table.get(currentFunction).get(map.currentidentifier));
		// System.out.println(map.currentidentifier + " " + compute.get(0));

		// currIdentifier = null;
	}

	/**
	 * This will save variable value to map
	 * And hadle all kind of assignment statments
	 */
	@Override
	public void visit(AssignmentDerived1 assignmentDerived1) {

		String currentidentifier = assignmentDerived1.getIdentifier().getVal();

		// System.out.println(currentidentifier);
		// System.out.println(currentFunction + " " + currentidentifier);
		// System.out.println(computeExp);
		// System.out.println(assignmentDerived1);
		// map.getTable();
		String currentRegister;
		// map.getTable();
		String[] vals;
		if (map.Table.get(currentFunction) == null)
			vals = null;
		else
			vals = map.Table.get(currentFunction).get(currentidentifier);

		if (vals == null) {
			try {
				vals = map.Table.get("Global").get(currentidentifier);

				if (vals[2] == null) {
					if (currIdentifier != null
							&& currIdentifier.equals("getchar")) {
						currentRegister = map.getRegister(currentFunction);
						vals[2] = currentRegister;
						vals[3] = String.valueOf(globalvariablecount);
						generate.middle.add("\tbl\tLgetchar\n");
						generate.middle.add("\tmov\tr4, r0\n");
						generate.middle.add("\tstr\tr4" + ", [ip,#"
								+ globalvariablecount + "]" + "\t\t@:"
								+ currentidentifier + "\n");
						globalvariablecount += 4;
						vals[1] = "getchar";
					} else {
						String currentVal = String.valueOf(compute.get(compute
								.size() - 1));
						currentRegister = map.getRegister(currentFunction);
						vals[2] = currentRegister;
						vals[3] = String.valueOf(globalvariablecount);
						generate.middle.add("\tldr\t" + currentRegister + ", ="
								+ currentVal + "\n");
						generate.middle.add("\tstr\t" + currentRegister
								+ ", [ip,#" + globalvariablecount + "]"
								+ "\t\t@:" + currentidentifier + "\n");
						globalvariablecount += 4;
						vals[1] = currentVal;

					}
				} else if (vals[4] == "-1") {
					String currentVal = String.valueOf(compute.get(compute
							.size() - 1));
					generate.middle.add("\tldr\t" + vals[2] + ", ="
							+ currentVal + "\n");
					generate.middle.add("\tstr\t" + vals[2] + ", [ip,#"
							+ vals[3] + "]" + "\t\t@:" + currentidentifier
							+ "\n");
					vals[1] = currentVal;
				} else {

					// System.out.println(currentidentifier+" "+currIdentifier);
					currentRegister = vals[2];
					String stack = vals[3];
					String[] RetVal = map.Table.get("Global").get(
							currIdentifier);
					// System.out.println(vals[1]);
					// System.out.println(currentidentifier);
					// if()
					// generate.middle.add("\tldr\t" + currentRegister
					// +", [sp,#"+stack+"]" + "\t\t@:"+currentidentifier +"\n");
					generate.middle.add("\tldr\t" + RetVal[2] + ", [ip,#"
							+ RetVal[3] + "]" + "\t\t@:" + currIdentifier
							+ "\n");
					generate.middle.add("\tmov\t" + currentRegister + ", "
							+ RetVal[2] + "\n");
					generate.middle.add("\tstr\t" + currentRegister + ", [ip,#"
							+ stack + "]" + "\t\t\t@:" + currentidentifier
							+ "\n");

				}
				return;
			} catch (NullPointerException e) {
				// System.err.println("Error: Variable undeclared ");
				// System.exit(0);
				String op1Reg[] = new String[5];
				currentRegister = map.getRegister(currentFunction);
				op1Reg[4] = "-1";
				op1Reg[2] = currentRegister;
				op1Reg[3] = String.valueOf(globalvariablecount);
				globalvariablecount += 4;
				generate.middle.add("\tldr\tr4" + ", [ip,#" + op1Reg[3] + "]"
						+ "\n");
				map.Table.get("Global").put(currentidentifier, op1Reg);

				String currentVal = String
						.valueOf(compute.get(compute.size() - 1));
				generate.middle.add("\tldr\t" + currentRegister + ", ="
						+ currentVal + "\n");
				generate.middle
						.add("\tstr\t" + currentRegister + ", [ip,#"
								+ op1Reg[3] + "]" + "\t\t@:"
								+ currentidentifier + "\n");
				op1Reg[1] = currentVal;
				return;
			} catch (ArrayIndexOutOfBoundsException e) {
				return;
			}

		}

		// System.out.println(computeExp);

		if (computeExp.size() == 1)
			computeExp.pop();

		if (computeExp.isEmpty()) {

			if (vals[2] == null) {
				if (currIdentifier != null && currIdentifier.equals("getchar")) {
					currentRegister = map.getRegister(currentFunction);
					vals[2] = currentRegister;
					vals[3] = String.valueOf(variableCount);
					generate.middle.add("\tbl\tLgetchar\n");
					generate.middle.add("\tmov\tr4, r0\n");
					generate.middle.add("\tstr\tr4" + ", [sp,#" + variableCount
							+ "]" + "\t\t@:" + currentidentifier + "\n");
					variableCount += 4;
					vals[1] = "getchar";
					currIdentifier = currentidentifier;
				} else {
					String currentVal = String.valueOf(compute.get(compute
							.size() - 1));
					currentRegister = map.getRegister(currentFunction);
					vals[2] = currentRegister;
					vals[3] = String.valueOf(variableCount);
					generate.middle.add("\tldr\t" + currentRegister + ", ="
							+ currentVal + "\n");
					generate.middle.add("\tstr\t" + currentRegister + ", [sp,#"
							+ variableCount + "]" + "\t\t@:"
							+ currentidentifier + "\n");
					variableCount += 4;
					vals[1] = currentVal;
				}
			} else {

				// System.out.println(currentidentifier+" "+currIdentifier);
				// currIdentifier = currentidentifier;
				if (currIdentifier == null) {
					// System.out.println("Assignment derived 1");
					String currentVal = String.valueOf(compute.get(compute
							.size() - 1));
					// System.out.println(currentidentifier+" "+currentVal);

					currentRegister = vals[2];
					String stack = vals[3];
					String[] RetVal = map.Table.get(currentFunction).get(
							currentidentifier);
					// System.out.println(vals[1]);
					// System.out.println(currentidentifier);
					// if()
					// generate.middle.add("\tldr\t" + currentRegister
					// +", [sp,#"+stack+"]" + "\t\t@:"+currentidentifier +"\n");
					// generate.middle.add("\tldr\t" + RetVal[2]
					// +", [sp,#"+RetVal[3]+"]" + "\t\t@:"+currIdentifier
					// +"\n");
					generate.middle.add("\tldr\t" + currentRegister + ", ="
							+ currentVal + "\n");
					generate.middle.add("\tstr\t" + currentRegister + ", [sp,#"
							+ stack + "]" + "\t\t\t@:" + currentidentifier
							+ "\n");
				} else {
					// System.out.println("Assignment derived 1");
					String stack = vals[3];
					String[] RetVal = map.Table.get(currentFunction).get(
							currIdentifier);
					generate.middle.add("\tldr\tr0" + ", [sp,#" + RetVal[3]
							+ "]" + "\t\t@:" + currIdentifier + "\n");
					generate.middle.add("\tstr\tr0" + ", [sp,#" + stack + "]"
							+ "\t\t\t@:" + currentidentifier + "\n");
				}

			}

		} else {
			String exp = computeExp.pop();
			String op2 = computeExp.pop();
			String op1 = computeExp.pop();
			// get register for operators
			String[] op1Reg = map.Table.get(currentFunction).get(op1);
			String[] op2Reg = map.Table.get(currentFunction).get(op2);

			if (vals[2] == null) {
				// System.out.println();
				// System.out.println(currentidentifier + "=" + op1 + exp +
				// op2);
				// System.out.println(currentVal);

				if (op1Reg != null && op2Reg != null) {
					currentRegister = map.getRegister(currentFunction);
					vals[2] = currentRegister;
					vals[3] = String.valueOf(variableCount);
					generate.middle.add("\tldr\t" + op1Reg[2] + ", [sp,#"
							+ op1Reg[3] + "]" + "\n");
					generate.middle.add("\tldr\t" + op2Reg[2] + ", [sp,#"
							+ op2Reg[3] + "]" + "\n");
					generate.createAdd(vals[2], op1Reg[2], op2Reg[2], vals[3],
							exp);
					variableCount += 4;

				} else if (op1Reg != null && op2Reg == null) {
					currentRegister = map.getRegister(currentFunction);
					vals[2] = currentRegister;
					vals[3] = String.valueOf(variableCount);
					generate.middle.add("\tldr\t" + op1Reg[2] + ", [sp,#"
							+ op1Reg[3] + "]" + "\n");
					generate.createAdd(vals[2], op1Reg[2], "#" + op2, vals[3],
							exp);
					variableCount += 4;
				} else if (op1Reg == null && op2Reg != null) {
					currentRegister = map.getRegister(currentFunction);
					vals[2] = currentRegister;
					vals[3] = String.valueOf(variableCount);
					generate.middle.add("\tldr\t" + op2Reg[2] + ", [sp,#"
							+ op2Reg[3] + "]" + "\n");
					generate.createAdd(vals[2], op2Reg[2], "#" + op1, vals[3],
							exp);
					variableCount += 4;
				}

			} else {
				// System.out.println(currentidentifier + "=" + op1 + exp +
				// op2);

				if (op1Reg != null && op2Reg != null) {
					currentRegister = vals[2];
					String stack = vals[3];
					generate.middle.add("\tldr\t" + op1Reg[2] + ", [sp,#"
							+ op1Reg[3] + "]" + "\n");
					generate.middle.add("\tldr\t" + op2Reg[2] + ", [sp,#"
							+ op2Reg[3] + "]" + "\n");
					// generate.middle.add("\tldr\t" + Register0
					// +", [sp,#"+stack+"]" + "\n");
					generate.loadAdd(currentRegister, op1Reg[2], op2Reg[2],
							stack, exp);

				} else if (op1Reg != null && op2Reg == null) {
					currentRegister = vals[2];
					String stack = vals[3];
					// generate.middle.add("\tldr\t" + Register0
					// +", [sp,#"+stack+"]" + "\n");
					generate.middle.add("\tldr\t" + op1Reg[2] + ", [sp,#"
							+ op1Reg[3] + "]" + "\n");
					generate.loadAdd(currentRegister, op1Reg[2], "#" + op2,
							stack, exp);
				} else if (op1Reg == null && op2Reg != null) {
					currentRegister = vals[2];
					String stack = vals[3];
					// generate.middle.add("\tldr\t" + Register0
					// +", [sp,#"+stack+"]" + "\n");
					generate.middle.add("\tldr\t" + op2Reg[2] + ", [sp,#"
							+ op2Reg[3] + "]" + "\n");
					generate.loadAdd(currentRegister, op2Reg[2], "#" + op1,
							stack, exp);
				}

			}
		}

		// currIdentifier = currentidentifier;
		// map.Table.get(currentFunction).put(currentidentifier, vals);
	}

	/**
	 * This will see if identifier is printi then just print the integer
	 */
	@Override
	public void visit(FunctioninvocationDerived1 functioninvocationDerived1) {
		// System.out.println(functioninvocationDerived1);
		String val = functioninvocationDerived1.getIdentifier().getVal();

		// System.out.println(val + " " + currIdentifier );
		// System.out.println(compute.get(compute.size() -1));

		computeExp.removeAllElements();

		// map.getTable();
		if (val.equals("printi") && currIdentifier != null) {
			// System.out.println(val + " " + currIdentifier );
			try {
				String valueIs = map.getValue(currentFunction, currIdentifier,
						1);

				String register = map.getValue(currentFunction, currIdentifier,
						2);
				if (register == "0")
					register = null;

				String stackoff = map.getValue(currentFunction, currIdentifier,
						3);
				String location = map.getValue(currentFunction, currIdentifier,
						4);
				// System.out.println(currIdentifier + " " +stackoff);

				generate.lprinti(valueIs, strcount, register, stackoff,
						location);
				strcount++;
			} catch (NullPointerException e) {
				// TODO: handle exception
				generate.lprinti(
						String.valueOf(compute.get(compute.size() - 1)),
						strcount, null, null, "sp");
				strcount++;
			}

		} else if (val.equals("printi") && currIdentifier == null) {
			// System.out.println(compute);
			generate.lprinti(String.valueOf(compute.get(compute.size() - 1)),
					strcount, null, null, "sp");
			strcount++;
		}

		if (val.equals("printb")) {
			String valueIs = map.getValue(currentFunction, currIdentifier, 1);
			String register = map.getValue(currentFunction, currIdentifier, 2);
			// System.out.println(register);
			if (register == "0")
				register = null;
			String stackoff = map.getValue(currentFunction, currIdentifier, 3);
			generate.lprintb(valueIs, strcount, register, stackoff);
			strcount++;
		}

		if (val.equals("printc")) {
			// System.out.println(String.valueOf(compute.get(compute.size() -1)
			// ));
			// if(compute.isEmpty()){
			try {
				String valueIs = map.getValue(currentFunction, currIdentifier,
						1);
				String register = map.getValue(currentFunction, currIdentifier,
						2);
				// System.out.println(register);
				if (register == "0")
					register = null;
				String stackoff = map.getValue(currentFunction, currIdentifier,
						3);
				generate.lprintc(valueIs, strcount, register, stackoff);
				strcount++;
			} catch (NullPointerException e) {
				// TODO: handle exception
				String valIs = String.valueOf(compute.get(compute.size() - 1));
				generate.lprintc(valIs, 0, null, null);
			}
			// }

		}

		/*
		 * ldr r4,=-1 mov r0,r4 bl L1 mov r5,r0
		 */
		// System.out.println(val);
		if (!val.equals("printc") && !val.equals("printb")
				&& !val.equals("printi") && !val.equals("prints")) {
			try {
				generate.middle.add("\tldr\t" + " r4," + " ="
						+ String.valueOf(compute.get(compute.size() - 1))
						+ "\n");
				generate.middle.add("\tmov\t" + " r0," + " r4" + "\n");
				generate.middle.add("\tbl\t" + val + "\n");
				generate.middle.add("\tmov\t" + " r5," + " r0" + "\n");
			} catch (ArrayIndexOutOfBoundsException e) {
				return;
			}

		}

	}

	/**
	 * This will handle the expression like a + b etc
	 */
	@Override
	public void visit(AdditiveexpressionDerived2 additiveexpressionDerived2) {

		// System.out.println(additiveexpressionDerived2);
		/*
		 * String val1 = computeExp.pop(); String val2 = computeExp.pop();
		 */

		// System.out.println(additiveexpressionDerived2.getAddop());

		// System.out.println(computeExp);
		if (computeExp.isEmpty()) {
			int op1 = compute.remove(compute.size() - 1);
			int op2 = compute.remove(compute.size() - 1);

			// System.out.println(op1 + " " + op2);
			if (additiveexpressionDerived2.getAddop().equals("add")) {
				compute.add(op1 + op2);
			} else {
				compute.add(op2 - op1);
			}
		} else {
			computeExp.push(additiveexpressionDerived2.getAddop());
		}
		/*
		 * String eop1=computeExp.pop(); String eop2=computeExp.pop();
		 * 
		 * System.out.println(eop1 + " " + eop2);
		 */

		// System.out.println(additiveexpressionDerived2);
		// System.out.println(compute);
	}

	/**
	 * if there is multiple operator just add that operator to stack
	 */
	@Override
	public void visit(
			MultiplicativeexpressionDerived2 multiplicativeexpressionDerived2) {
		computeExp.push(multiplicativeexpressionDerived2.getMulop());
	}

	/**
	 * To mangage the lt gt all the relational expressions
	 */
	@Override
	public void visit(RelationalexpressionDerived2 relationalexpressionDerived2) {
		/*
		 * ldr r4,[sp,#0] ldr r5,=47 mov r6,#0 cmp r4,r5 movlt r6,#1 cmp r6,#0
		 * beq L3
		 */
		// System.out.println(computeExp);
		String operator = relationalexpressionDerived2.getRelationalop();
		// System.out.println(relationalexpressionDerived2);
		// map.getTable();
		// System.out.println(currentFunction + " " + currIdentifier);
		// System.out.println(operator);
		if (computeExp.size() <= 2) {
			generate.middle.add("LP" + loopCounter + ":\n");
			// String register = map.getValue(currentFunction,
			// currIdentifier,2);
			String stack = map.getValue(currentFunction, currIdentifier, 3);

			generate.middle.add("\tldr\tr4" + ", [sp,#" + stack + "]" + "\n");
			// generate.hhhmiddle.add("\tldr\t"+" r1,"+" ="+compute.get(compute.size()
			// -1)+"\n");
			generate.middle.add("\tldr\t" + " r5," + " =" + computeExp.get(1)
					+ "\n");
			generate.middle.add("\tmov\t" + " r6," + " #0" + "\n");
			generate.middle.add("\tcmp\tr4" + ", r5" + "\n");
			generate.middle.add("\tmov" + operator + "\t" + " r6," + " #1"
					+ "\n");
			generate.middle.add("\tcmp\t" + " r6," + " #0" + "\n");
			generate.middle.add("\tbeq\t LPEND" + loopCounter + "\n");
		} else {
			// map.getTable();
			String exp;
			String op2;
			String op1;
			String op0;
			if (computeExp.get(2) == "mul") {
				//System.out.println(computeExp);

				op0 = computeExp.get(3);
				op1 = computeExp.get(0);
				op2 = computeExp.get(1);
				exp = computeExp.get(2);

				computeExp.removeAllElements();
				//System.out.println(op0 + " " + op1 + " " + exp + " " + op2);

			} else {
				exp = computeExp.pop();
				op2 = computeExp.pop();
				op1 = computeExp.pop();
				op0 = computeExp.pop();
			}
			// get register for operators
			String[] op0Reg = map.Table.get(currentFunction).get(op0);
			String[] op1Reg = map.Table.get(currentFunction).get(op1);
			String[] op2Reg = map.Table.get(currentFunction).get(op2);
			// System.out.println(op0 + " " + op1 + " "+exp +" "+op2);
			/*
			 * ldr r7,[sp,#0] ldr r5,[sp,#4] sub r6,r7,r5 str r6,[sp,#0]
			 */
			generate.middle.add("LP" + loopCounter + ":\n");
			generate.middle.add("\tldr\t" + op1Reg[2] + ", [sp,#" + op1Reg[3]
					+ "]" + "\n");
			if (op2Reg == null) {

				generate.middle.add("\tldr\t" + " r5," + " =" + op2 + "\n");
				generate.middle.add("\t" + exp + "\tr0, " + op1Reg[2] + ", r5"
						+ "\n");
			} else {
				generate.middle.add("\tldr\t" + op2Reg[2] + ", [sp,#"
						+ op2Reg[3] + "]" + "\n");
				generate.middle.add("\t" + exp + "\tr0, " + op1Reg[2] + ", "
						+ op2Reg[2] + "\n");
			}
			generate.middle.add("\tmov\tr5" + ", r0" + "\n");
			if (op0Reg == null) {
				generate.middle.add("\tldr\t" + " r5," + " =" + op0 + "\n");
			} else {
				generate.middle.add("\tldr\tr4" + ", [sp,#" + op0Reg[3] + "]"
						+ "\n");
			}
			// generate.middle.add("\tldr\tr4" +", [sp,#"+op0Reg[3]+"]" + "\n");
			generate.middle.add("\tmov\t" + " r6," + " #0" + "\n");
			generate.middle.add("\tcmp\tr4" + ", r5" + "\n");
			generate.middle.add("\tmov" + operator + "\t" + " r6," + " #1"
					+ "\n");
			generate.middle.add("\tcmp\t" + " r6," + " #0" + "\n");
			generate.middle.add("\tbeq\t LPEND" + loopCounter + "\n");

		}

		computeExp.removeAllElements();
		// System.out.println(compute.get(compute.size() -1));
		// System.out.println(currIdentifier);
	}

	/**
	 * this will save the parameters to visitor object define globally
	 */
	@Override
	public void visit(FormalparameterlistDerived1 formalparameterlistDerived1) {
		visitor = formalparameterlistDerived1;
	}

	/**
	 * This is for if statment
	 */
	@Override
	public void visit(StatementDerived7 statementDerived7) {
		// System.out.println(statementDerived7);
		// generate.middle.add("\tb\tLP"+loopCounter+"\n");
		generate.middle.add("LPEND" + loopCounter + ":\n");
		loopCounter++;
	}

	/**
	 * This is for "not equal"
	 */
	@Override
	public void visit(EqualityexpressionDerived3 equalityexpressionDerived3) {

		/*
		 * ldr r4,[sp,#0] ldr r5,[ip,#0] mov r6,#0 cmp r4,r5 movne r6,#1 cmp
		 * r6,#0 beq L3
		 */

		// System.out.println(computeExp);
		if (computeExp.isEmpty()) {
			String currentVal = String.valueOf(compute.get(compute.size() - 1));
			// System.out.println(currIdentifier);
			generate.middle.add("LP" + loopCounter + ":\n");
			// String register = map.getValue(currentFunction,
			// currIdentifier,2);
			String stack = map.getValue(currentFunction, currIdentifier, 3);

			generate.middle.add("\tldr\tr4" + ", [sp,#" + stack + "]" + "\n");
			// generate.hhhmiddle.add("\tldr\t"+" r1,"+" ="+compute.get(compute.size()
			// -1)+"\n");
			generate.middle.add("\tldr\t" + " r5," + " =" + currentVal + "\n");
			generate.middle.add("\tmov\t" + " r6," + " #0" + "\n");
			generate.middle.add("\tcmp\tr4" + ", r5" + "\n");
			generate.middle.add("\tmovne" + "\t" + " r6," + " #1" + "\n");
			generate.middle.add("\tcmp\t" + " r6," + " #0" + "\n");
			generate.middle.add("\tbeq\t LPEND" + loopCounter + "\n");
			return;
		}

		String op2 = computeExp.pop();
		String op1 = computeExp.pop();
		// get register for operators
		// System.out.println(op1 + " " + op2);
		// map.getTable();

		String currentRegister;
		String[] op1Reg = map.getValueall(currentFunction, op2);
		String[] op2Reg = map.getValueall(currentFunction, op1);

		// System.out.println(op2);
		if (op1Reg[2] == null) {
			currentRegister = map.getRegister("Global");
			op1Reg[4] = "-1";
			op1Reg[2] = currentRegister;
			op1Reg[3] = String.valueOf(globalvariablecount);
			globalvariablecount += 4;
			generate.middle.add("\tldr\tr4" + ", [ip,#" + op1Reg[3] + "]"
					+ "\n");
			map.Table.get("Global").put(op2, op1Reg);
		} else {
			generate.middle.add("\tldr\tr4" + ", [sp,#" + op1Reg[3] + "]"
					+ "\n");
		}

		if (op2Reg[2] == null) {
			currentRegister = map.getRegister("Global");
			op2Reg[4] = "-1";
			op2Reg[2] = currentRegister;
			op2Reg[3] = String.valueOf(globalvariablecount);
			globalvariablecount += 4;
			generate.middle.add("\tldr\tr5" + ", [ip,#" + op2Reg[3] + "]"
					+ "\n");
			map.Table.get("Global").put(op2, op2Reg);
		} else {
			generate.middle.add("\tldr\tr5" + ", [sp,#" + op2Reg[3] + "]"
					+ "\n");
		}

		// System.out.println(op1Reg[0]+ " " + op2);

		// System.out.println(currIdentifier);

		/*
		 * generate.middle.add("\tldr\tr4" +", [sp,#"+op1Reg[3]+"]" + "\n");
		 * generate.middle.add("\tldr\t"+" r5," +", [sp,#"+op2Reg[3]+"]" +"\n");
		 */
		generate.middle.add("\tmov\t" + " r6," + " #0" + "\n");
		generate.middle.add("\tcmp\tr4" + ", r5" + "\n");
		generate.middle.add("\tmovlt\t" + " r6," + " #1" + "\n");
		generate.middle.add("\tcmp\t" + " r6," + " #0" + "\n");
		generate.middle.add("\tbeq\t LPEND" + loopCounter + "\n");

		// System.out.println(computeExp);
	}

	/**
	 * This is for While loop , if see while loop
	 */
	@Override
	public void visit(StatementDerived9 statementDerived9) {
		// System.out.println(statementDerived9);
		// generate.middle.add("test");
		// generate.middle.add("LP"+loopCounter+":\n");
		generate.middle.add("\tb\tLP" + loopCounter + "\n");
		generate.middle.add("LPEND" + loopCounter + ":\n");
		loopCounter++;
	}

	/**
	 * If see main function update the currentFunction that is defined above
	 */
	@Override
	public void visit(
			MainfunctiondeclaratorDerived1 mainfunctiondeclaratorDerived1) {

		// System.out.println(currentFunction);
		generate.createRoutine("Main", null, currentFunction);
		currentFunction = "Main";

		// System.out.println(stack);
		// generate.bottom.add(".align 2");
		// generate.writeToFile();

	}

	@Override
	public void visit(
			MainfunctiondeclaratorDerived2 mainfunctiondeclaratorDerived2) {
		System.err.println("Error: Main function cannot contain parameters!");
		System.exit(0);
	}

	@Override
	/**
	 * This will check if there is main function in stack or not
	 *  No main declaration found.
	 */
	public void visit(AllGlobals allGlobals) {

		if (!stack.contains("main")) {
			System.err.println("Error: No main function!");
			System.exit(0);
		}
		// check for function if it has return or not
		checkForReturn();

		// System.out.println(allGlobals);
	}

	/**
	 * Check if there is duplicate identifier at global scope
	 */
	@Override
	public void visit(GlobalVariableDecl globalVariableDecl) {

		String variableId = globalVariableDecl.getVariabledeclaration()
				.getIdentifier().getVal();
		String variabletype = globalVariableDecl.getVariabledeclaration()
				.getType();
		currentFunction = "Global";

		// System.out.println(currentFunction + " " + variableId + " " +
		// variabletype);
		// boolean alreadyHaveId =
		// map.Table.get("Global").containsKey(variableId);
		// if(map.Table.get("Global") != null ||
		// map.Table.get("Global").get(variableId) != null)
		map.add(currentFunction, variableId, variabletype);

		// map.getTable();

		// System.out.println(Smoke);*/

		// System.out.println(globalVariableDecl);
	}

	@Override
	/**
	 * Break statements must be inside a while statement.
	 */
	public void visit(StatementDerived4 statementDerived4) {

		Object x = statementDerived4.getParent().getParent().getParent()
				.getParent().getParent().getClass();
		Object y = StatementDerived9.class;
		if (x != y) {
			System.err.println("Error: break must be in while loop");
			System.exit(0);
		}

		generate.middle.add("break\n");

	}

	@Override
	/**
	 * The main function can't be called.
	 */
	public void visit(FunctioninvocationDerived2 functioninvocationDerived2) {
		String isMain = functioninvocationDerived2.getIdentifier().getVal();
		if (isMain.equals("main")) {
			System.err.println("Error: You cannot call main function");
			System.exit(0);
		}

		// System.out.println(currIdentifier);
		if (!isMain.equals("getchar"))
			generate.middle.add("\tbl\t " + isMain + "\t @Calling function"
					+ "\n");

		currIdentifier = isMain;
	}

	/**
	 * If function does not contain return
	 */
	@Override
	public void visit(FunctionheaderDerived1 functionheaderDerived1) {
		checkForReturn();

		String nameofFun = (functionheaderDerived1.getFunctiondeclarator()
				.getIdentifier().getVal());
		String typeofFun = (functionheaderDerived1.getType());

		variableCount = 0;

		currentFunction = nameofFun;

		map.add(currentFunction, "_R", typeofFun);
		// map.getTable();
		// System.out.println(currentFunction + " " + typeofFun);
		// to save the parameter
		if (visitor != null) {
			String id = visitor.getFormalparameter().getIdentifier().getVal();
			String type = visitor.getFormalparameter().getType();
			// System.out.println(visitor.getFormalparameter().getType());
			generate.createRoutine(nameofFun, typeofFun, currentFunction);
			map.add(currentFunction, id, type);
			String currentRegister;
			String vals[] = map.Table.get(currentFunction).get(id);
			currentRegister = map.getRegister(currentFunction);
			vals[2] = currentRegister;
			vals[3] = String.valueOf(variableCount);
			generate.middle.add("\tstr\tr0" + ", [sp,#" + variableCount + "]"
					+ "\n");
			generate.middle.add("\tldr\t" + currentRegister + ", [sp,#"
					+ variableCount + "]" + "\t\t@:" + id + "\n");
			variableCount += 4;
		}

	}

	/**
	 * check for function if it has return or not
	 */
	public void checkForReturn() {
		// System.out.println("ddd");

		boolean x = stack.contains("Infun");
		boolean y = stack.contains("Outfun");
		if (!x && !y) {
			stack.add("Infun");
		} else if (x && !y) {
			System.err
					.println("Error: No return statement in a non-void function.");
			System.exit(0);
		} else {
			// stack.remove("Infun");
			stack.remove("Outfun");

		}
	}

	/**
	 * If see a void function declaration add void to stack
	 */
	@Override
	public void visit(FunctionheaderDerived2 functionheaderDerived2) {
		String nameofFun = (functionheaderDerived2.getFunctiondeclarator()
				.getIdentifier().getVal());
		String typeofFun = (functionheaderDerived2.getTypevoid());

		// System.out.println(currentFunction + " " + typeofFun);

		// System.out.println(functionheaderDerived2);
		generate.createRoutine(nameofFun, typeofFun, currentFunction);

		currentFunction = nameofFun;
		stack.add("void");

		// stack.add("Infun");

	}

	/**
	 * if see return statement check if stack has void in it return x;
	 */
	@Override
	public void visit(StatementDerived5 statementDerived5) {

		// System.out.println(statementDerived5.getExpression().getAssignmentexpression().getConditionalorexpression());
		// System.out.println(currentFunction);

		if (stack.contains("void")) {
			System.err.println("Error: VOID function dont return any thing");
			System.exit(0);
		}

		if (stack.contains("Infun")) {
			stack.add("Outfun");
		}

		// System.out.println(statementDerived5);
		// System.out.println(compute);
		if (!compute.isEmpty())
			generate.middle.add("\tmov\t" + " r0," + " #"
					+ compute.remove(compute.size() - 1) + "" + "\n");

		// System.out.println(Smoke);
	}

	@Override
	public void visit(PostfixexpressionDerived2 postfixexpressionDerived2) {

		String returnId = postfixexpressionDerived2.getIdentifier().getVal();

		// System.out.println("Returning: " + returnId);

		if (currentFunction != "Main"
				&& postfixexpressionDerived2.getIdentifier().getVal() == "return")
			map.checkReturn(currentFunction, returnId);

		/*
		 * String retVal = Smoke.get(currentFunction).get("_R"); String
		 * variableretVal = Smoke.get(currentFunction).get(returnId);
		 * 
		 * if(retVal != variableretVal){ System.err.println(
		 * "Error: A value returned from a function has the wrong type.");
		 * System.exit(0); }
		 */

		currIdentifier = returnId;

		computeExp.push(returnId);

		// System.out.println(currIdentifier);
	}

	/**
	 * If see variable just add them to hashMaper table
	 */
	@Override
	public void visit(BlockstatementDerived1 blockstatementDerived1) {

		String variableId = blockstatementDerived1.getVariabledeclaration()
				.getIdentifier().getVal();
		String variableType = blockstatementDerived1.getVariabledeclaration()
				.getType();

		/*
		 * InnerSmoke.put(variableId, variableType); Smoke.put(currentFunction,
		 * InnerSmoke);
		 */
		// System.out.println(currentFunction);

		// System.out.println(variableId + " " + variableType);

		map.add(currentFunction, variableId, variableType);

		// map.getTable();

		// System.out.println(blockstatementDerived1);
	}

	/**
	 * if see return statement check if stack has void in it This is return;
	 */
	@Override
	public void visit(StatementDerived6 statementDerived6) {

		if (stack.contains("void")) {
			System.err.println("Error: VOID function dont return any thing");
			System.exit(0);
		}

		if (stack.contains("Infun")) {
			System.err
					.println("Error: A non-void function must return a value. ");
			System.exit(0);
		}
	}

}
