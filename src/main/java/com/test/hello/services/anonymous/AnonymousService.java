package com.test.hello.services.anonymous;

import com.test.hello.database.webatoz.anonymous.Anonymous;
import com.test.hello.database.webatoz.anonymous.AnonymousMapper;
import com.test.hello.database.webatoz.anonymous.AnonymousRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnonymousService {

    private final AnonymousMapper anonymousMapper;

    private final AnonymousRepository anonymousRepository;

    public Anonymous getName(){
        return anonymousRepository.findById("잘생긴도마뱀").get();
    }

    public String getName2(){
        return anonymousMapper.find(1).getName();
    }
}
