/* SimpleApp.scala */
import org.apache.spark.sql.SparkSession

//run this command
/*
$SPARK_HOME/bin/spark-submit   --class "SimpleApp"   --master local[4]   target/scala-2.11/simple-project_2.11-1.0.jar
*/

object SimpleApp {
  def main(args: Array[String]) {
    val logFile = "/Users/Shiv/Desktop/test.txt" // Should be some file on your system
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    val logData = spark.read.textFile(logFile)

    val bro = logData.rdd.map(line => line.split(" ").size).reduce((a, b) =>  a + b)
    println(s"Total Number of words: $bro")

    spark.stop()
  }
}