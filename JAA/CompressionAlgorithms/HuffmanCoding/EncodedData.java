package CompressionAlgorithms;

import java.util.ArrayList;

// Container of codes for characters
public class EncodedData{

    private ArrayList<SymbolCode> data;

    public EncodedData(){
        data = new ArrayList<SymbolCode>();
    }

    public EncodedData(ArrayList<SymbolCode> data){
        this.data = data;
    }

    public ArrayList<SymbolCode> getData() {
        return data;
    }

    public void setData(ArrayList<SymbolCode> data) {
        this.data = data;
    }
}
