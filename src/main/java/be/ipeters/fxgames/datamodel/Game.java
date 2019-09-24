package be.ipeters.fxgames.datamodel;

public class Game {
	private Integer id;
	private String gameName;
	private String editor;
	private String author;
	private Integer yearEdition;
	private String age;
	private Integer minPlayers;
	private Integer maxPlayers;
	private Integer categoryId;
	private String category;
	private String duration;
	private Integer difficultyId;
	private String difficulty;
	private double price;
	private String image;
	
	public Game() {
		super();
	}
	
	public Game(String gameName, String editor, double price) {
		super();
		this.gameName = gameName;
		this.editor = editor;
		this.price = price;
	}

	public Game(Integer id, String gameName, String editor, String author, Integer yearEdition, String age,
                Integer minPlayers, Integer maxPlayers, String category, String duration, String difficulty, double price) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.editor = editor;
		this.author = author;
		this.yearEdition = yearEdition;
		this.age = age;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.category = category;
		this.duration = duration;
		this.difficulty = difficulty;
		this.price = price;
	}

	public Game(Integer id, String gameName, String editor, String author, Integer yearEdition, String age,
                Integer minPlayers, Integer maxPlayers, Integer categoryId, String duration, Integer difficultyId,
                double price) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.editor = editor;
		this.author = author;
		this.yearEdition = yearEdition;
		this.age = age;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.categoryId = categoryId;
		this.duration = duration;
		this.difficultyId = difficultyId;
		this.price = price;
	}

	public Game(Integer id, String gameName) {
		super();
		this.id = id;
		this.gameName = gameName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getYearEdition() {
		return yearEdition;
	}

	public void setYearEdition(Integer yearEdition) {
		this.yearEdition = yearEdition;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getMinPlayers() {
		return minPlayers;
	}

	public void setMinPlayers(Integer minPlayers) {
		this.minPlayers = minPlayers;
	}

	public Integer getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(Integer maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getDifficultyId() {
		return difficultyId;
	}

	public void setDifficultyId(Integer difficultyId) {
		this.difficultyId = difficultyId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Game [\tgameName= " + gameName + ", editor= " + editor + ", \n\tauthor=" + author + ", yearEdition="
				+ yearEdition + ", \n\tage=" + age + ", minPlayers=" + minPlayers + ", maxPlayers=" + maxPlayers
				+ ", category=" + category + ", \n\tduration=" + duration + ", difficulty=" + difficulty
				+ ", price=" + price + "� ]";
	}

	public String toSmallString() {
		return "Game [id= " + id + ", gameName= " + gameName + "]";
	}
	public String toStringAllGames() {
		return "Game [gameName= " + gameName + ", editor= " + editor + ", price= " + price + "� ]";
	}
}