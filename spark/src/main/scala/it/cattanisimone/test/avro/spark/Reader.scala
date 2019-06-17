package it.cattanisimone.test.avro.spark

object Reader {

    def main(args: Array[String]): Unit = {

        val spark = Session.spark

        val df = spark.read
            .format("avro")
            .load("../data/sample-avro/part-*.avro")

        df.show(100)

    }

}
