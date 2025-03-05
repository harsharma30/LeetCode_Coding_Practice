class Solution {

    public long coloredCells(int n) {
        long numBlueCells = 1;
        int addend = 4;

        while (--n > 0) {
            numBlueCells += addend;
            addend += 4;
        }
        return numBlueCells;
    }
}