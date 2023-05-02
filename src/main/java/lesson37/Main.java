package lesson37;

import lesson37.builder.Configuration;
import lesson37.factory.Factory;
import lesson37.factory.PDFFactory;
import lesson37.factory.TXTFactory;
import lesson37.factory.domain.Document;
import lesson37.prototype.Human;
import lesson37.prototype.Parrot;
import lesson37.singleton.Singleton;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        //Фабричный метод / Фабрика
        final Document txtFile = getRequiredDocument(new TXTFactory());
        txtFile.print();

        final Document pdfFile = getRequiredDocument(new PDFFactory());
        pdfFile.print();

        //Одиночка:
        final Singleton pathToConfig = Singleton.instance("pathToConfig");
        final Singleton secondConfig = Singleton.instance("secondConfig");
        System.out.println(pathToConfig.getConfiguration());
        System.out.println(secondConfig.getConfiguration());

        //Прототип:
        final Human human = new Human("Bob", "man", 15, new Parrot("bird"));
        final Human clonedHuman = (Human) human.clone();
        clonedHuman.setAge(100);
        clonedHuman.getParrot().setName("changedName");

        System.out.println("human: " + human);
        System.out.println("clonedHuman: " + clonedHuman);

        //Строитель:
        Configuration configuration = new Configuration.Builder()
//                .withPath("path")
                .withPort(8080)
//                .withHost("host")
                .withPrefix("prefix")
                .build();

    }

    private static Document getRequiredDocument(final Factory factory) {
        return factory.getDocument();
    }
}
