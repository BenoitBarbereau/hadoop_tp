/*
  M2 MBDS - Big Data/Hadoop
	Ann��e 2013/2014
  --
  TP1: exemple de programme Hadoop - compteur d'occurences de mots.
  --
  GraphReduce.java: classe REDUCE.
*/
package org.mbds.hadoop.tp2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.Iterator;
import java.io.IOException;

public class GraphReduce extends Reducer<Text, Text, Text, Text>
{
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException,
			InterruptedException
	{
		int new_depth=-1;
		String new_neighbours="";
		String new_color="";
		Iterator<Text> i=values.iterator();
		while(i.hasNext())
		{
			Text node=i.next();
			int depth=-2;
			String neighbours="";
			String colour="";
			String[] parts=node.toString().split("\\|");
			if(parts.length!=3)
				continue;
			neighbours=parts[0];
			colour=parts[1];
			try {
			depth=Integer.parseInt(parts[2]);
		} catch(Exception e) {
			depth=-2;
		}
			if(depth==-2)
				continue;

			if(depth>new_depth)
				new_depth=depth;
			if(neighbours.length()>new_neighbours.length())
				new_neighbours=neighbours;
			if((new_color.equals("")) || ((new_color.equals("BLANC") && (colour.equals("GRIS") ||
					colour.equals("NOIR"))) ||
					(new_color.equals("GRIS") && (colour.equals("NOIR")))))
			{
				new_color=colour;
			}
		}
		if(!new_color.equals("NOIR"))
			context.getCounter(Graph.GRAPH_COUNTERS.NB_NODES_UNFINISHED).increment(1);
		context.write(key, new Text(new_neighbours+"|"+new_color+"|"+new_depth));
	}
}