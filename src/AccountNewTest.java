import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountNewTest {

    Account account;
    //** PATH TESTING

    @Test
    public void checkEnd()
    {
        account = new Account();
        account.getCheckingWithdrawInput(true);
        assertFalse(account.check);
    }

    @Test
    public void checkIf()
    {
        account = new Account();
        account.amount = -5;
        account.getCheckingWithdrawInput(false);
        assertFalse(account.check1);

    }

    @Test
    public void checkIf2()
    {
        account = new Account(0,0,10,10);
        account.amount = 5;
        account.getCheckingWithdrawInput(false);
        assertTrue(account.check1);

    }



    //**** MUTANT TEST

    @Test
    public void testMutantCheckBalance1()
    {
        account = new Account(0,0,-15.5,-15.5); // default constructor
        if(account.getCheckingBalance()<0)
            assertTrue(account.checkBalance());

        if(account.getCheckingBalance()>=0)
            assertFalse(account.checkBalance());

    }

    @Test
    public void testMutantCheckBalance2()
    {
        account = new Account(0,0,15.5,-15.5); // default constructor
        if(account.getCheckingBalance()>=0)
            assertTrue(account.checkBalance());
        if(account.getCheckingBalance()<0)
            assertFalse(account.checkBalance());

    }

    @Test
    public void testMutantCheckBalance3()
    {
        account = new Account(0,0,15.5,-15.5); // default constructor
        Float amount = 5f;
        if(account.checkCalcCheckingWithdraw(amount))
            assertTrue(account.checkBalance());
        if(!account.checkCalcCheckingWithdraw(amount))
            assertFalse(account.checkBalance());

    }

    @Test
    public void testMutantCheckBalance4()
    {
        account = new Account(0,0,15.5,-15.5); // default constructor
        Float amount = -5f;
        if(account.checkCalcCheckingWithdraw(amount))
            assertTrue(account.checkBalance());
        if(!account.checkCalcCheckingWithdraw(amount))
            assertFalse(account.checkBalance());

    }

    //*** desicion table test

    @Test
    public void  testCondition1()
    {
        // BALANCE IS POSITIVE AND AMOUNT IS NEGATIVE
        Account account = new Account(0,0,0,5);

        account.amount = -5;
        account.getsavingWithdrawInput();

        assertFalse(account.getSavingBalance()!=0);

        //Infinity loop
    }

    @Test
    public void  testCondition2()
    {
        // BALANCE IS POSITIVE AND AMOUNT IS POSITIVE
        Account account = new Account(0,0,0,5);

        account.amount = +5;
        account.getsavingWithdrawInput();

        assertTrue(account.getSavingBalance()==0);

        //Normal loop
    }

    @Test
    public void  testCondition3()
    {
        // BALANCE IS NEGATIVE AND AMOUNT IS NEGATIVE
        Account account = new Account(0,0,0,-5);

        account.amount = -5;
        account.getsavingWithdrawInput();

        assertTrue(account.getSavingBalance()==0);

        //Infinity loop
    }

    @Test
    public void  testCondition4()
    {
        // BALANCE IS NEGATIVE AND AMOUNT IS POSITIVE
        Account account = new Account(0,0,0,-5);

        account.amount = +5;
        account.getsavingWithdrawInput();

        assertTrue(account.getSavingBalance()==0);

        //Infinity loop
    }


}