

hadoop-start

hdfs dfsadmin -safemode leave
hadoop fs -put graph_input.txt

hadoop jar /home/mbds/graph/tp2/tp-1.0.0.jar org.mbds.hadoop.tp2.Graph /graph_input.txt /Gresults

hadoop fs -ls /Gresults/Gresults-step-3

hadoop fs -cat /Gresults-step-3/*


-------------
changer couleur
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