package cn.tc.ulife.platform.server.authorization.dao;


import cn.tc.ulife.platform.server.authorization.model.ButtonFront;

public interface SysUrActionMapper {
    int deleteByPrimaryKey(String id);

    int insertButton(ButtonFront buttonFront);


    ButtonFront selectByPrimaryKey(String id);


    int deleteByKey(ButtonFront buttonFront);


}