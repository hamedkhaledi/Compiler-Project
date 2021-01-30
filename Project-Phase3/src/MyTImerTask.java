import AST.Program;
import codegen.CodeGenVisitor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.TimerTask;

public class MyTImerTask extends TimerTask {
    @Override
    public void run() {
        try {
            PrintStream stream = new PrintStream(new FileOutputStream("src/Tests/Result.ll"));
            Program cu = Compiler.parse();
            Compiler.vtableAnalysis(cu);
            Compiler.generateCode(cu, stream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
