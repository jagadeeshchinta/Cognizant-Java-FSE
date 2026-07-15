BEGIN
    FOR cust IN (
        SELECT CustomerID, Age
        FROM Customers
    ) LOOP

        IF cust.Age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rates updated successfully.');

END;
/

BEGIN

    FOR cust IN (
        SELECT CustomerID, Balance
        FROM Customers
    ) LOOP

        IF cust.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP customers updated.');

END;
/

BEGIN

    FOR loan IN (

        SELECT
            c.Name,
            l.LoanID,
            l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30

    ) LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear '
            || loan.Name
            || ', your Loan ID '
            || loan.LoanID
            || ' is due on '
            || TO_CHAR(loan.DueDate,'DD-MON-YYYY')
        );

    END LOOP;

END;
/

