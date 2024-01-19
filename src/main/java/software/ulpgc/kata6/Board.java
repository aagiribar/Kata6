package software.ulpgc.kata6;

class Board {
    private final String state;

    public Board(String initialState) {
        this.state = initialState;
    }

    private int getNumberOfRows() {
        return state.split("\\n").length;
    }

    private int getNumberOfCols() {
        return state.split("\\n")[0].length();
    }

    public Board next() {
        StringBuilder nextState = new StringBuilder();
        for (int i = 0; i < getNumberOfRows(); i++) {
            for (int j = 0; j < getNumberOfCols(); j++) {
                if(isAliveInNextGen(i, j)) {
                    nextState.append("X");
                }
                else {
                    nextState.append(".");
                }
            }
            nextState.append("\n");
        }
        return new Board(nextState.toString().trim());
    }

    private boolean isAliveInNextGen(int i, int j) {
        int aliveNeighbours = countAliveNeighbours(i, j);
        if (getCellStatus(i, j)) {
            return aliveNeighbours >= 2 && aliveNeighbours <= 3;
        }
        else {
            return aliveNeighbours == 3;
        }
    }

    private boolean getCellStatus(int i, int j) {
        String[] rows = state.split("\\n");
        if (i < 0 || j < 0) return false;
        if (i >= rows.length || j >= rows[0].length()) return false;
        char cell = rows[i].charAt(j);
        return cell == 'X';
    }

    private int countAliveNeighbours(int i, int j) {
        int upperNeighbours = 0;
        for (int k = 0; k <= 2; k++) {
            if (getCellStatus(i - 1, j - 1 + k)) {
                upperNeighbours++;
            }
        }

        int middleNeighbours = 0;
        for (int k = 0; k <= 2; k = k + 2) {
            if (getCellStatus(i, j - 1 + k)) {
                middleNeighbours++;
            }
        }

        int lowerNeighbours = 0;
        for (int k = 0; k <= 2; k++) {
            if (getCellStatus(i + 1, j - 1 + k)) {
                lowerNeighbours++;
            }
        }
        return upperNeighbours + middleNeighbours + lowerNeighbours;
    }

    @Override
    public String toString() {
        return this.state;
    }
}
