import avro.schema
from avro.datafile import DataFileReader, DataFileWriter
from avro.io import DatumReader, DatumWriter

schema = avro.schema.Parse(open('data/schema.avsc', "r").read())

reader = DataFileReader(open("data/sample-avro/part-0001.avro", "rb"), DatumReader())
for row in reader:
    print(row)
reader.close()