package com.webatoz.backend.interfaces;

import com.webatoz.backend.database.webatoz.anonymous.Anonymous;
import com.webatoz.backend.database.webatoz.anonymous.AnonymousRepository;
import com.webatoz.backend.services.anonymous.AnonymousService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final AnonymousService anonymousService;

    private final AnonymousRepository anonymousRepository;

    @GetMapping("/user")
    public String getName() {
        return anonymousService.getName().getName();
    }


    @GetMapping("/select")
    public int select() {
        Anonymous a = new Anonymous();
        a.setName("예민한 너구리");
        anonymousService.findAnonymousByName(a.getName());

        return anonymousService.findAnonymousByName(a.getName()).size();
    }

    @GetMapping("/update")
    public void update() {
        Anonymous a = new Anonymous();
        a.setName("깜찍한 비둘기");
        a.setAnonymous_id(2L);
        anonymousService.updateName(a);
    }

    @GetMapping("/delete")
    public void delete() {
        Anonymous a = new Anonymous();
        a.setAnonymous_id(2L);
        anonymousService.deleteId(a);
    }
}