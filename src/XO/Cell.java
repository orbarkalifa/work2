package XO;

public class Cell implements Comparable{

    private int row,col;

    public Cell(int x, int y){
        row=x;
        col=y;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }


    @Override
    public int compareTo(Object o) {
        Cell other = (Cell) o;
        if(row==other.getRow() && col == other.getCol()) return 0;
        return -1;
    }
}
