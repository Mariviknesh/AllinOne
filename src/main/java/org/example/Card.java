package org.example;
import java.util.logging.*;
class Card implements Cloneable
{
    String name;

    String num;
    String date;
    String s="com.api.jar";
    Card(String name,String num,String date)
    {
        this.name=name;
        this.num=num;
        this.date=date;
    }
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
    public void check(String y)
    {
        Logger log=Logger.getLogger(s);

        if(num.equals(y))
        {
            log.info("True\n");
        }
        else
        {
            log.info("False\n");
        }
    }
    public void display()
    {
        Logger log=Logger.getLogger(s);

        log.info(name);
        log.info(num);
        log.info(date);


    }
}
