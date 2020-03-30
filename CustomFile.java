import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * A File object replacment similar to the one in kotlin.
 * It adds features like .read and .writeText
 */
class CustomFile extends File {
    File file;
    String path;

    /**
     * Constructor with the path as the param
     * @param path (String)
     */
    CustomFile(String path) {
        super(path);
        this.path = path;
        file = new File(path);
    }

    /**
     * Constructor with File as the param
     * @param   file  (File)
     */
    CustomFile(File file) {
        super(file.getPath());
        this.file = file;
        path = file.getPath();
    }

    /**
     * Writes a byte array to a the file
     * @param text      (String)        Writes the bytes to the file
     * @return this     (CustomFile)    Returns this for onelining
     */
    CustomFile writeTextCatchE(String text) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            pw.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Appends a byte array to a the file
     * @param text      (String)        Writes the bytes to the file
     * @return this     (CustomFile)    Returns this for onelining
     */
    CustomFile writeTextCatchE(String text, boolean append) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            if (append) pw.append(text);
            else pw.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Writes a byte array to a the file
     * @param bytes     (byte[])        Writes the bytes to the file
     * @return this     (CustomFile)    Returns this for onelining
     */
    CustomFile writeBytesCatchE(byte[] bytes) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            pw.print(Arrays.toString(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Appends a byte array to a the file
     * @param   bytes       (byte[])        Writes the bytes to the file
     * @param   append      (Boolean)       Checks whether or not to append
     * @return  this        (CustomFile)    Returns this for onelining
     */
    CustomFile writeBytesCatchE(byte[] bytes, boolean append) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            if (append) pw.append(Arrays.toString(bytes));
            else pw.print(Arrays.toString(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Reads line by line and catches error.
     * @return  List<String>     of the file line by line on error returns null
     */
    List<String> readLineCatchE() {
        try {
            return Files.readAllLines(Paths.get(getPath()), StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Reads the whole file out into a string and and catches IOExceptions
     * @return String the entire file as a string or "" on error
     */
    String readCatchE() {
        try {
            return String.join(",", Files.readAllLines(Paths.get(getPath()), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Reads the whole file out into a string and and catches IOExceptions
     * @return String the entire file as a string or "" on error
     */
    String readCatchEJson() {
        try {
            return String.join(",", Files.readAllLines(Paths.get(getPath()), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            return "{}";
        }
    }

    /**
     * Writes text without appending
     * @param   text        (String)        Text to write to the file
     * @return  this        (CustomFile)    this
     * @throws  IOException (Exception)     I dont know what more you want
     */
    CustomFile writeText(String text) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            pw.print(text);
            pw.flush();
            return this;
        }
    }

    /**
     * Write text with append as a choice
     * @param   text        (String)
     * @param   append      (Boolean)
     * @return  this        (CustomFile)
     * @throws  IOException (Exception)
     */
    CustomFile writeText(String text, Boolean append) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            if (append) pw.append(text);
            else pw.print(text);
            pw.flush();
            return this;
        }
    }

    /**
     * Write bytes to file without append
     * @param   bytes       (byte[])
     * @return  this        (CustomFile)
     * @throws  IOException (Exception)
     */
    CustomFile writeBytes(byte[] bytes) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            pw.print(Arrays.toString(bytes));
            return this;
        }
    }

    /**
     * Write bytes to file with append
     * @param   bytes       (byte[])
     * @param   append      (Boolean)
     * @return  this        (CustomFile)
     * @throws  IOException (Exception)
     */
    CustomFile writeBytes(byte[] bytes, Boolean append) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            if (append) pw.print(Arrays.toString(bytes));
            else pw.append(Arrays.toString(bytes));
            return this;
        }
    }

    /**
     * Reads a file into a list of strings
     * @return  lines           (List<String>)
     * @throws  IOException     (Exception)
     */
    List<String> readLines() throws IOException {
        return Files.readAllLines(Paths.get(getPath()), StandardCharsets.UTF_8);
    }

    /**
     * Reads a file into a string
     * @return  text           (String)
     * @throws  IOException     (Exception)
     */
    String read() throws IOException {
        return String.join(",", Files.readAllLines(Paths.get(getPath()), StandardCharsets.UTF_8));
    }

