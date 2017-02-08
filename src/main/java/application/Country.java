package application;

public enum Country {
    UNITED_KINGDOM("UK"),
    REPUBLIC_OF_IRELAND("ROI");

    private String countryCode;

    Country(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
