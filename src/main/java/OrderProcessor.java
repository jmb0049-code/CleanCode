import java.util.ArrayList;
import java.util.List;

/**
 * 2. TECHNICAL REQUIREMENTS: This class contains 10 code smells to be refactored.
 */
public class OrderProcessor {

    // 1. TEMPORARY FIELD (OO Abuser): Variable used only in one specific method, polluting the class scope.
    private double temporaryDiscountValue;

    // 2. DEAD CODE (Dispensable): Unused variable that increases complexity without adding value.
    private int unusedCounter = 0;

    // 3. LONG METHOD (Bloater): This method is doing too many things (calculating, printing, and logic).
    public void process(String item, int qty, double price, String type, String email) {

        // 4. DUPLICATE CODE (Dispensable): This calculation logic is repeated further down.
        double total = qty * price;
        double tax = total * 0.21;
        double finalPrice = total + tax;

        // 5. SWITCH STATEMENT (OO Abuser): Hardcoded logic that should be replaced with Polymorphism.
        switch (type) {
            case "ELECTRONICS":
                finalPrice -= 10;
                break;
            case "CLOTHES":
                finalPrice -= 5;
                break;
        }

        // 6. FEATURE ENVY (Coupler): Method is more interested in the 'System.out' class than its own.
        if (email.contains("@")) {
            System.out.println("Sending email to " + email);
            System.out.println("Total: " + finalPrice);
        }

        // 7. DUPLICATE CODE (Dispensable): Repeating exactly the same calculations from above.
        double total2 = qty * price;
        double tax2 = total2 * 0.21;
        System.out.println("Audit log: " + (total2 + tax2));
    }

    // 8. INAPPROPRIATE INTIMACY (Coupler): Accessing private-like data of another class directly.
    // 9. LARGE CLASS (Bloater): This class is handling too many different responsibilities.
    public void intimateAccess(User user) {
        user.address = "New Street";
        user.internalID = "999";
    }
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