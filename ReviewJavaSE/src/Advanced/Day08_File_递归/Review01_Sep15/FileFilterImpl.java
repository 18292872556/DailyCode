package Advanced.Day08_File_递归.Review01_Sep15;

import java.io.File;
import java.io.FileFilter;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/10/17/下午4:49
 * @Description:
 */
public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(".java") || file.isDirectory();
    }
}
