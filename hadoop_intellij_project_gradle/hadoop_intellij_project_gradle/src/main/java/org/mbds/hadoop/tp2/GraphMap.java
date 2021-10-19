/*
  M2 MBDS - Big Data/Hadoop
	Ann��e 2013/2014
  --
  TP1: exemple de programme Hadoop - compteur d'occurences de mots.
  --
  GraphMap.java: classe MAP.
*/
package org.mbds.hadoop.tp2;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import java.util.StringTokenizer;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;


public class GraphMap extends Mapper<Text, Text, Text, Text>
{
	private static final String GREY="GRIS";
	protected void map(Text key, Text node, Context context) throws IOException, InterruptedException
	{
		String[] parts=node.toString().split("\\|");
		if(parts.length!=3) // Invalide.
			return;
		String[] neighbours=parts[0].split(",");
		String colour=parts[1];
		int depth=-1;
		try {
			depth=Integer.parseInt(parts[2]);
		} catch(Exception e) {
			depth=-1;
		}
		if(depth==-1) // Invalid.
			return;
		if(colour.equals(GREY))
		{
			for(int i=0; i<neighbours.length; ++i)
			{
				if(neighbours[i].equals(""))
					continue;
				context.write(new Text(neighbours[i]), new Text("|"+GREY+"|"+Integer.toString(depth+1)));
			}
			context.write(key, new Text(parts[0]+"|NOIR|"+Integer.toString(depth)));
		}
		else
			context.write(key, node);
	}
}