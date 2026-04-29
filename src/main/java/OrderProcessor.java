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



    // 8. INAPPROPRIATE INTIMACY (Coupler): Accessing private-like data of another class directly.
    // 9. LARGE CLASS (Bloater): This class is handling too many different responsibilities.
    public void intimateAccess(User user) {
        user.address = "New Street";
        user.internalID = "999";
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