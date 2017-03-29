/**
 * @Title: MybatisHelper
 * @Package cn.tc.ulife.platform.server.ware.service.impl
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2017/2/23 11:32
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package cn.tc.ulife.platform.server.shop.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author alliswell008
 * @ClassName: MybatisHelper
 * @Description: TODO(用一句话来说明)
 * @date 2017/2/23 11:32
 */
public class MybatisHelper {

    private static SqlSessionFactory sqlSessionFactory;

    static{

        String resourceLocation = "mybatis-config.xml";

        Reader reader = null;
        try {
            //Resources  mybatis 用来加载各种配置文件，这里我们从类路径加载
            reader = Resources.getResourceAsReader(resourceLocation);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }



}
