import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {


    @BeforeAll
    public static void init() {
        System.out.println("----------ALL TESTING STARTED----------");

    }

    @BeforeEach
    public void nameOfMethodBeforeTest(TestInfo testInfo)
    {
        System.out.printf("Testing started for --> " + testInfo.getDisplayName() +"\n");
    }

    @AfterEach
    public void nameOfMethodAfterTest(TestInfo testInfo)
    {
        System.out.printf("Testing finished for --> " + testInfo.getDisplayName()+"\n");
    }






     Account account; // sample account class to use in test methods


    @Test
    public void testConstructorEmpty()  {  // test the empty constructor

        account = new Account();
        assertNotNull(account);

        // test customer number  if constructor is empty with -1 0 1 numbers
        assertEquals(account.getCustomerNumber(), 0);
        assertNotEquals(account.getCustomerNumber(), 1);
        assertNotEquals(account.getCustomerNumber(), -1);

        // test PIN Number if constructor is empty with number with -1 0 1 numbers
        assertEquals(account.getPinNumber(), 0);
        assertNotEquals(account.getPinNumber(), 1);
        assertNotEquals(account.getPinNumber(), -1);

        assertEquals(account.getCheckingBalance(), 0); // must be 0

        assertEquals(account.getSavingBalance(), 0); // must be 0



    }


    @Test
    public void testConstructor1()
    {
        int testCustomerNumber =0;
        int testPinNumber =0;
        account = new Account(testCustomerNumber,testPinNumber); // create account with test numbers


        // check the account class
        assertNotNull(account);
        assertInstanceOf(Account.class,account);

        // check the number if is null or not
        assertNotNull(account.getCustomerNumber());
        assertNotNull(account.getPinNumber());

        // check the number if is equal
        assertEquals(account.getCustomerNumber(),testCustomerNumber);
        assertEquals(account.getPinNumber(),testPinNumber);

        // check the number's type -- Integer or not
        assertInstanceOf(Integer.class,account.getCustomerNumber());
        assertInstanceOf(Integer.class,account.getPinNumber());


    }

    @Test
    public void testConstructor1IfNumbersIsNotSame() // if variables is not same for constructor 1
    {
        int testCustomerNumber =0;
        int testPinNumber =1;
        account = new Account(testCustomerNumber,testPinNumber);

        assertNotNull(account);
        assertInstanceOf(Account.class,account);

        assertEquals(account.getCustomerNumber(),testCustomerNumber);
        assertEquals(account.getPinNumber(),testPinNumber);
    }

    @Test
    public void testConstructor1IfNumbersIsNegative() // if variables is negative for constructor 1
    {
        int testCustomerNumber =-1;
        int testPinNumber =-1;
        account = new Account(testCustomerNumber,testPinNumber);

        assertNotNull(account);
        assertInstanceOf(Account.class,account);

        assertEquals(account.getCustomerNumber(),testCustomerNumber);
        assertEquals(account.getPinNumber(),testPinNumber);
        assertTrue(account.getCustomerNumber()>=0);
        assertTrue(account.getPinNumber()>=0);
    }

    @Test
    public void testConstructor2()
    {
        // set Test Variables
        int testCustomerNumber =0;
        int testPinNumber=0;
        Double testCheckingBalance=0.0;
        Double testSavingBalance=0.0;

        account = new Account(testCustomerNumber,testPinNumber,testCheckingBalance,testSavingBalance); // create account
        assertNotNull(account); // account must be not null

        assertInstanceOf(Account.class,account);

        // check variables if they are null or not
        assertNotNull(account.getCustomerNumber());
        assertNotNull(account.getPinNumber());
        assertNotNull(account.getCheckingBalance());
        assertNotNull(account.getSavingBalance());

        // these variables must be equal test numbers
        assertEquals(account.getCustomerNumber(),testCustomerNumber);
        assertEquals(account.getPinNumber(),testPinNumber);
        assertEquals(account.getSavingBalance(),testSavingBalance);
        assertEquals(account.getCheckingBalance(),testCheckingBalance);

        // check Integer Numbers
        assertInstanceOf(Integer.class,account.getPinNumber());
        assertInstanceOf(Integer.class,account.getCustomerNumber());

        // check Double Numbers
        assertInstanceOf(Double.class,account.getSavingBalance());
        assertInstanceOf(Double.class,account.getCheckingBalance());

    }

    @Test
    public void testAccountConstructors() // test Constructors if same or equal
    {
        Account account = new Account(); // create empty constructor
        Account account1 = new Account(0,0); // create constructor 1
        Account account2 = new Account(0,0,0,0); // create constructor 2




        // check constructors equal each other
        assertNotEquals(account,account1);
        assertNotEquals(account,account2);
        assertNotEquals(account1,account2);

        // check constructors same each other
        assertNotSame(account,account1);
        assertNotSame(account,account2);
        assertNotSame(account1,account2);



    }


    @Test
    public void testSetandGetCustomerNumber()
    {
        int customerNumberTest = 1;
        account = new Account(); // create account

       account.setCustomerNumber(customerNumberTest); // set Customer number with test number

        // test get method
        assertNotNull(account.getCustomerNumber());
        assertEquals(account.getCustomerNumber(),customerNumberTest);
        assertInstanceOf(Integer.class,account.getCustomerNumber());
        assertTrue(account.getCustomerNumber()>=0);

    }

    @Test
    public void testSetAndGetPinNumber()
    {
        int testPinNumber = 0;
        account = new Account(); // create account

        account.setCustomerNumber(testPinNumber); // set Pin Number with test number

        // test get method
        assertNotNull(account.getPinNumber());
        assertEquals(account.getPinNumber(),testPinNumber);
        assertInstanceOf(Integer.class,account.getPinNumber());
        assertTrue(account.getPinNumber()>=0);
    }

    @Test
    public void testGetCheckingBalance()
    {
        testConstructor2(); // call constructor 2 --  "which have four parameters"

        assertNotNull(account.getCheckingBalance());
        assertEquals(account.getCheckingBalance(),0.0);  // Checking Balance must be 0 due to testConstructor2 method
        assertInstanceOf(Double.class,account.getCheckingBalance()); // must be double
        assertTrue(account.getCheckingBalance()>=0);




    }

    @Test
    public void testGetSavingBalance()
    {
        testConstructor2(); // call constructor 2 --  "which have four parameters"

        assertNotNull(account.getSavingBalance());
        assertEquals(account.getSavingBalance(),0.0);  // Checking Balance must be 0 due to testConstructor2 method
        assertInstanceOf(Double.class,account.getSavingBalance()); // must be double
        assertTrue(account.getSavingBalance()>=0);


    }

    @Test
    public void testCalcCheckingWithdraw()
    {
        double testAmount =0;

        account = new Account(1,1,0.1,0.1); // create account sample

        double checkingBalance= account.getCheckingBalance();
         checkingBalance = account.getCheckingBalance() - testAmount; // create test balance like in the Account class

        // test again Balances are null or not
        assertNotNull(account.getCheckingBalance());
        assertNotNull(account.getSavingBalance());

        // Check if test balance equals balance in account class
        assertEquals(account.calcCheckingWithdraw(testAmount),checkingBalance);

        // test negative or not (must not be negative)
        assertTrue(account.calcCheckingWithdraw(testAmount)>=0);

        // test type (Must be double)
        assertInstanceOf(Double.class,account.calcCheckingWithdraw(testAmount));

    }


    @ParameterizedTest
    @ValueSource(doubles = {0.1,0.2,15.5,-13.4,0})
    public void testCalcSavingWithdraw(double testAmount)
    {


        account = new Account(1,1,0.1,0.1); // create account sample

        double savingBalance= account.getSavingBalance();
        savingBalance = account.getSavingBalance() - testAmount; // create test balance like in the Account class

        // test again Balances are null or not
        assertNotNull(account.getCheckingBalance());
        assertNotNull(account.getSavingBalance());

        // Check if test balance equals balance in account class
        assertEquals(account.calcSavingWithdraw(testAmount),savingBalance);

        // test negative or not (must not be negative)
        assertTrue(account.calcSavingWithdraw(testAmount)>=0);

        // test type (Must be double)
        assertInstanceOf(Double.class,account.calcSavingWithdraw(testAmount));
    }


     @Test
    public void testCalcCheckingDeposit()
    {
        double testAmount =0;
        account = new Account(1,1,0.1,0.1); // create sample account

        double checkingBalance= account.getCheckingBalance();
        checkingBalance = account.getCheckingBalance() + testAmount; // create test balance like in the Account class

        // test again Balances are null or not
        assertNotNull(account.getCheckingBalance());
        assertNotNull(account.getSavingBalance());

        // Check if test balance equals balance in account class
        assertEquals(account.calcCheckingDeposit(testAmount),checkingBalance);

        // test negative or not (must not be negative)
        assertTrue(account.calcCheckingDeposit(testAmount)>=0);

        // test type (Must be double)
        assertInstanceOf(Double.class,account.calcCheckingDeposit(testAmount));
    }

    @Test
    public void testCalcSavingDeposit()
    {
        double testAmount =0;

        account = new Account(1,1,0.1,0.1); // create sample account

        double savingBalance= account.getCheckingBalance();
        savingBalance = account.getCheckingBalance() + testAmount; // create test balance like in the Account class

        // test again Balances are null or not
        assertNotNull(account.getCheckingBalance());
        assertNotNull(account.getSavingBalance());

        // Check if test balance equals balance in account class
        assertEquals(account.calcSavingDeposit(testAmount),savingBalance);

        // test negative or not (must not be negative)
        assertTrue(account.calcSavingDeposit(testAmount)>=0);

        // test type (Must be double)
        assertInstanceOf(Double.class,account.calcSavingDeposit(testAmount));
    }

    //---------- test with default constructor-------------//
    @Test
    public void testTransferMethods()
    {
        account = new Account(); // default constructor
        double testAmount =0;
        account.calcCheckTransfer(testAmount);

        // must not be null
        assertNotNull(account.getSavingBalance());
        assertNotNull(account.getCheckingBalance());

        // must be 0 or positive
        assertTrue(account.getSavingBalance()>=0);
        assertTrue(account.getCheckingBalance()>=0);


        account.calcSavingTransfer(testAmount);

        // must not be null
        assertNotNull(account.getSavingBalance());
        assertNotNull(account.getCheckingBalance());

        // must be 0 or positive
        assertTrue(account.getSavingBalance()>=0);
        assertTrue(account.getCheckingBalance()>=0);


    }

    @Test
    public void testTransferMethods1() // if test amount is positive
    {
        account = new Account(); // default constructor
        double testAmount =55; // test with random number
        account.calcCheckTransfer(testAmount);

        // must not be null
        assertNotNull(account.getSavingBalance());
        assertNotNull(account.getCheckingBalance());

        // must be 0 or positive
        assertTrue(account.getSavingBalance()>=0);
        assertTrue(account.getCheckingBalance()>=0);


        account.calcSavingTransfer(testAmount);

        // must not be null
        assertNotNull(account.getSavingBalance());
        assertNotNull(account.getCheckingBalance());

        // must be 0 or positive
        assertTrue(account.getSavingBalance()>=0);
        assertTrue(account.getCheckingBalance()>=0);


    }
    @Test
    public void testTransferMethods2() // if test amount is negative
    {
        account = new Account(); // default constructor
        double testAmount =-55; // test with random number
        account.calcCheckTransfer(testAmount);

        // must not be null
        assertNotNull(account.getSavingBalance());
        assertNotNull(account.getCheckingBalance());

        // must be 0 or positive
        assertTrue(account.getSavingBalance()>=0);
        assertTrue(account.getCheckingBalance()>=0);


        account.calcSavingTransfer(testAmount);

        // must not be null
        assertNotNull(account.getSavingBalance());
        assertNotNull(account.getCheckingBalance());

        // must be 0 or positive
        assertTrue(account.getSavingBalance()>=0);
        assertTrue(account.getCheckingBalance()>=0);

    }

    //---------- test with constructor has 4 parameters-------------//
    @Test
    public void testTransferMethods3()
    {
        account = new Account(1,1,0,0); // default constructor
        double testAmount =0;
        account.calcCheckTransfer(testAmount);

        // must not be null
        assertNotNull(account.getSavingBalance());
        assertNotNull(account.getCheckingBalance());

        // must be 0 or positive
        assertTrue(account.getSavingBalance()>=0);
        assertTrue(account.getCheckingBalance()>=0);


        account.calcSavingTransfer(testAmount);

        // must not be null
        assertNotNull(account.getSavingBalance());
        assertNotNull(account.getCheckingBalance());

        // must be 0 or positive
        assertTrue(account.getSavingBalance()>=0);
        assertTrue(account.getCheckingBalance()>=0);


    }

    @Test
    public void testTransferMethods4() // if test amount is positive
    {
        account = new Account(1,1,15.5,15.5); // default constructor
        double testAmount =55; // test with random number
        account.calcCheckTransfer(testAmount);

        // must not be null
        assertNotNull(account.getSavingBalance());
        assertNotNull(account.getCheckingBalance());

        // must be 0 or positive
        assertTrue(account.getSavingBalance()>=0);
        assertTrue(account.getCheckingBalance()>=0);


        account.calcSavingTransfer(testAmount);

        // must not be null
        assertNotNull(account.getSavingBalance());
        assertNotNull(account.getCheckingBalance());

        // must be 0 or positive
        assertTrue(account.getSavingBalance()>=0);
        assertTrue(account.getCheckingBalance()>=0);


    }

    @Test
    public void testTransferMethods5() // if test amount is negative
    {
        account = new Account(0,0,-15.5,-15.5); // default constructor
        double testAmount =-55; // test with random number
        account.calcCheckTransfer(testAmount);

        // must not be null
        assertNotNull(account.getSavingBalance());
        assertNotNull(account.getCheckingBalance());

        // must be 0 or positive
        assertTrue(account.getSavingBalance()>=0);
        assertTrue(account.getCheckingBalance()>=0);


        account.calcSavingTransfer(testAmount);

        // must not be null
        assertNotNull(account.getSavingBalance());
        assertNotNull(account.getCheckingBalance());

        // must be 0 or positive
        assertTrue(account.getSavingBalance()>=0);
        assertTrue(account.getCheckingBalance()>=0);

    }




    @AfterAll
    public static void end() {
        System.out.println("-----------ALL TESTING FINISHED-----------");

    }
}