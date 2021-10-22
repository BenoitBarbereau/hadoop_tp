package org.mbds.hadoop.tp2;

import java.io.IOException;
import org.apache.hadoop.io.WritableComparable;import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.fs.FSDataOutputStream;import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class GraphNodeWritable implements WritableComparable<GraphNodeWritable> {
    private String[] Voisin = null;
    private String Couleur = "" ;
    private int Profondeur = 0;
    public GraphNodeWritable(String string) {
// TODO Auto-generated constructor stub
        String[] parts = string.split("\\|");
        if (Voisin.length != 3) // Invalide.
            return;
        Voisin = parts[0].split(",");
        Couleur = parts[1];
        Profondeur = -1;
        try {
            Profondeur = Integer.parseInt(parts[2]);
        } catch (Exception e) {
            Profondeur = -1;
        }
    } public void write(DataOutput out) throws IOException {
        Iterator<String> iterator1 = Voisin.iterator();
        Iterator<String> iterator2 = Couleur.iterator();
        Iterator<String> iterator3 = Profondeur.iterator();
        String line = "";
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (!line.equals(""))
                line += ",";
            line += element;
        }
        out.writeChars(line); } public void readFields(DataInput in) throws IOException {
        String line = in.readLine();
        String[] elems = line.split(",");
        Graph = new ArrayList<String>(Arrays.asList(elems));
    } public int getsize() {
        return (Graph.size());
    } public int compareTo(GraphNodeWritable o) {
        int mysize = Graph.size();
        int theirsize = o.getsize();
        return (mysize < theirsize ? -1 : (mysize == theirsize ? 0 : 1));
    } public int hashCode() {
        return Graph.hashCode();
    }

    public String get_serialized() {
    }
}


