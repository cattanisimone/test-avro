package it.cattanisimone.test.avro;

import com.test.avro.MyClass;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;

public class Writer {

    public static void main(String[] args){
        try {

            MyClass instance1 = new MyClass("2019-05-4", 5d, 19d, 0.6, "", "", "SE");
            MyClass instance2 = new MyClass("2019-05-5", 10d, 20d, 0d, "", "", "SSE");
            MyClass instance3 = new MyClass("2019-05-6", 11d, 23d, 0d, "", "", "W");

            DatumWriter<MyClass> userDatumWriter = new SpecificDatumWriter<>(MyClass.class);
            DataFileWriter<MyClass> dataFileWriter = new DataFileWriter<>(userDatumWriter);
            dataFileWriter.create(instance1.getSchema(), new File("../data/generated-java-writer.avro"));
            dataFileWriter.append(instance1);
            dataFileWriter.append(instance2);
            dataFileWriter.append(instance3);
            dataFileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
