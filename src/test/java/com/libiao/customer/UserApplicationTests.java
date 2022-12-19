package com.libiao.customer;

import com.libiao.customer.util.SystemConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UserApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void FilePathTest() throws FileNotFoundException {
		File file = new File("lb-file\\t\\33\\t_af\\2\\微信图片_20221011091807.jpg");
		FileInputStream fis = new FileInputStream(file);
	}

	@Test
	void getUserSignatureTest() {
		File file = SystemConstant.getUserSignature("1");
		log.info("{}", file.getAbsolutePath());
	}
}
