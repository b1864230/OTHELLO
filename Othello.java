public class Othello {
	private int row = 8;	//オセロ版の縦横マス数(2の倍数のみ)
	private int black, white; //石の数
	private String [] grids = new String [row * row]; //局面情報
	private String turn; //手番

	// コンストラクタ
	public Othello(){
		turn = "black"; //クロが先手
		for(int i = 0 ; i < row * row ; i++){
			grids[i] = "board"; //始めは石が置かれていない
			int center = row * row / 2;
			grids[center - row / 2 - 1] = "black";
			grids[center + row / 2    ] = "black";
			grids[center - row / 2    ] = "white";
			grids[center + row / 2 - 1] = "white";
		}
	}

	// メソッド
	public String checkWinner(){	// 勝敗を判断
		if(black > white) return "black";
		else if(black < white) return "white";
		else return "draw";
	}
	public String getTurn(){ // 手番情報を取得
		return turn;
	}
	public String [] getGrids(){ // 局面情報を取得
		return grids;
	}
	public int getBlack() {
		black = 0;//カウントリセット
		for(int i = 0; i < row * row; i++) {
			if(grids[i] == "black") black++;//gridsの中身がblackならインクリメント
		}
		return black;//出力
	}
	public int getWhite() {
		white = 0;
		for(int i = 0; i < row * row; i++) {
			if(grids[i] == "white") white++;
		}
		return white;
	}
	public void changeTurn(){ //手番を変更
		if(turn == "black") turn = "white";//turnがblackなら反対に
		else turn = "black";
	}
	public boolean isGameover(){	// 対局終了を判断
		return true;
	}
	public boolean putStone(int i, String color, boolean effect_on){ // (操作を)局面に反映
		if(grids[i] == "board") grids[i] = color;//gridsがboardなら置く
		else return false;
		return true;
	}
	public int getRow(){ //縦横のマス数を取得
		return row;
	}
}