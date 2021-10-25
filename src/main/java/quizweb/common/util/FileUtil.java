package quizweb.common.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.ResourceUtils;

public class FileUtil {
    public static String saveImageByBase64(String dirPath, String base64DataURL) throws IOException {
        String extensionReg = "data:image/(.*?);base64,";
        Pattern pt = Pattern.compile(extensionReg);
        Matcher mt = pt.matcher(base64DataURL);

        mt.find();

        String extension = mt.group(1);
        String fileName = String.valueOf(System.currentTimeMillis()) + "." + extension;
        String absolutePath = ResourceUtils.getFile(dirPath).getAbsolutePath();
        try (FileOutputStream fos = new FileOutputStream(absolutePath + "/" + fileName)) {
            byte[] data = Base64.getDecoder().decode(base64DataURL.replaceFirst(extensionReg, "").getBytes());
            fos.write(data);
        }

        return fileName;
    }

    private void checkImage() {
        // TODO:implements
    }

}
