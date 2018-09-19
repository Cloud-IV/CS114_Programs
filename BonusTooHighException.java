//**********************************************************************************************************************
//  BonusTooHighException.java
//
//  Exception class designed to throw an exception when too high of a bonus is paid to an executive.
//**********************************************************************************************************************

public class BonusTooHighException extends Exception
{
    public BonusTooHighException(String msg)
    {
        super(msg);
    }
}
