package com.lln.api.mapper;

import com.lln.api.constants.Type;
import com.lln.api.domain.Avatar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AvatarMapper {

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Avatar record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Avatar record);

    Avatar selectByUidAndType(@Param("uid") String uid, @Param("type") Integer type);
}