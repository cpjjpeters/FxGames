package be.ipeters.fxgames.dbutils;

// abstract because we do not need an instance of DBQueries, only the Strings, representing the queries

public abstract class DBQueries {
	public final static String FIND_ALL_GAMES = "SELECT game.game_name,game.editor,game.author,game.price from GAMES.game";
	
	public final static String FIND_ALL_BORROWED_GAMES = "SELECT borrow.id,game.game_name,borrower.borrower_name,borrow.borrow_date,borrow.return_date"+
			" FROM game	INNER JOIN borrow ON game.id = borrow.game_id"+
			" INNER JOIN borrower ON borrow.borrower_id = borrower.id";
	
	public final static String FIND_ALL_BORROWED_GAMES_PER_BORROWER = "SELECT borrow.id,game.game_name,borrower.id,borrower.borrower_name,borrow.borrow_date,borrow.return_date"+
			" FROM game	INNER JOIN borrow ON game.id = borrow.game_id"+
			" INNER JOIN borrower ON borrow.borrower_id = borrower.id"+
			" WHERE borrower.id = ? ";
	
	
	public final static String FIND_ALL_BORROWED_GAMES_SORTED_ON_GAME = "SELECT borrow.id,game.game_name,borrower.borrower_name,borrow.borrow_date,borrow.return_date"+
			" FROM game	INNER JOIN borrow ON game.id = borrow.game_id"+
			" INNER JOIN borrower ON borrow.borrower_id = borrower.id"+
			" order by game.game_name";
	
	public final static String FIND_ALL_BORROWED_GAMES_SORTED_ON_BORROWER = "SELECT borrow.id,game.game_name,borrower.borrower_name,borrow.borrow_date,borrow.return_date"+
			" FROM game	INNER JOIN borrow ON game.id = borrow.game_id"+
			" INNER JOIN borrower ON borrow.borrower_id = borrower.id"+
			" order by borrower.borrower_name";
	
	public final static String FIND_GAME_BY_ID = "SELECT game.id, game.game_name FROM game WHERE game.id = ?";
	
	public final static String FIND_CATEGORY_BY_ID = "SELECT * FROM category WHERE id = ?";
	
	public final static String FIND_BORROWER_BY_ID = "SELECT * FROM borrower WHERE id = ?";
	
	public final static String LOOK_FOR_A_BORROWER = "SELECT * FROM borrower WHERE borrower_name LIKE ?";
	
	public final static String LOOK_FOR_A_GAME = "SELECT * FROM game WHERE game_name LIKE ?";
	
	public final static String LOOK_FOR_A_SPECIFIC_GAME="SELECT game.id,game.game_name FROM game WHERE game_name like ?";
	
	public final static String FIND_ALL_DETAILS_GAME_BY_ID="SELECT game.id,game.game_name,game.editor,game.author,game.year_edition,game.age,game.min_players,game.max_players,category.category_name,\r\n" + 
			"			difficulty.difficulty_name,game.price,game.play_duration FROM category 	INNER JOIN game ON category.id = game.category_id\r\n" + 
			"			INNER JOIN difficulty ON game.difficulty_id = difficulty.id where game.id = ?";
	
	public final static String SELECT_DIFFICULTY_GAMES = "SELECT\r\n" + 
			"difficulty.difficulty_name,game.game_name,game.editor\r\n" + 
			"FROM difficulty\r\n" + 
			"INNER JOIN game ON difficulty.id = game.difficulty_id\r\n" + 
			"where difficulty.id > ?";
}
