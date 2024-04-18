package Task3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileManager {
    public static void main(String[] args) {

        final String[][] pathArr = {new String[0]};
        try (Stream<Path> filePathStream = Files.walk(Paths.get("src/Task3/Directory_for_lab3/"))) {
            filePathStream.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    System.out.println(filePath);
                    pathArr[0] = Arrays.copyOf(pathArr[0], pathArr[0].length + 1);
                    pathArr[0][pathArr[0].length - 1] = filePath.toString();
                }
            });
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String path : pathArr[0]) {
            String separator = "\\";
            String[] name = path.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
            if (name[name.length - 1].endsWith(".pptx")) {
                copy(path, "src/Task3/Folders/Lectures/");
            }
            if (name[name.length - 1].startsWith("Lab")) {
                copy(path, "src/Task3/Folders/Assignments/");
            }
            if (name[name.length - 1].startsWith("Questions")) {
                copy(path, "src/Task3/Folders/Questions/");
            }
        }
    }

    public static void copy(String src, String dest) {
        File srcFile = new File(src);
        if (srcFile.exists()) {
            File destfile = new File(dest + File.separator + srcFile.getName());
            try (InputStream is = new FileInputStream(srcFile); OutputStream os = new FileOutputStream(destfile)) {
                int len;
                float srcFileSize = is.available() / 1000.0f;
                float totalCopied = 0.0f;
                byte[] bytes = new byte[1024];
                while ((len = is.read(bytes)) > 0) {
                    os.write(bytes, 0, len);
                    totalCopied += len;
                    System.out.print("\rCopied... " + totalCopied / 1000.0f + "kb/" + srcFileSize + "kb/");
                    Thread.sleep(5);
                }
                System.out.println("File copied!");
            }
            catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
