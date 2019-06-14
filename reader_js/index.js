var avro = require('avro-js');

var type = avro.parse('data/schema.avsc');

avro.createFileDecoder('data/sample-avro/part-0001.avro')
  .on('metadata', function (type) { /* `type` is the writer's type. */ })
  .on('data', function (record) { console.log(record) });