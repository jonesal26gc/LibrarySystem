import java.util.HashMap;

public class Membership {
    private HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();

    public int getNumberOfCustomers() {
        return customers.size();
    }

    public Customer addCustomer(Customer customer) {
        customer.setNumber(findNextCustomerNumber());
        customers.put(customer.getNumber(), customer);
        return customer;
    }

    public int findNextCustomerNumber() {
        for (int number = 1; true; number++) {
            if (!customers.containsKey(number)) {
                return number;
            }
        }
    }

    public void listCustomers() {
        for (Customer customer : customers.values()) {
            System.out.println(customer.toString());
        }
    }
}