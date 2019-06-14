Number.prototype.truncate = function(digits) {
    var re = new RegExp("(\\d+\\.\\d{" + digits + "})(\\d)"),
        m = this.toString().match(re);
    return m ? parseFloat(m[1]) : this.valueOf();
};

function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

let generateSample = () => {
    var temp_min = Math.random() * 30 + 10
    var temp_max = temp_min + Math.random() * 5
    var rainfall = Math.random() > 0.6 ? Math.random() * 20 : 0
    return {
        "date":"2019-05-1",
        "temp_min": temp_min.truncate(1),
        "temp_max": temp_max.truncate(1),
        "rainfall": rainfall.truncate(3),
        "evaporation":"",
        "sunshine":"",
        "wind_direction":"NNW"
    }
}

///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////

var fs = require('fs')
var avro = require('avro-js');

var type = avro.parse('data/schema.avsc');
  
function readFromFile() {
    let i = 1;
    avro.createFileDecoder('test.avro')
      .on('metadata', function (type) {
          console.log('metadata', type);
          console.log();
       })
      .on('data', function (record) {
          console.log('record', i++, ':', record);
      });
  }

const encoder = avro.createFileEncoder('test.avro', type, {});
const encoder = new avro.streams.BlockEncoder(type)
encoder.write(generateSample());
encoder.end(
    generateSample(),
    readFromFile
);

let run = () => 
    sleep(1000)
        .then(r => generateSample())
        .then(sample => encoder.write(sample))
//        .then(sample => type.toBuffer(sample))
//        .then(buf => 
//            fs.appendFile('test.avro', buf.toString(), (err) => {
//                if(!err) console.log('Data written');
//            })
//        )
        .then(r => console.log("done: " + r))
        .then(r => run())

//run()
//    .catch(e => console.error(e))

