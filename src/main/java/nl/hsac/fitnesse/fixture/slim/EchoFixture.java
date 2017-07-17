package nl.hsac.fitnesse.fixture.slim;

/**
 * Created by mathijsk on 18-4-2017.
 * copied from http://www.javased.com/?source_dir=fitnesse/src/fitnesse/fixtures/EchoFixture.java
 * added "end"
 */
public class EchoFixture {
    private String name;
    private boolean end=false;

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String echo(String s) {
        return s;
    }

    public int echoInt(int i) {
        return i;
    }

    public boolean getEnd(){
        return end;
    }

    public void setEnd(boolean b){
        end = b;
    }

}
