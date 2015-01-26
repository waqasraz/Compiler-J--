import java.io.FileReader;
import java_cup.runtime.Symbol;
import AST.*;

/**
 * 
 * @author Waqas Razzaq ID: 10033867
 */
public class jmm {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {

		try {
			jmmScanner scanner = new jmmScanner(new FileReader(
					(args.length != 0) ? args[0]
							: "/home/waqas/git/Project/jmm/TEST/final/gen.t5"));

			parser p = new parser(scanner);

			Symbol s = p.parse();

			if (s != null) {
				SyntaxNode sn = (SyntaxNode) s.value;
				// System.out.println(s.value);
				System.out.println("File succesfully parsed");

				JmmVisitor av = new JmmVisitor();
				sn.traverseBottomUp(av);
				// System.out.println("expression value is: "+av.getResult());
				//av.map.getTable();

				av.generate.top.add(".text");
				// av.generate.top.add(".align 2");
				av.generate.top.add(".global _start");
				av.generate.middle.add("\tadd sp,#28 \n");
				av.generate.middle.add("\tldmfd sp!, {r4-r11,pc} \n");
				/*
				 * av.generate.middle.add( "\tmov\t r0, #0x18	@ SYS_EXIT\n" +
				 * "\tsvc\t 0x00123456"+"\n");
				 */
				av.generate.bottom.add("\n");
				av.generate.writeToFile();
				
				 runner r = new runner();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
