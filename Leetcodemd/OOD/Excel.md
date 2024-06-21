<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 这是一道模拟Excel 的题目， 需要implement 
1. get(x, y)
2. set(x, y, value)
3. addRow()
4. addRow(index)
5. removeRow(index)
6. addColumn()
7. addColumn(index)
8. removeColume(index)
*/
/**
 * Created by xiangtiangu on 12/17/18.
 */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

import java.util.*;
public class Spreadsheet {
    LinkedList<LinkedList<String>> data;
    public Spreadsheet() {
        data = new LinkedList<LinkedList<String>>();
        addRow();
        addColumn();
    }

    public int getWidth() {
        return data.getFirst().size();
    }

    public int getHeight() {
        return data.size();
    }

    public void addRow() {
        data.addLast(new LinkedList<String>());
        for (int x = 0; x < getWidth(); x++) {
            data.getLast().add(new String());
        }
    }

    public void addRow(int index) {
        data.add(index, new LinkedList<String>());
        for (int x = 0; x < getWidth(); x++) {
            data.get(index).add(new String());
        }
    }

    public void removeRow(int index) {
        data.remove(index);
    }



    public void addColumn() {
        for (LinkedList l : data) {
            l.addLast(new String());
        }
    }

    public void addColumn(int index) {
        for (LinkedList l : data) {
            l.add(index, new String());
        }
    }

    public void removeColumn(int index) {
        for (LinkedList l : data) {
            l.remove(index);
        }
    }

    public void setCell(int x, int y, String newData) {
        data.get(x).set(y, newData);
    }


    public String toString() {
        String temp = "";
        for (LinkedList l : data) {
            for (Object o : l) {
                String s = (String) o;
                if (s.equals("")) {
                    s = "-empty-";
                }
                temp += s + " ";
            }
            temp += "\n";
        }

        return temp;
    }

    public static void main(String[] args) {
        Spreadsheet sheet = new Spreadsheet();
        System.out.println(sheet.toString());

        sheet.addRow();

        System.out.println(sheet.toString());
        sheet.addColumn();
        System.out.println(sheet.toString());
        sheet.setCell(0,0,"1");
        sheet.setCell(0,1,"2");
        sheet.setCell(1,0,"3");
        sheet.setCell(1,1,"4");
        System.out.println(sheet.toString());
        sheet.addColumn(1);
        System.out.println(sheet.toString());

        sheet.setCell(1,0, "TEMP");
        sheet.setCell(1,1, "TEMP");
        System.out.println(sheet.toString());

        sheet.removeRow(1);
        System.out.println(sheet.toString());


        sheet.removeColumn(1);
        System.out.println(sheet.toString());

        sheet.addRow();
        System.out.println(sheet.toString());

        sheet.addColumn();
        System.out.println(sheet.toString());
    }
}

</code></pre>
</div>
</div>
