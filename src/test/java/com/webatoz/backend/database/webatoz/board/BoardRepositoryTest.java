package com.webatoz.backend.database.webatoz.board;

import com.webatoz.backend.global.config.database.Webatoz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest  // 가장 간단하게 테스트케이스를 사용할 수 있는 방법.
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(Webatoz.class) // DataSource 생성 타이밍 때문에 별도로 관련 빈 가져오기.
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void simpleJpaTest() {
        boardRepository.findAll();
    }

}