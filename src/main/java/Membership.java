import java.util.HashMap;
import java.util.Map;

public class Membership {
    HashMap<Integer,Customer> customers = new HashMap<Integer, Customer>();

    public void addCustomer(Customer customer) {
        customers.put((getNumberOfCustomers()+1),customer);
    }

    public int getNumberOfCustomers(){
        return customers.size();
    }
}
