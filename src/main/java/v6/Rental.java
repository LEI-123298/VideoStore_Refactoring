package v6;

public class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie m1, int daysRented) {
		_movie = m1;
		_daysRented = daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	// Now delegates to Movie, no more Feature Envy
	public double getRentalAmount() {
		return _movie.getRentalAmount(_daysRented);
	}

	public int getFrequentRentalPoints() {
		return _movie.getFrequentRenterPoints(_daysRented);
	}
}
