var avro = require('avro-js');

avro.createFileDecoder('data/generated-java-appender.avro')
  .on('metadata', function (type) { /* `type` is the writer's type. */ })
  .on('data', function (record) { console.log(record) })
  .on('close', () => console.log("closed"))