# Avro Test

## CLI converter

##### Generate schema
```
http://avro4s-ui.landoop.com/
```

##### Download tool
```sh
wget http://mirror.nohup.it/apache/avro/avro-1.9.0/java/avro-tools-1.9.0.jar
```

##### Convert single file into Avro
```sh
mkdir -p data/sample-avro
java -jar avro-tools-1.9.0.jar fromjson --schema-file data/schema.avsc ./data/sample-json/part-00001.json > data/sample-avro/part-0001.avro
java -jar avro-tools-1.9.0.jar fromjson --schema-file data/schema.avsc ./data/sample-json/part-00002.json > data/sample-avro/part-0002.avro
java -jar avro-tools-1.9.0.jar fromjson --schema-file data/schema.avsc ./data/sample-json/part-00003.json > data/sample-avro/part-0003.avro
```

## Python reader

##### Install python dependency 
```sh
wget http://mirror.nohup.it/apache/avro/avro-1.9.0/py3/avro-python3-1.9.0.tar.gz
tar -xzf avro-python3-1.9.0.tar.gz
cd avro-python3-1.9.0
sudo python3 setup.py install
```

##### Run reader
```sh
python3 reader_python/main.py
```

## JS reader

##### Install dependencies
```sh
cd reader_js
npm install
```

##### Run reader
```sh
node reader_js/index.jsg
```