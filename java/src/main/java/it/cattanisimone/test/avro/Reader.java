package it.cattanisimone.test.avro;

import com.test.avro.MyClass;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;

public class Reader {

    public static void main(String[] args){
        try {
            // Deserialize Users from disk
            DatumReader<MyClass> datumReader = new SpecificDatumReader<>(MyClass.class);
            DataFileReader<MyClass> dataFileReader = new DataFileReader<>(new File("../data/sample-avro/part-0001.avro"), datumReader);
            MyClass item = null;
            while (dataFileReader.hasNext()) {
                // Reuse user object by passing it to next(). This saves us from
                // allocating and garbage collecting many objects for files with
                // many items.
                item = dataFileReader.next(item);
                System.out.println(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
