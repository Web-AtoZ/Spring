package com.webatoz.backend.database.webatoz.restaurant.menu;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CollectMenuRepositoryImpl implements CollectMenuRepositoryCustom{

    @Qualifier("webatozJPAQueryFactory")
    private final JPAQueryFactory jpaQuery;


    @Override
    public void insertMenu(Menu menu) throws Exception{
    }

}
