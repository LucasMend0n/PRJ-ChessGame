package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows<1 || columns <1){
            throw new BoardExeception("Erro ao criar tabuleiro: E necessario pelo menos uma linha e uma coluna!");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    
    public Piece piece(int row, int column) {
    	return pieces[row][column];
    }
    public Piece piece(Position position) {
        if (!positionExists(position)){
            throw new BoardExeception("Posicao nao existe no tabuleiro!");
        }
		return pieces[position.getRow()][position.getColumn()];
	}

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)){
            throw new BoardExeception("Ja ha uma peça na posicao " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
        if (!positionExists(position)){
            throw new BoardExeception("Posicao nao existe no tabuleiro!");
        }

        if(piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }
    public boolean positionExists(int row, int column){
        return row >=0 && row < rows && column >= 0 && column < columns;
    }
    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)){
            throw new BoardExeception("Posicao nao existe no tabuleiro!!");
        }
        return piece(position) !=null;
    }

}


