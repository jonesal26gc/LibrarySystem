public class Library {
    private String name;
    private Address address;
    private Membership memberShip = new Membership();

    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void enroll(Customer customer) {
        memberShip.addCustomer(customer);
    }

    public int findNumberOfMembers() {
        return memberShip.getNumberOfCustomers();
    }

    public Membership getMemberShip() {
        return memberShip;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", memberShip=" + memberShip +
                '}';
    }
}
