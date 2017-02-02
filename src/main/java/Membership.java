import java.util.HashMap;

public class Membership {
    HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();

    public void addCustomer(Customer customer) {
        customers.put((getNumberOfCustomers() + 1), customer);
    }

    public int getNumberOfCustomers() {
        return customers.size();
    }

    public void listCustomerIdAndNames() {
        for (Customer customer : customers.values()) {
            System.out.println(customer.getSurname() + "," + customer.getFirstName());
        }
    }
}
