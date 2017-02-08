package application;

public enum Gender {
    MALE("M"),
    FEMALE("F"),
    OTHER("X");

    private String genderCode;

    Gender(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getGenderCode() {
        return genderCode;
    }
}
