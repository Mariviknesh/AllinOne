package org.example;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.logging.*;
import java.sql.*;

public class OneMaven {
    private static final String COM="com.api.jar";
    public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException {
        Logger log=Logger.getLogger(COM);
        log.info("1.Bank\n2.Shape\n3.School\n4.Database\n5.Point\n6.Credit\n7.Linked List\n8.Hash Map\n9.Tic Tac Toe\n10.word Count\n11.Calculator\n");
        Scanner sc=new Scanner(System.in);
        int ch;
        OneMaven o=new OneMaven();
        do {
            log.info("Enter the assignment number:");
            ch=sc.nextInt();
            switch (ch) {
                case 1 -> o.bank();
                case 2 -> o.shape();
                case 3 -> o.school();
                case 4 -> o.database();
                case 5 -> o.point();
                case 6 -> o.credit();
                case 7->o.linkedlist();
                case 8->o.hash();
                case 9->o.tictactoe();
                case 10->o.wordCount();
                case 11->o.calc();
                default -> log.info("Enter valid input");
            }
        }while(ch<12);
    }
    public void bank()
    {
                String name;
                int accno;
                int amt;
                int choice=0;
                Scanner mysc = new Scanner(System.in);
                Logger log=Logger.getLogger(COM);
                log.info("Enter the Account number:");
                accno=mysc.nextInt();
                log.info("Enter the Account holder name:");
                name = mysc.next();
                Bank a= new Bank(name,accno);

                try {
                    while (choice < 4) {

                        log.info("1.Deposit Amount\n2.Withdraw Amount\n3.View Balance\n4.Exit\nEnter the your choice:");
                        choice = mysc.nextInt();
                        if (choice == 1) {
                            log.info("Enter the Amount to be deposited:");
                            amt = mysc.nextInt();
                            a.deposit(amt);
                        } else if (choice == 2) {
                            log.info("Enter the Amount to be Withdraw:");
                            amt = mysc.nextInt();
                            a.withdrawal(amt);
                        } else if (choice == 3) {
                            String bal = Integer.toString(a.returnBal());
                            log.info("The Balance in your Account is");
                            log.info(bal);
                        } else {
                            break;
                        }
                    }
                }catch(Exception e)
                    {
                        log.info("Input Mismatch Error");
                    }

    }
    public void school()
    {
        String name;
        String grade;
        double gpa;
        int ch=0;
        Scanner mysc=new Scanner(System.in);
        Logger log=Logger.getLogger(COM);
        log.info("Enter the Student's name:");
        name=mysc.nextLine();
        log.info("Enter the Student's grade:");
        grade=mysc.next();
        log.info("Enter the Student's gpa:");
        gpa=mysc.nextDouble();
        Student s=new Student(name,grade,gpa);
        s.display();
        while(ch!=3)
        {
            log.info("\nMENU\n1.Update gpa\n2.Display\n3.Exit\nEnter the choice:");
            ch=mysc.nextInt();
            try {
                switch (ch) {
                    case 1:
                        log.info("Enter the Student's gpa to get updated:");
                        double ugpa = mysc.nextDouble();
                        s.updateGpa(ugpa);
                        break;
                    case 2:
                        s.display();
                        break;
                    default:
                        log.info("Enter the correct choice");
                        break;
                }
            }
            catch (Exception e)
            {
                log.info("Input Mismatch Exception");

            }
        }

    }
    public void shape()
    {
        double d1;
        double d2;
        double d3;
        String etd="Enter the dimensions";
        String are="Area=";
        String per="Perimeter=";
        String ra;
        String rp;
        Scanner mysc=new Scanner(System.in);
        Logger log=Logger.getLogger(COM);
        for(int i=0;i<4;i++)
        {
            try {
                log.info("Enter the name of the shape:");
                String name = mysc.next();
                if ((name.equals("rectangle"))) {
                    log.info(etd);
                    d1 = mysc.nextFloat();
                    d2 = mysc.nextFloat();
                    BasicShape b = new BasicShape(name, d1, d2);
                    b.findArea(d1, d2);
                    b.findPerimeter(d1, d2);
                    ra = "" + b.retArea();
                    log.info(ra);
                    rp = "" + b.retPeri();
                    log.info(per);
                    log.info(rp);
                    b = null;

                } else if (name.equals("triangle")) {
                    log.info(etd);
                    d1 = mysc.nextFloat();
                    d2 = mysc.nextFloat();
                    d3 = mysc.nextFloat();
                    BasicShape b = new BasicShape(name, d1, d2, d3);
                    b.findArea(d1, d2, d3);
                    b.findPerimeter(d1, d2, d3);
                    log.info(are);
                    ra = "" + b.retArea();
                    log.info(ra);
                    rp = "" + b.retPeri();
                    log.info(per);
                    log.info(rp);
                    b = null;

                } else if ((name.equals("circle")) || (name.equals("square"))) {
                    log.info(etd);
                    d1 = mysc.nextFloat();
                    BasicShape b = new BasicShape(name, d1);
                    b.findArea(name, d1);
                    b.findPerimeter(name, d1);
                    log.info(are);
                    ra = "" + b.retArea();
                    log.info(ra);
                    rp = "" + b.retPeri();
                    log.info(per);
                    log.info(rp);
                    b = null;
                } else {
                    log.info("Enter correct shape\n");
                }
            }catch(Exception e)
            {
                log.info("Enter correct input\n");
            }
        }
    }
    public void database()
    {
        Logger log=Logger.getLogger(COM);
        Connection conn = null;
        int ch;
        Scanner s=new Scanner(System.in);
        Dbase db=Dbase.create();
        Dbase db1=Dbase.create();
        while(true)
        {
            log.info("1.Connect\n2.Close\n3.Exit\n");
            log.info("Enter your choice:");
            ch=s.nextInt();
            if(ch==1)
            {
                conn=db.connect();
            }
            else if(ch==3)
            {
                break;
            }
            else if(ch==2)
            {
                db1.close(conn);
            }
        }

    }
    public void point() throws CloneNotSupportedException
    {
        String x;
        String y;
        Scanner sc=new Scanner(System.in);
        Logger log=Logger.getLogger(COM);
        log.info("Enter the value of x:");
        x=sc.next();
        log.info("Enter the value of y:");
        y=sc.next();
        Space s1=new Space(x,y);
        s1.check();
        log.info("Object 1");
        s1.display();
        Space s2=(Space)s1.clone();
        log.info("Object");
        s2.display();

    }
    public void credit() throws CloneNotSupportedException
    {
        String name;
        String num;
        String date;
        String y;
        Scanner sc=new Scanner(System.in);
        Logger log=Logger.getLogger(COM);
        log.info("Enter the Cardholder name");
        name=sc.next();
        log.info("Enter the Card number");
        num=sc.next();
        log.info("Enter the expiration date");
        date=sc.next();
        Card s1=new Card(name,num,date);
        s1.display();
        log.info("Enter the Card number for checking");
        y=sc.next();
        s1.check(y);
        Card s2=(Card)s1.clone();
        log.info("Cloned Object\n");
        s2.display();

    }

    public void linkedlist()
    {
        String []data1;

        Logger log=Logger.getLogger(COM);
        LinkedList l=new LinkedList();
        OneMaven l1=new OneMaven();
        Scanner sc=new Scanner(System.in);

        int ch=0;

        while(ch!=10)
        {
            log.info("1.Add Contact at last");
            log.info("2.Add Contact at First");
            log.info("3.Delete Contact at last");
            log.info("4.Delete Contact at First");
            log.info("5.Insert by Position");
            log.info("6.Delete by Position ");
            log.info("7.Search by Number");
            log.info("8.Display the linked list");
            log.info("9.Display the number of nodes");
            log.info("10.Exit");
            log.info("Enter the choice");
            ch=sc.nextInt();
            switch (ch) {


                case 1:{
                    data1 = l1.getdata();
                    Person p1 = new Person(data1[0], data1[1], data1[2]);
                    l.addNode(p1);break;
                } case 2: {
                    data1 = l1.getdata();
                    Person p1 = new Person(data1[0], data1[1], data1[2]);
                    l.addNodeFirst(p1);break;
                } case 3: {
                    l.deleteNodeLast();break;
                } case 4: {
                    l.deleteNodeFirst();break;
                }case 5: {
                    log.info("Enter the position");
                    int pos = sc.nextInt();
                    data1 = l1.getdata();
                    Person p1 = new Person(data1[0], data1[1], data1[2]);
                    l.addNodePos(p1, pos);break;
                } case 6: {
                    log.info("Enter the position");
                    int pos = sc.nextInt();
                    l.deleteNodePos(pos);break;
                } case 7: {
                    log.info("Enter the number for searching");
                    String num = sc.next();
                    int res = l.searchbyNumber(num);
                    if (res > 0) {
                        log.info("The contact is found at the position of");
                        log.log(Level.INFO, () -> "" + res);
                    } else if (res == 0) {
                        log.info("The list is empty");
                    } else if (res == -1) {
                        log.info("The contact is not presented in the Linked list");
                    }break;
                } case 8: {
                    l.display();break;
                } case 9: {
                    l.displayCount();
                    break;
                } default: {
                    log.info("Enter valid choice");
                    break;
                }
            }
        }

    }
    public String [] getdata()
    {

        String [] data=new String[3];
        Scanner sc=new Scanner(System.in);
        Logger log=Logger.getLogger(COM);
        log.info("Enter Name:");
        data[0]=sc.next();
        log.info("Enter Email:");
        data[1]=sc.next();
        log.info("Enter number:");
        data[2]=sc.next();
        return data;
    }
    public void hash()
    {
        int size;
        String name;
        Scanner sc=new Scanner(System.in);
        Logger log= Logger.getLogger(COM);
        log.info("Enter the size");
        size=sc.nextInt();
        HashSet<String> hs=new HashSet< >();
        TreeSet<String> ts=new TreeSet<>();
        HashMap<Integer,String>hm=new HashMap<>();
        TreeMap<Integer,String>tm=new TreeMap<>();
        log.info("Enter the Elements");
        for(int j=0;j<size;j++)
        {
            name= sc.next();
            hs.add(name);
            ts.add(name);
            hm.put(j+1,name);
            tm.put(j+1,name);
        }
        Iterator<String> i=hs.iterator();
        Iterator<String> j= ts.iterator();
        String ii;
        log.info("Elements in Hash set is");
        while(i.hasNext())
        {
            ii=i.next();
            log.info(ii);
        }
        log.info("Elements in Tree set is");
        while(j.hasNext())
        {
            ii=j.next();
            log.info(ii);
        }
        log.info("Elements in Hashmap");
        for(Map.Entry<Integer,String> m : hm.entrySet()){
            log.info(m.getKey()+" "+m.getValue());
        }
        log.info("Elements in Treemap");
        for(Map.Entry<Integer,String> m : tm.entrySet()){
            log.info(m.getKey()+" "+m.getValue());
        }
        log.info("Enter the element to get removed");
        String rem=sc.next();
        hs.remove(rem);
        ts.remove(rem);
        Iterator<String> x=hs.iterator();
        Iterator<String> y= ts.iterator();
        log.info("Elements in Hash set is");

        while(x.hasNext())
        {
            ii=x.next();
            log.info(ii);
        }
        log.info("Elements in Tree set is");

        while(y.hasNext())
        {
            ii=y.next();
            log.info(ii);
        }
    }
    public void tictactoe()
    {
        int size;
        int choice;
        int x;
        int y;
        int cnt=0;
        boolean ch;
        String[]sym={"x","o"};
        Logger l=Logger.getLogger(COM);
        l.log(Level.INFO,()->"Enter the size of matrix");
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        Game p1 = new Game(size);
        String str1="Enter the position-Player 1 (1 to "+size*size+")";
        String str2="Enter the position-Player 2 (1 to "+size*size+")";
        String drw="The match is DRAW";
        int []inp=new int[2];
        l.log(Level.INFO,()->"Initially the Matrix is");
        p1.display();
        while(true)
        {
            l.log(Level.INFO,()->str1);
            choice=sc.nextInt();
            x = (choice-1)/size;
            y = (choice-1)%size;
            p1.check(choice,inp,str1);
            ch=p1.set(inp[0],inp[1],sym[0]);

            p1.check1(ch,inp,sym[0],str1);
            l.log(Level.INFO,()->"Matrix is");
            p1.display();
            cnt++;
            if(p1.checkHorizontal(x,sym[0]) || p1.checkVertical(y,sym[0]) || p1.checkDiagonal(sym[0]) || p1.checkDiagonal1(sym[0]))
            {
                l.log(Level.INFO,()->"Player 1 is winner");
                System.exit(0);
            }
            if(cnt==size*size)
            {
                l.log(Level.INFO,()->drw);
                System.exit(0);
            }
            l.log(Level.INFO,()->str2);
            choice=sc.nextInt();
            x = (choice-1)/size;
            y = (choice-1)%size;
            p1.check(choice,inp,str2);
            ch=p1.set(inp[0],inp[1],sym[1]);
            p1.check1(ch,inp,sym[1],str2);

            l.log(Level.INFO,()->"Matrix is");
            p1.display();
            cnt++;
            if(p1.checkHorizontal(x,sym[1]) || p1.checkVertical(y,sym[1])|| p1.checkDiagonal(sym[1]) || p1.checkDiagonal1(sym[1])) {
                l.log(Level.INFO,()->drw);
                System.exit(0);

            }
            if(cnt==size*size)
            {
                l.log(Level.INFO,()->"The match is DRAW");
                System.exit(0);


            }
        }
    }
    public void wordCount() throws FileNotFoundException {
        Logger l=Logger.getLogger(COM);
        HashMap<String,Integer> hs=new HashMap<>();
        String se = "C:\\Users\\Tringapps-User2\\Documents\\example.txt";
        File file = new File(se);
        Scanner mysc = new Scanner(file);
        String buffer;

        while(mysc.hasNext())
        {
            buffer = mysc.next();
            if(hs.containsKey(buffer))
            {
                int count = hs.get(buffer) + 1;
                hs.put(buffer,count);
            }
            else
            {
                hs.put(buffer, 1);
            }
        }

        String hmap=hs+" ";
        l.log(Level.INFO,()->"before Sorting "+ hmap);

        List<Map.Entry<String, Integer>> hhmap = hs.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList();
        l.log(Level.INFO,()->"After Sorting "+ hhmap);
    }
    public void calc()
    {
        int a;
        int b;
        int ch;
        String res;
        Scanner mysc=new Scanner(System.in);
        Logger log=Logger.getLogger(COM);
        while(true)
        {
            log.info("Enter the 2 numbers:");

            a=mysc.nextInt();
            b=mysc.nextInt();
            log.info("1.Addition");
            log.info("2.Subtraction");
            log.info("3.Multiplication");
            log.info("4.Division");
            log.info("5.Exit");
            log.info("Enter the choice:");
            ch=mysc.nextInt();
            if(ch==1)
            {
                Add obj=new Add();
                obj.setA(a);
                obj.setB(b);
                res=""+obj.operation();
                log.info(res);
            }
            else if(ch==2)
            {
                Diff obj=new Diff();
                obj.setA(a);
                obj.setB(b);
                res=""+obj.operation();
                log.info(res);
            }
            else if(ch==3)
            {
                Mul obj=new Mul();
                obj.setA(a);
                obj.setB(b);
                res=""+obj.operation();
                log.info(res);

            }
            else if(ch==4)
            {
                Div obj=new Div();
                obj.setA(a);
                obj.setB(b);
                res=""+obj.operation();
                log.info(res);
            }
            else
            {
                break;
            }
        }
    }
}