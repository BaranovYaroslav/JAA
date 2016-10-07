package CompressionAlgorithms;

import java.util.*;

public class HuffmanCoding {

    private String alphabet;

    private ArrayList<HuffmanTreeNode> huffmanTreeSymbolsNodes;

    private HashMap<SymbolCode, Character> codes;

    private HuffmanTreeNode huffmanTreeRoot;

    private Queue<HuffmanTreeNode> huffmanTreeNodesQueue = new PriorityQueue<HuffmanTreeNode>(new Comparator<HuffmanTreeNode>() {
        @Override
        public int compare(HuffmanTreeNode o1, HuffmanTreeNode o2) {
            return o1.getEntries() - o2.getEntries();
        }
    });

    private String encodedString;

    public HuffmanCoding(){
        huffmanTreeSymbolsNodes = new ArrayList<HuffmanTreeNode>();
        codes = new HashMap<SymbolCode, Character>();
        huffmanTreeRoot = new HuffmanTreeNode();
    }

    public HuffmanCoding(String alphabet){
        this.alphabet = alphabet;
        huffmanTreeSymbolsNodes = new ArrayList<HuffmanTreeNode>();
        codes = new HashMap<SymbolCode, Character>();
        huffmanTreeRoot = new HuffmanTreeNode();
        loadAlphabet(alphabet);
    }

    public void loadAlphabet(String alphabet){

        this.alphabet = alphabet;
        createSymbolsNodes();
        createHuffmanTree();
        defineCodes();

    }

    private void createSymbolsNodes(){
        for (int i = 0; i < alphabet.length(); i++) {
            HuffmanTreeNode temp = new HuffmanTreeNode(alphabet.charAt(i), 1);
            if(!huffmanTreeSymbolsNodes.contains(temp)){
                huffmanTreeSymbolsNodes.add(temp);
            }
            else{
                for (HuffmanTreeNode node: huffmanTreeSymbolsNodes){
                    if(node.equals(temp)){
                        node.setEntries(node.getEntries() + 1);
                    }
                }
            }
        }

        for(HuffmanTreeNode node: huffmanTreeSymbolsNodes){
            huffmanTreeNodesQueue.add(node);
        }
    }

    private void createHuffmanTree(){
        while(huffmanTreeNodesQueue.size() != 1){
            huffmanTreeNodesQueue.add(new HuffmanTreeNode(huffmanTreeNodesQueue.poll(), huffmanTreeNodesQueue.poll()));
        }

        huffmanTreeRoot = huffmanTreeNodesQueue.peek();
    }

    private void defineCodes(){
        for(HuffmanTreeNode node: huffmanTreeSymbolsNodes){
            HuffmanTreeNode tempNode = huffmanTreeNodesQueue.peek();
            SymbolCode code = new SymbolCode();
            while(!tempNode.getData().equals(node.getData())){
                if(tempNode.getLeftNode().getData().contains(node.getData())){
                    tempNode = tempNode.getLeftNode();
                    code.add(false);
                }
                else{
                    tempNode = tempNode.getRightNode();
                    code.add(true);
                }
            }
            codes.put(code, node.getData().charAt(0));
        }
    }

    public EncodedData encode(String inputString){
        ArrayList<SymbolCode> encoded = new ArrayList<SymbolCode>();
        for (int i = 0; i < inputString.length(); i++) {
            for(Map.Entry<SymbolCode, Character> entry: codes.entrySet()){
                if(entry.getValue().equals(inputString.charAt(i))){
                    encoded.add(entry.getKey());
                }
            }
        }
        return new EncodedData(encoded);
    }

    public String decode(EncodedData encodedData){

        String encoded = "";

        for(SymbolCode symbolCode: encodedData.getData()){
            HuffmanTreeNode temp = huffmanTreeRoot;
            for (Boolean b: symbolCode.getCode()){
                if(b){
                    temp = temp.getRightNode();
                }
                else{
                    temp = temp.getLeftNode();
                }
            }
            encoded += temp.getData();
        }
        return encoded;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public ArrayList<HuffmanTreeNode> getHuffmanTreeSymbolsNodes() {
        return huffmanTreeSymbolsNodes;
    }

    public void setHuffmanTreeSymbolsNodes(ArrayList<HuffmanTreeNode> huffmanTreeSymbolsNodes) {
        this.huffmanTreeSymbolsNodes = huffmanTreeSymbolsNodes;
    }

    public HashMap<SymbolCode, Character> getCodes() {
        return codes;
    }

    public void setCodes(HashMap<SymbolCode, Character> codes) {
        this.codes = codes;
    }

    public String getEncodedString() {
        return encodedString;
    }

    public void setEncodedString(String encodedString) {
        this.encodedString = encodedString;
    }


    public HuffmanTreeNode getRoot() {
        return huffmanTreeRoot;
    }

    public void setRoot(HuffmanTreeNode root) {
        this.huffmanTreeRoot = root;
    }

    private class HuffmanTreeNode {

        private String data = "";

        private int entries;

        private HuffmanTreeNode leftNode;

        private HuffmanTreeNode rightNode;

        public HuffmanTreeNode(){}

        public HuffmanTreeNode(String data, int entries){
            this.data = data;
            this.entries = entries;
        }

        public HuffmanTreeNode(char data, int entries){
            this.data += data;
            this.entries = entries;
        }

        public HuffmanTreeNode(HuffmanTreeNode left, HuffmanTreeNode right){
            data = left.getData() + right.getData();
            entries = left.getEntries() + right.getEntries();
            leftNode = left;
            rightNode = right;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getEntries() {
            return entries;
        }

        public void setEntries(int entries) {
            this.entries = entries;
        }
        public HuffmanTreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(HuffmanTreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public HuffmanTreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(HuffmanTreeNode rightNode) {
            this.rightNode = rightNode;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()){
                return false;
            }

            boolean equals = false;
            if (this == o){
                equals = true;
            }

            HuffmanTreeNode that = (HuffmanTreeNode) o;

            if (data.equals(that.data)) {
                equals = true;
            }

            return equals;
        }

        @Override
        public String toString() {
            return data + ": " + entries;
        }
    }
}
