name := "test-avro-spark"

version := "0.1"

scalaVersion := "2.11.11"

val sparkVersion = "2.4.3"

libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion,
    "org.apache.spark" %% "spark-sql" % sparkVersion,
    "org.apache.spark" %% "spark-avro" % sparkVersion
)

fork := true