import org.json.JSONObject;
import org.apache.commons.io.FileUtils;
import java.io.File;

class Utils {

    /* This method avoids duplicating the database opening code for subclasses
     *
     * @param  path  the path to the database
     * @return       a JSONObject representing the database
     */
    public static JSONObject ReadDatabase(String path) {
        try {
            File file = new File(path);
            String content = FileUtils.readFileToString(file, "utf-8");

            return new JSONObject(content);
        }
        catch (Exception e) { System.out.print(e); }

        return new JSONObject();
    }
}
