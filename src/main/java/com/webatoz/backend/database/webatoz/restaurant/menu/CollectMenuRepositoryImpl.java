package com.webatoz.backend.database.webatoz.restaurant.menu;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

@RequiredArgsConstructor
public class CollectMenuRepositoryImpl implements CollectMenuRepositoryCustom{

    @Qualifier("webatozJPAQueryFactory")
    private final JPAQueryFactory jpaQuery;


    @Override
    public void insertMenu(Menu menu) throws Exception{
    }

}
