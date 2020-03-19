package com.test.hello.services.anonymous;

import com.test.hello.database.webatoz.anonymous.Anonymous;
import com.test.hello.database.webatoz.anonymous.AnonymousMapper;
import com.test.hello.database.webatoz.anonymous.AnonymousRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnonymousService {

    private final AnonymousMapper anonymousMapper;

    private final AnonymousRepository anonymousRepository;

    public Anonymous getName(){
        return anonymousRepository.findById("잘생긴도마뱀").get();
    }

    public List<Anonymous> findAnonymousByName(String name){
        return anonymousRepository.findAnonymousByName(name);
    }

    @Transactional
    public void updateName(Anonymous a) {
        anonymousRepository.updateName(a.getName(),a.getAnonymous_id());
    }

    @Transactional
    public void deleteId(Anonymous a) {
        anonymousRepository.deleteId(a.getAnonymous_id());
    }
}
