package application.enumerators;

public enum Gender {
    MALE("M"),
    FEMALE("F"),
    OTHER("X");

    private String genderCode;

    Gender(String genderCode) {
        this.genderCode = genderCode;
    }

    public static Gender lookup(String genderCode){
        for (Gender element : Gender.values()){
            if (genderCode.equals(element.genderCode)) return element;
        }
        return Gender.OTHER;
    }
}
