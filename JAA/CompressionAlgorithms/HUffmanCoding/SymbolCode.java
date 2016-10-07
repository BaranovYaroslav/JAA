package CompressionAlgorithms;
import java.util.ArrayList;
import java.util.Arrays;

public class SymbolCode {

    private boolean[] code;

    public SymbolCode(){
        code = new boolean[0];
    }

    public void add(boolean b){
        boolean[] temp = code;
        code = new boolean[code.length+1];
        System.arraycopy(temp, 0, code, 0, temp.length);
        code[code.length-1] = b;
    }

    public boolean[] getCode() {
        return code;
    }

    public void setCode(boolean[] code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return Arrays.toString(code);
    }
}
