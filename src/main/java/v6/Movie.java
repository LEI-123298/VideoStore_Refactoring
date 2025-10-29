package v6;

public class Movie {

	public enum Code {REGULAR, CHILDRENS, NEW_RELEASE}

	private String _title;
	private Code _priceCode;

	public Movie(String title, Code priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public String getTitle() {
		return _title;
	}

	public Code getPriceCode() {
		return _priceCode;
	}

	// NEW: calculates rental amount based on days rented
	public double getRentalAmount(int daysRented) {
		double result = 0;
		switch (_priceCode) {
			case REGULAR:
				result += 2;
				if (daysRented > 2)
					result += (daysRented - 2) * 1.5;
				break;
			case NEW_RELEASE:
				result += daysRented * 3;
				break;
			case CHILDRENS:
				result += 1.5;
				if (daysRented > 3)
					result += (daysRented - 3) * 1.5;
				break;
		}
		return result;
	}

	// NEW: calculates frequent renter points
	public int getFrequentRenterPoints(int daysRented) {
		return (_priceCode == Code.NEW_RELEASE && daysRented > 1) ? 2 : 1;
	}
}
