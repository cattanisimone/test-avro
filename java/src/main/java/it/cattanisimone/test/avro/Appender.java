package it.cattanisimone.test.avro;

import com.test.avro.MyClass;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Appender {

    private static Long run = System.currentTimeMillis();
    private static Random r = new Random();

    public static MyClass observe(){
        Double minTemp = (r.nextInt(300) + 10) / 10d;
        Double maxTemp = minTemp + (r.nextInt(50) / 10d);
        Double rainFall = r.nextBoolean() ? (r.nextInt(200) + 10) / 10d : 0d;
        return new MyClass("2019-05-4", minTemp, maxTemp, rainFall, run.toString(), "", "SE");
    }

    public static void sample() throws IOException {
        DatumWriter<MyClass> userDatumWriter = new SpecificDatumWriter<>(MyClass.class);
        DataFileWriter<MyClass> dataFileWriter = new DataFileWriter<>(userDatumWriter);
        MyClass observation = observe();
        dataFileWriter.appendTo(new File("../data/generated-java-appender.avro"));
        dataFileWriter.append(observation);
        dataFileWriter.close();
        System.out.println("sample observed");
    }

    public static void main(String[] args){
        try {

            while(true){
                Thread.sleep(2000);
                sample();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
