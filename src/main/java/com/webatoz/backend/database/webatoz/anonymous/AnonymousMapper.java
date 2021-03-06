package com.webatoz.backend.database.webatoz.anonymous;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AnonymousMapper {
    @Select("SELECT * FROM anonymous WHERE anonymous_id = #{anonymous}")
    Anonymous find(@Param("anonymous") Integer anonymous);
}