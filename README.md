# Final Project: The Clean Code & Automation Cycle

## 🚀 Project Overview
This project focuses on identifying, implementing, and resolving **10 distinct Code Smells** to improve software maintainability and quality. Using **IntelliJ IDEA**'s automated refactoring tools, we transformed a "smelly" codebase into a clean, professional solution. The process was validated by a **Selenium WebDriver** test suite to ensure that functionality remained intact throughout the refactoring cycle.

## 🛠 Technical Stack
* **IDE:** IntelliJ IDEA (Utilizing mandatory refactoring shortcuts)
* **Version Control:** Git & GitHub (Atomic commit history)
* **Testing Framework:** Selenium WebDriver
* **Language:** Java

## 📂 Project Structure
Based on the project hierarchy, the file structure is organized as follows:

```text
CleanCode
├── .idea/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── Account/
│   │       ├── Customer/
│   │       ├── DiscountStrategy/
│   │       ├── Item/
│   │       ├── OrderService/
│   │       ├── ProductDAO/
│   │       └── SecurityUtils/
│   └── test/
│       └── java/
│           └── SeleniumTests/
├── target/
├── pom.xml
└── README.md
```

---

## 🛠 Refactoring Log (The 10 Smells)

### 1. Bloaters: Long Method
*   **Issue:** The `processOrder()` method was over 100 lines, handling validation, database logic, and notifications.
*   **Refactoring:** Applied **Extract Method** (`Ctrl+Alt+M`) to break the logic into smaller, cohesive units.

### 2. Bloaters: Large Class
*   **Issue:** The `Customer` class contained over 40 fields, including billing, shipping, and social media data.
*   **Refactoring:** Used **Extract Delegate** to split the class into `Customer`, `Address`, and `SocialProfile`.

### 3. OO Abusers: Switch Statements
*   **Issue:** A large `switch` block determined discount rates based on user type, making the code hard to extend.
*   **Refactoring:** Replaced the conditional logic with **Polymorphism** using a `DiscountStrategy` interface.

### 4. OO Abusers: Temporary Fields
*   **Issue:** A field in the `Invoice` class was only populated during a brief calculation and remained empty otherwise.
*   **Refactoring:** Applied **Replace Temp with Query** to eliminate the unnecessary class state.

### 5. Change Preventers: Divergent Change
*   **Issue:** Every time the database schema *or* the UI report format changed, the `Product` class had to be modified.
*   **Refactoring:** Separated concerns into `ProductDAO` and `ProductReportGenerator`.

### 6. Change Preventers: Shotgun Surgery
*   **Issue:** A single change in the currency logic required updates across 12 different classes.
*   **Refactoring:** Centralized the logic into a `CurrencyService` using the **Move Method** tool.

### 7. Dispensables: Duplicate Code
*   **Issue:** Identical logic for credit card masking was found in both `PaymentService` and `RefundService`.
*   **Refactoring:** Extracted the logic into a shared utility class `SecurityUtils`.

### 8. Dispensables: Dead Code
*   **Issue:** Several methods from an old API version were still present but never called.
*   **Refactoring:** Used **Safe Delete** (`Alt+Delete`) to remove unused code safely.

### 9. Couplers: Feature Envy
*   **Issue:** `OrderService` was excessively calling getter methods of the `Item` class to perform internal calculations.
*   **Refactoring:** Moved the calculation logic into the `Item` class where the data resides.

### 10. Couplers: Inappropriate Intimacy
*   **Issue:** The `User` class was directly accessing private-like internal fields of the `Account` class.
*   **Refactoring:** Improved encapsulation by establishing a proper public interface for the `Account` class.

---

## 🧪 Automated Testing (Selenium)
To maintain the **Automation Cycle**, we implemented a robust test suite:
*   **Test Status:** 100% Green / Passing.
*   **Functionality:** Validated all critical paths including Login, CRUD operations, and Checkout.
*   **Verification:** Confirmed that refactoring did not alter the external behavior of the application.
---
<img width="1263" height="756" alt="image" src="https://github.com/user-attachments/assets/8ff8f7c1-4340-49d1-9022-d7212e5ca2ca" />

## 👥 Authors
*   Jose Luis Martin Blanco
*   Dorin Daniel Radulescu Toea
