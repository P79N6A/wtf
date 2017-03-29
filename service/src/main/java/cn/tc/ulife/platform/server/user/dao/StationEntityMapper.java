package cn.tc.ulife.platform.server.user.dao;


import cn.tc.ulife.platform.server.user.model.StationEntity;

public interface StationEntityMapper {


    int insertSelective(StationEntity stationEntity);

    StationEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StationEntity stationEntity);


}