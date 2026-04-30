# Project: Clean Code & Automation Cycle
**Course:** Advanced Programming - Term 3  
**Status:** 100% Green (Selenium Validated)

## 1. Project Objective
The goal of this project is to identify and resolve at least 10 different code smells in a legacy Java application using professional refactoring techniques in IntelliJ IDEA, while ensuring functional stability through automated Selenium tests.

---

## 2. Refactoring Log: The 10 Code Smells Fixed

### I. Bloaters
1. **Long Method (`process`):** The original `process` method was performing too many tasks (calculating, printing, auditing).  
   *   **Solution:** Applied **Extract Method** to delegate responsibilities to smaller, specialized methods.
2. **Large Class (`OrderProcessor`):** The class was handling order logic, user data, and auditing.  
   *   **Solution:** Created dedicated `Order` and `User` classes to distribute responsibilities.
3. **Long Parameter List:** The `process` method originally required 5+ primitive parameters.  
   *   **Solution:** Applied **Introduce Parameter Object**, passing `Order` and `User` objects instead.

### II. Object-Orientation Abusers
4. **Switch Statements:** A switch-case block was used to calculate discounts based on product types.  
   *   **Solution:** Moved the logic into the `Order` class, allowing the object to decide its own discount (Encapsulation).
5. **Temporary Fields:** A variable (`temporaryDiscountValue`) was only used once during a specific calculation but remained as a class field.  
   *   **Solution:** Removed the field and converted it into a local variable within the calculation method.

### III. Change Preventers
6. **Divergent Change:** Any change to user data or order logic required modifying the same `OrderProcessor` class.  
   *   **Solution:** Extracted `User` and `Order` into separate classes so changes are isolated.
7. **Shotgun Surgery:** Tax calculations were scattered. Changing the tax rate required multiple edits.  
   *   **Solution:** Centralized tax logic into a single `applyTax()` method.

### IV. Dispensables
8. **Duplicate Code:** Calculation logic was repeated in both the main process and the audit log.  
   *   **Solution:** Created a reusable `calculatePrice()` method to follow the DRY (Don't Repeat Yourself) principle.
9. **Dead Code:** An unused variable (`unusedCounter`) was present in the class.  
   *   **Solution:** Deleted the variable to clean up the codebase.

### V. Couplers
10. **Inappropriate Intimacy:** `OrderProcessor` was directly accessing and modifying private-like details of the user's profile.  
    *   **Solution:** Implemented **Encapsulation** by creating an `updateProfile()` method inside the `User` class.

---

## 3. Technical Stack
*   **IDE:** IntelliJ IDEA (Refactoring Shortcuts: `Shift+F6`, `Ctrl+Alt+M`, `Ctrl+Alt+P`).
*   **Language:** Java JDK 17+.
*   **Automation:** Selenium WebDriver (Chrome).
*   **Testing Framework:** JUnit 5.

## 4. How to Run the Tests
1. Ensure you have Google Chrome installed.
2. Open the project in IntelliJ IDEA.
3. Navigate to `src/test/java/OrderProcessorTest.java`.
4. Click the green "Run" icon next to `testOrderProcessingFlow()`.
5. The console should display `1 test passed` with a green checkmark.

---
## Solution
<img width="1214" height="772" alt="image" src="https://github.com/user-attachments/assets/6109c8e7-6e4f-4616-a3b7-d652db8d755f" />


---
**Authors:** Jose Luis Martin Blanco & Dorin Daniel Radulescu Toea.
