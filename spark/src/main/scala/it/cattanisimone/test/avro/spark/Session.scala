package it.cattanisimone.test.avro.spark

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Session {

    def spark: SparkSession = {
        val conf = new SparkConf()
            .set("spark.network.timeout", "600s")

            .set("spark.driver.memory", "1g")
            .set("spark.driver.cores", "1")
            .set("spark.driver.extraJavaOptions", "-Duser.timezone=UTC")
            .set("spark.executor.memory", "2g")
            .set("spark.executor.cores", "1")
            .set("spark.executor.extraJavaOptions", "-Duser.timezone=UTC")
            .set("spark.default.parallelism", "4")

        SparkSession
            .builder()
            .appName("test-avro-spark")
            .master("local[2]")
            .config(conf)
            .getOrCreate()
    }

}
