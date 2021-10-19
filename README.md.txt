

hadoop-start




hdfs dfsadmin -safemode leave
hadoop fs -put graph_input.txt




hadoop jar /home/mbds/graph/tp2/tp-1.0.0.jar org.mbds.hadoop.tp2.Graph /graph_input.txt /Gresults
