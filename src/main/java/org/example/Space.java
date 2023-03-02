package org.example;
import java.util.Scanner;
import java.util.logging.*;
class Space implements Cloneable
{
    String x;
    String y;
    Logger log=Logger.getLogger("com.api.jar");

    Space(String x,String y)
    {
        this.x=x;
        this.y=y;
    }
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
    public void check()
    {
        if(x.equals(y))
        {
            log.info("Both are equal");
        }
        else
        {
            log.info("Both are not equal");
        }
    }
    public void display()
    {
        log.info(x);
        log.info(y);

    }
}
