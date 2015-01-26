import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This is to generate the code 
 * @author waqas
 *
 */
public class codeGenerator {
	ArrayList<String> top =new ArrayList<String>();
	ArrayList<String> middle =new ArrayList<String>();
	ArrayList<String> functions =new ArrayList<String>();
	ArrayList<String> bottom =new ArrayList<String>();
	
	public void writeToFile() 
	{
		FileWriter writer;
		PrintWriter out;
		try {
			 writer = new FileWriter("file.s");
			 out = new PrintWriter(writer);
			for(String str: top) {
			  out.println(str);
			}
			for(String str: middle) {
				 out.print(str);
				}
			for(String str: functions) {
				 out.println(str);
				}
			for(String str: bottom) {
				 out.println(str);
				}
			writer.close();	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	/**
	 * 
	 * @param stringVal - value to print
	 * @param strcount - counter
	 */
	public void lprints(String stringVal, int strcount)
	{
		//middle.add("\tbl\t rtsinit");
		middle.add("\tadr\t r0, msg"+strcount+"\n");
		middle.add("\tbl\t Lprints"+"\n");
		bottom.add("msg"+strcount+":"
		    + "\n\t.asciz\t" + "\""+stringVal+"\"" );
	}
	
	
	/**
	 * To print byte
	 * @param stringVal
	 * @param strcount
	 */
	public void lprintb(String stringVal, int strcount, String register, String stackoffset)
	{
		if(register == null)
		{
			middle.add("\tmov\t r0, #"+stringVal+"\n");
			middle.add("\tbl\t Lprintb"+"\n");
		} else {
			middle.add("\tmov\t r0, "+register+"\n");
			middle.add("\tbl\t Lprintb"+"\n");
		}
		
	}

	
	/**
	 * 
	 * @param stringVal
	 * @param strcount
	 */
	
	public void lprinti(String stringVal, int strcount, String register, String stackoffset, String location)
	{
		//middle.add("\tbl\t rtsinit");
		if(register == null )
		{
			middle.add("\tmov\t r0, #"+stringVal+"\n");
			middle.add("\tbl\t Lprinti"+"\n");
		} else {
			middle.add("\tldr\t" + register +", ["+location+",#"+stackoffset+"]" + "\n");
			middle.add("\tmov\t r0, "+register+"\n");
			middle.add("\tbl\t Lprinti"+"\n");
		}
		
		/*bottom.add("msg"+strcount+":"
		    + "\n\t.asciz\t" + "\""+stringVal+"\"" );*/
	}
	
	public void lprintc(String stringVal, int strcount, String register, String stackoffset)
	{
		//middle.add("\tbl\t rtsinit");
		if(register == null )
		{
		middle.add("\tmov\t r0, '"+stringVal+"'\n");
		middle.add("\tbl\t Lprintc"+"\n");
		} else {
			middle.add("\tldr\t" + register +", [sp,#"+stackoffset+"]" + "\n");
			middle.add("\tmov\t r0, "+register+"\n");
			middle.add("\tbl\t Lprintc"+"\n");
		}
		
		/*bottom.add("msg"+strcount+":"
		    + "\n\t.asciz\t" + "\""+stringVal+"\"" );*/
	}
	
	/**
	 * This will generate a assembly routine
	 * @param nameofFun
	 * @param typeofFun
	 * @param previous - name of previous function
	 */
	public void createRoutine(String nameofFun, String typeofFun, String previous)
	{
		//System.out.println(nameofFun + " " + previous);
		/*if(previous != "Global" && !nameofFun.equals("Main") || previous == null)
		{
			middle.add("\tadd\t sp,#28 \n");
			middle.add("\tldmfd sp!,{r4-r11,pc} \n");
			
			//System.out.println("i am here");
		}*/
		
		if (previous != null )
		{
			middle.add("\tadd\t sp,#28 \n");
			middle.add("\tldmfd sp!,{r4-r11,pc} \n");
			
			//System.out.println("i am here");
		} 
		
		if(nameofFun.equals("Main"))
		{
			middle.add("_start:"+"\n");
			middle.add("\tmov\tr0,#1\n"
					+ "\tlsl\tr0,#20\t\t\t@ 2^20 bytes o' stack, no heap\n"
					+ "\tadd\tsp,r0 \n"        
					+ "\tbl\trtsinit\n"
					+ "\tbl\tM\n"
					+"\tb\tLhalt\n"
					+"M:\n"	);
			middle.add("\tstmfd sp!,{r4-r11,lr} \n");
			middle.add("\t sub sp,#28 \n");
		} else {
			middle.add(nameofFun+":"+"\t\t@ Function"+"\n");		
			middle.add("\tstmfd sp!, {r4-r11,lr} \n");
			middle.add("\tsub sp,#28 \n");
		}
		
		
		
	}
	
	/**
	 * This will create assembly for add operator
	 * @param currentFunction
	 * @param Register0
	 * @param Register1
	 * @param Register2
	 * @param stack
	 */
	public void createAdd(String Register0, String Register1, String Register2, String stack, String oper)
	{
		middle.add("\t"+oper+"\t" + Register0 +", " + Register1 + ", " + Register2 + "\n");
		middle.add("\tstr\t" + Register0 +", [sp,#"+stack+"]" + "\n");
	}
	
	/**
	 * If varable exists it will generate add operation and update the variable
	 * @param Register0
	 * @param Register1
	 * @param Register2
	 * @param stack
	 * @param oper
	 */
	public void loadAdd(String Register0, String Register1, String Register2, String stack, String oper)
	{
		middle.add("\t"+oper+"\t" + Register0 +", " + Register1 + ", " + Register2 + "\n");
		middle.add("\tstr\t" + Register0 +", [sp,#"+stack+"]" + "\n");	
	}
	
	/**
	 * To print the table
	 * @param stringVal
	 * @param strcount
	 */
	public void prints(String stringVal, int strcount)
	{
		middle.add("b	_prints"+strcount);
		middle.add("_prints"+strcount+"end:");
		functions.add("_prints"+strcount+":"
		    + "\n adr     r1, msg"+strcount+"         @ Address"
		    + "\n mov     r0, #1          @ STDOUT"
		    + "\n mov     r2, #"+stringVal.length()+"         @ Length"
		    + "\n mov     r7, #4          @ sys_write"
		    + "\n svc     0x00000000"
		    + "\n b	    _prints"+strcount+"end");
		bottom.add("msg"+strcount+":"
		    + "\n\t.asciz\t" + "\""+stringVal+"\"" );
	}
}
