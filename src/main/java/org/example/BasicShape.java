package org.example;

class BasicShape {
    String name;
    String sq="square";
    double d1;
    double d2;
    double d3;
    double area;
    double peri;


    BasicShape(String name,double d1)
    {
        this.name=name;
        this.d1=d1;
    }
    BasicShape(String name,double d1,double d2)
    {
        this.name=name;
        this.d1=d1;
        this.d2=d2;
    }
    BasicShape(String name,double d1,double d2,double d3)
    {
        this.name=name;
        this.d1=d1;
        this.d2=d2;
        this.d3=d3;
    }
    public void findArea(String name,double d1) {
        if(name.equals(sq))
        {
            area=d1*d1;
        }
        else{
            area=(22*d1*d1)/7;
        }
    }
    public void findArea(String name,double d1,double d2) {

        area=d1*d2;
    }
    public void findArea(String name,double d1,double d2,double d3) {


        area=0.5*d1*d2;
    }
    public void findPerimeter(String name,double d1) {
        if(name.equals(sq))
        {
            peri=4*d1;
        }
        else
        {
            peri=(22*d1*2)/7;
        }
    }
    public void findPerimeter(String name,double d1,double d2) {

        peri=2*(d1+d2);
    }
    public void findPerimeter(String name,double d1,double d2,double d3) {
        peri=d1+d2+d3;
    }
    public double retArea()
    {
        return this.area;
    }
    public double retPeri()
    {
        return this.peri;
    }
}