package com.webatoz.backend.services.anonymous;

import com.webatoz.backend.database.webatoz.anonymous.Anonymous;
import com.webatoz.backend.database.webatoz.anonymous.AnonymousMapper;
import com.webatoz.backend.database.webatoz.anonymous.AnonymousRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnonymousService {

    private final AnonymousMapper anonymousMapper;

    private final AnonymousRepository anonymousRepository;

    public List<Anonymous> findAnonymousByName(String name){
//        anonymousRepository.findAnonymousByName(name);
        return anonymousRepository.findAll();

    }

    @Transactional
    public void updateName(Anonymous a) {
//        anonymousRepository.updateName(a.getName(), a.getAnonymousId());
        Anonymous anonymous = anonymousRepository.findById(1L).get();
        anonymous.setName("아우");

        anonymousRepository.save(anonymous);
    }

    @Transactional
    public void deleteId(Anonymous a) {
        Anonymous anonymous = anonymousRepository.findById(1L).get();
        anonymousRepository.delete(anonymous);
    }
}
