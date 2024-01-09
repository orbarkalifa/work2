package XO;

public class Cell {

    private char type = '_';
    private int i,j;

    public Cell(int x, int y){
        i=x;
        j=y;
    }
    public Cell get(){
        return this;
    }

    public char getChar() {
        return type;
    }
}
