package Converter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class AS32J {
    static public String getContents(File file) {
        StringBuffer contents = new StringBuffer();
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            try {
                String line = null;
                while (( line = input.readLine()) != null){
                    contents.append(line);
                    contents.append(System.getProperty("line.separator"));
                }
            } finally {
                input.close();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return contents.toString();
    }

//    public static void main(String [] args) {
//        if (args.length!=1) {
//            System.out.println("\n Usage: java -jar as32j.jar <sourcefile>\n");
//            System.exit(0);
//        }
//        String f = getContents(new File(args[0]));
//        convert(f);
//    }

	public static String convert(String f) {

        // get rid of override keyword
        f=f.replaceAll("override","");
        // constructors
        f=f.replaceAll("([a-z]*)\\s+function\\s+(\\w*)\\s*\\Q(\\E\\s*"
                +"([^)]*)"
                +"\\s*\\Q)\\E(\\s*\\{)","$1 $2(%#$3%#)$4");
        // functions
        f=f.replaceAll("([a-z]*)\\s+function\\s+(\\w*)\\s*\\Q(\\E\\s*"
                +"([^)]*)"
                +"\\s*\\Q)\\E\\s*:\\s*(\\w*)","$1 $4 $2(%#$3%#)");
        // remove zero parameter marks
        f=f.replaceAll("%#\\s*%#", "");
        // Now, replace unprocessed parameters
        for (int i=0; i<9; i++) {
            // w/o default values
            f=f.replaceAll("%#\\s*(\\w*)\\s*:\\s*(\\w*)\\s*,", "$2 $1,%#");
            f=f.replaceAll("%#\\s*(\\w*)\\s*:\\s*(\\w*)\\s*%#", "$2 $1");
            // w/ default values
            f=f.replaceAll("%#\\s*(\\w*)\\s*:\\s*(\\w*)\\s*=\\s*([^):,]*)\\s*,",
                    "$2 $1=$3,%#");
            f=f.replaceAll("%#\\s*(\\w*)\\s*:\\s*(\\w*)\\s*=\\s*([^):,]*)\\s*%#"
                    , "$2 $1=$3");
        }

        // === variable declarations ===
        f=f.replaceAll("var\\s+([a-zA-Z0-9_]*)\\s*:\\s*([a-zA-Z0-9_]*)","$2 $1");

        // === type translation ===
        f=f.replaceAll("Number","double");
        f=f.replaceAll("Boolean","boolean");

        f=f.replaceAll("(\\w+)\\s+as\\s+(\\w+)","($2)$1");
        f=f.replaceAll("int\\s*\\Q(\\E([^)]+)\\Q)\\E","((int)$1)");
       
        return f;
		
	}
}