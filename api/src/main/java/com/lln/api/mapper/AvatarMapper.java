package com.lln.api.mapper;

import com.lln.api.domain.Avatar;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AvatarMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(Avatar record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Avatar record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Avatar selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Avatar record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Avatar record);

    Avatar selectByUid(String uid);

    boolean isExist(String uid);
}