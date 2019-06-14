# Avro Test

Use `http://avro4s-ui.landoop.com/` for schema generation from JSON files.

## CLI converter

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

## Java
```sh
java -jar avro-tools-1.9.0.jar compile schema data/schema.avsc . java/src/main/java
```

### Java reader

##### Run reader
- open project with IntelliJ
- run `ReaderJava.main` function

## Python

### Python reader

##### Install python dependency 
```sh
wget http://mirror.nohup.it/apache/avro/avro-1.9.0/py3/avro-python3-1.9.0.tar.gz
tar -xzf avro-python3-1.9.0.tar.gz
cd avro-python3-1.9.0
sudo python3 setup.py install
```

##### Run reader
```sh
python3 python/reader.py
```

## JS

### JS reader

##### Install dependencies
```sh
cd js
npm install
```

##### Run reader
```sh
node js/reader.jsg
```