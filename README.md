
## Hadoop Graph

#### Command Line Interpretor


* Launch hadoop
hadoop-start

* Give right to load files on hdfs
hdfs dfsadmin -safemode leave

* load graph_input on hdfs
hadoop fs -put graph_input.txt

* Execute tp-1.0.0.jar (compiled java files) with hadoop, Class Graph on package (org.mbds.hadoop.tp2) input = /graph_input.txt output= /Gresults
hadoop jar /home/mbds/graph/tp2/tp-1.0.0.jar org.mbds.hadoop.tp2.Graph /graph_input.txt /Gresults
* read results
hadoop fs -ls /Gresults/Gresults-step-3
hadoop fs -cat /Gresults-step-3/*


-------------
Change colors (eng->fr)
-------------

change COLOR GREY = GRIS | 

---> RESULT

		mbds@hadoopvm:~$ hadoop fs -cat /Gresults3-step-2/*
		2021-10-19 15:48:39,359 INFO sasl.SaslDataTransferClient: SASL encryption trust check: localHostTrusted = false, remoteHostTrusted = false
		1       2,5|NOIR|0
		2       |NOIR|1
		5       |NOIR|1

-------------
SUPPR code GraphMap
-------------


		if(depth==-1) // Invalid.
			return;


---> RESULT

		2021-10-19 15:58:38,631 INFO sasl.SaslDataTransferClient: SASL encryption trust check: localHostTrusted = false, remoteHostTrusted = false
		1       2,5|NOIR|0
		2       3,4|NOIR|1
		3       6|NOIR|2
		4       |NOIR|2
		5       6|NOIR|1
		6       |NOIR|3
