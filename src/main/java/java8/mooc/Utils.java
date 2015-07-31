package java8.mooc;

import java.nio.file.*;

/**
 * @author: mpakhomov
 */
public class Utils {

    public static String getResourcesPath() {
        String path = null;
        try {
            path = Paths.get(Utils.class.getClassLoader().getResource("words.txt").toURI())
                    .getParent().toString() + "/";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return path;
    }
}
