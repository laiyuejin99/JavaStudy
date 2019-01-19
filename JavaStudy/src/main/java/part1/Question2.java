package part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question2 {
    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        List<String> numberLine = new ArrayList<>();
        for (int i = 0; i < logLines.size(); i++) {
            String item = logLines.get(i);
            int o1Id = item.indexOf(" ");
            String p1 = item.toLowerCase().substring(o1Id - 1, item.length());
            char c = p1.charAt(0);
            if (c > '0' && c < '9') {
                numberLine.add(item);
                logLines.remove(i);
                i--;
            }
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1Id = o1.indexOf(" ");
                String p1 = o1.toLowerCase().substring(o1Id, o1.length()).replace(" ", "").trim();
                int o2Id = o2.indexOf(" ");
                String p2 = o2.toLowerCase().substring(o2Id, o2.length());
                if (!p1.equals(p2)) {
                   return p1.compareTo(p2);
                } else {
                    p1 = o1.toLowerCase().substring(0, o1Id);
                    p2 = o2.toLowerCase().substring(0, o2Id);
                    return p1.compareTo(p2);
                }
            }
        };
        Collections.sort(logLines, comparator);
        logLines.addAll(numberLine);
        return logLines;
    }
}
