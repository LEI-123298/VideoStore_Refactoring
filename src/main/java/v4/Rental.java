package v4;

public class Rental
{
	private Movie	_movie;
	private int		_daysRented;

	public Rental(Movie movie, int daysRented)
	{
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented()
	{
		return _daysRented;
	}

	public Movie getMovie()
	{
		return _movie;
	}

	public double getAmount() {
		return switch (getMovie().getPriceCode()) {
			case REGULAR -> calculateRegularAmount();
			case NEW_RELEASE -> calculateNewReleaseAmount();
			case CHILDRENS -> calculateChildrensAmount();
		};
	}

	private double calculateRegularAmount() {
		double result = 2;
		if (getDaysRented() > 2)
			result += (getDaysRented() - 2) * 1.5;
		return result;
	}

	private double calculateNewReleaseAmount() {
		return getDaysRented() * 3;
	}

	private double calculateChildrensAmount() {
		double result = 1.5;
		if (getDaysRented() > 3)
			result += (getDaysRented() - 3) * 1.5;
		return result;
	}


	public int getFrequentRentalPoints()
	{
		return (getMovie().getPriceCode() == Movie.Code.NEW_RELEASE) && getDaysRented() > 1 ? 2 : 1;
	}
}
