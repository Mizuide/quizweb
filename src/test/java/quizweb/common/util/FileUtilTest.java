package quizweb.common.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quizweb.common.properties.ApplicationProperties;

@SpringBootTest
public class FileUtilTest {

    @Autowired
    ApplicationProperties applicationProperties;

    @Test
    public void test1() throws IOException {
        Path path = Paths.get("src/test/resources/base64.txt");
        FileReader fr = new FileReader(path.toFile());
        BufferedReader bufferedReader = new BufferedReader(fr);
        String data;
        StringBuilder sb = new StringBuilder();
        while ((data = bufferedReader.readLine()) != null) {
            sb.append(data);
        }
        FileUtil.saveImageByBase64(applicationProperties.getImageChoicePath(), sb.toString());
    }
}
