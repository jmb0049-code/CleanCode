import java.util.ArrayList;
import java.util.List;

public class OrderProcessor
{
    // 1. FIXED TEMPORARY FIELD: Removed temporaryDiscountValue.
    // 2. FIXED DEAD CODE: Removed unusedCounter because it wasn't doing anything.

    // 3. FIXED LONG METHOD: process is shorter and delegates tasks.
    public void process(Order order, User user)
    {
        double finalPrice = calculatePrice(order);
        // 6. FIXED FEATURE ENVY: Logic separated into a unique method.
        notifyUser(user, finalPrice);
        // 7. FIXED DUPLICATE CODE: Reuse the logic for the audit.
        logAudit(order);
    }

    // 4. FIXED DUPLICATE CODE: Single method for the core calculation.
    private double calculatePrice(Order order)
    {
        double total = order.getQty() * order.getPrice();
        double totalWithTax = applyTax(total);

        // 5. FIXED SWITCH STATEMENT: Logic moved to Order class (Polymorphism/Logic move).
        return order.applyDiscount(totalWithTax);
    }

    private void notifyUser(User user, double price)
    {
        if (user.getEmail().contains("@"))
        {
            System.out.println("Sending email to " + user.getEmail());
            System.out.println("Total: " + price);
        }
    }

    private void logAudit(Order order)
    {
        // Reuse calculation instead of repeating qty * price * 1.21
        double auditTotal = applyTax(order.getQty() * order.getPrice());
        System.out.println("Audit log: " + auditTotal);
    }

    // 8. FIXED INAPPROPRIATE INTIMACY & 9. LARGE CLASS:
    // Instead of touching 'user.address' directly, we call a method on User.
    public void intimateAccess(User user)
    {
        user.updateProfile("New Street", "999");
    }

    // 10. FIXED SHOTGUN SURGERY: Centralized tax calculation.
    private double applyTax(double amount)
    {
        return amount * 1.21;
    }
}

// Fixed DIVERGENT CHANGE: User now controls its own data.
class User
{
    private String address;
    private String internalID;
    private String email;

    // CONSTRUCTOR ADAPTADO PARA EL TEST
    public User(String email)
    {
        this.email = email;
    }

    public String getEmail() { return email; }

    // Fix for Smells 8 & 9: Encapsulation
    public void updateProfile(String address, String internalID) {
        this.address = address;
        this.internalID = internalID;
    }
}

    // Helper class to organize data (Fixes Large Class / Long Parameter List)
    class Order {
        private String item;
        private int qty;
        private double price;
        private String type;

    // Constructor adapted to the test
    public Order(String item, int qty, double price, String type) {
        this.item = item;
        this.qty = qty;
        this.price = price;
        this.type = type;
    }

    public int getQty() { return qty; }
    public double getPrice() { return price; }

    // Fix for 5. SWITCH STATEMENT: The object decides its own discount.
    public double applyDiscount(double total) {
        if ("ELECTRONICS".equals(type)) return total - 10;
        if ("CLOTHES".equals(type)) return total - 5;
        return total;
    }
}
