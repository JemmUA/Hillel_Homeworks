package lesson37.factory.domain;

public class TXTDocument implements Document {
    @Override
    public void print() {
        System.out.println("TXT document");
    }
}
