package org.example;
import java.util.logging.*;
class Bank
{
    String name;
    int accno;
    int bal;
    Logger log=Logger.getLogger("com.api.jar");

    Bank( String name,int accno)
    {
        this.name=name;
        this.accno=accno;
        this.bal=0;
        String acc=Integer.toString(accno);
        log.info("Account Number:");
        log.info(acc);
        log.info("Account Holder Name:");
        log.info(name);

    }

    public void deposit(int amt)
    {
        this.bal=this.bal+amt;
        log.info("Amount is Deposited\n");
    }

    public void withdrawal(int amt)
    {
        if(this.bal-amt<0)
        {
            log.info("Your Withdrawal amount is greater than balance amount\n");
            log.info("The Balance in your Account is ");
            String a=Integer.toBinaryString(returnBal());
            log.info(a);
        }
        this.bal=this.bal-amt;
        log.info("Amount is Withrawed\n");
    }
    public int returnBal()
    {
        return this.bal;
    }
}
