package sanuj.finessy.admin.QueriesSQL;

public interface BestMarketSQL {
	
	String ADD_BEST_MARKET = "INSERT INTO best_market(field_id, country_id) VALUES (?,?);";
	
	String READ_ALL_BEST_MARKET = "SELECT * FROM best_market;";
	
	String READ_BEST_MARKET = "SELECT * FROM best_market WHERE field_id=?;";

	String UPDATE_BEST_MARKET = "UPDATE best_market SET country_id=? WHERE field_id=?;";
	
	String DELETE_BEST_MARKET = "DELETE FROM best_market WHERE field_id=?;";

}
