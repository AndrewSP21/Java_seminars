import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findDuplicateFileIinSystem {
    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            String directory = files[0] + "/";

            for (int i = 1; i < files.length; i++) {
                int index = files[i].indexOf("(");

                String fileName = files[i].substring(0, index);
                String fileContent = files[i].substring(index + 1, files[i].length() - 1);

                map.putIfAbsent(fileContent, new ArrayList<String>());
                map.get(fileContent).add(directory + fileName);
            }
        }
        List<List<String>> duplicateList = new ArrayList<>();
        for (List<String> file : map.values()) {
            if (file.size() > 1) {
                duplicateList.add(file);
            }

        }
        return duplicateList;
    }
}
