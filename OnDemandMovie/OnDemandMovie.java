package movies;

public class OnDemandMovie extends movie{
	
	private double price;
	private String last_date_to_rent;
	private int rent_period;
	
	public OnDemandMovie(String ti, String ra, String ge, String di, String st, double pc, String ldtr, int rp) {
		super(ti, ra, ge, di, st);
		price = pc;
		last_date_to_rent = ldtr;
		rent_period = rp;
	}
	/** This method returns values of movie
	 * 
	 * @return		values to for movie values
	 */
	public String toString() {
		return ("Title:        " + gettitle() + "\n" +
		"Rating:       " + getrating() + "\n" +
		"Genre:        " + getgenre() + "\n" +
		"Director:     " + getdirector() + "\n" +
		"Star:         " + getstar() + "\n" + 
		"Price:	      " + price + "\n" + 
		"Last Date to Rent:  " + last_date_to_rent + "\n" +
		"Rent Period:  " + rent_period
		);
	}
	/** This method returns true/false if both movie objects are equal
	 * 
	 * @return		boolean val, comparing two objects
	 */
    public boolean equals(movie x, movie y) {  
        return (x.gettitle() == y.gettitle() && x.getrating() == y.getrating() && x.getgenre() == y.getgenre() 
        		&& x.getdirector() == y.getdirector() && x.getstar() == y.getstar() && 
        		((OnDemandMovie) x).getPrice() == ((OnDemandMovie) y).getPrice() && 
        		((OnDemandMovie) x).getlast_date_to_rent() == ((OnDemandMovie) y).getlast_date_to_rent() &&
        		((OnDemandMovie) x).getrent_period() == ((OnDemandMovie) y).getrent_period());
    } 
	/** This method returns price
	 * 
	 * @return	price
	 */
	public double getPrice() {
		return price;
	}
	/** This method returns last_date_to_rent
	 * 
	 * @return	last_date_to_rent	
	 */
	public String getlast_date_to_rent() {
		return last_date_to_rent;
	}
	/** This method sets price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/** This method sets last_date_to_rent
	 */
	public void setlast_date_to_rent(String last_date_to_rent) {
		this.last_date_to_rent = last_date_to_rent;
	}
	/** This method returns rent_period
	 * 
	 * @return	last_date_to_rent	
	 */
	public int getrent_period() {
		return rent_period;
	}
	/** This method sets rent_period
	 */
	public void setrent_period(int rent_period) {
		this.rent_period = rent_period;
	}
}