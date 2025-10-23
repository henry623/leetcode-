package Test;

import java.sql.SQLOutput;
import java.util.*;

public class rongyao2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String[]> rows = new ArrayList<>();
        while(in.hasNextLine()){
            String line = in.nextLine().trim();
            if(line.isEmpty()) break;
            String[] cells = line.split(",");
            for (int i = 0; i < cells.length; i++) {
                cells[i] = cells[i].trim();
            }
            rows.add(cells);
        }
        if (rows.isEmpty()){
            return;
        }
        int maxColumns = 0;
        for (String[] row : rows) {
            maxColumns = Math.max(maxColumns, row.length);
        }

        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);
            if(row.length < maxColumns){
                String[] newRow = new String[maxColumns];
                System.arraycopy(row, 0, newRow, 0, row.length);
                for(int j = row.length; j < maxColumns; j++){
                    newRow[j] = "";
                }
                rows.set(i, newRow);
            }
        }

        int[] columnWidths = new int[maxColumns];
        for (int i = 0; i < maxColumns; i++) {
            int maxWidth = 0;
            for (String[] row : rows) {
                if (i < row.length && row[i].length() > maxWidth) {
                    maxWidth = row[i].length();
                }
            }
            columnWidths[i] = maxWidth;
        }
        StringBuilder sb = new StringBuilder("+");
        for (int width : columnWidths) {
            for (int i = 0; i < width; i++) {
                sb.append("-");
            }
            sb.append("+");
        }

        for(String[] row:rows){
            System.out.println(sb);
            StringBuilder sb2 = new StringBuilder("|");
            for (int i = 0; i < maxColumns; i++) {
                String cell = i < row.length ? row[i] : "";
                sb2.append(String.format("%" + columnWidths[i] + "s", cell)).append("|");
            }
            System.out.println(sb2);
        }
        System.out.println(sb);
    }
}
