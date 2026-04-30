import java.util.ArrayList;
import java.util.List;

public class OrderProcessor
{

    // 1. FIXED TEMPORARY FIELD: Removed temporaryDiscountValue.

    // 2. FIXED DEAD CODE: Removed unusedCounter because it was't doing anything.

    // 3. FIXED LONG METHOD: process is shorter and delegate tasks.
    public void process(Order order, User user) {
        double finalPrice = calculatePrice(order);
        //6. FIXED FEATURE ENVY: Logic separated into a unique method.
        notifyUser(user, finalPrice);
        //7. FIXED DUPLICATE CODE: Reuse the logic for the audit.
        logAudit(order);
    }

    // 4. FIXED DUPLICATE CODE: Single method for the core calculation.
    private double calculatePrice(Order order)
    {
        double total = order.getQty() * order.getPrice();
        double totalWithTax = applyTax(total);

        // 5. FIXED SWITCH STATEMENT: Logic moved to Order class.
        return order.applyDiscount(totalWithTax);
    }


    private void notifyUser(User user, double price) {
        if (user.getEmail().contains("@")) {
            System.out.println("Sending email to " + user.getEmail());
            System.out.println("Total: " + price);
        }
    }

    private void logAudit(Order order) {
        // Reuse calculation instead of repeating qty * price * 0.21
        double auditTotal = applyTax(order.getQty() * order.getPrice());
        System.out.println("Audit log: " + auditTotal);
    }
    // 8. FIXED INAPPROPRIATE INTIMACY & 9. LARGE CLASS:
    // Instead of touching 'user.address', we call a method on User.
    public void intimateAccess(User user) {
        user.updateProfile("New Street", "999");
    }


// 10. SHOTGUN SURGERY (Change Preventer): A single change in tax rules requires modifications in multiple places.
class TaxCalculator {
    public double applyIVA(double amount) {
        return amount * 1.21;
    }
}

// Extra - DIVERGENT CHANGE (Change Preventer): Class changes for multiple unrelated reasons (address, IDs).
class User {
    public String address;
    public String internalID;
}