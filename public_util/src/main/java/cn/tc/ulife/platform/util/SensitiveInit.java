package cn.tc.ulife.platform.util;
import java.util.*;

/**
 * 初始化敏感词库
 *
 * @author wy
 */
public class SensitiveInit {

    // private String ENCODING = "UTF-8"; // 字符编码
    @SuppressWarnings("rawtypes")
    public HashMap sensitiveWordMap;

    public SensitiveInit() {
        super();
    }

    /**
     *
     */
    @SuppressWarnings("rawtypes")
    public Map initKeyWord() {
        try {
            // 读取敏感词库
            Set<String> keyWordSet = readSensitiveWordFile();
            // 将敏感词库加入到HashMap中
            addSensitiveWordToHashMap(keyWordSet);
            // spring获取application，然后application.setAttribute("sensitiveWordMap",sensitiveWordMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sensitiveWordMap;
    }

    /**
     * 读取敏感词库，将敏感词放入HashSet中，
     */
    @SuppressWarnings(
            {"rawtypes", "unchecked"})
    private void addSensitiveWordToHashMap(Set<String> keyWordSet) {
        sensitiveWordMap = new HashMap(keyWordSet.size()); // 初始化敏感词容器，减少扩容操作
        String key = null;
        Map nowMap = null;

        Map<String, String> newWorMap = null;

        // 迭代keyWordSet
        Iterator<String> iterator = keyWordSet.iterator();

        while (iterator.hasNext()) {

            key = iterator.next(); // 关键字
            nowMap = sensitiveWordMap;

            for (int i = 0; i < key.length(); i++) {
                char keyChar = key.charAt(i); // 转换成char型
                Object wordMap = nowMap.get(keyChar); // 获取

                if (wordMap != null) { // 如果存在该key，直接赋值
                    nowMap = (Map) wordMap;
                } else { // 不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWorMap = new HashMap<String, String>();
                    newWorMap.put("isEnd", "0"); // 不是最后一个
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if (i == key.length() - 1) {
                    nowMap.put("isEnd", "1"); // 最后一个
                }
            }
        }
    }

    /**
     * 读取敏感词库中的内容，将内容添加到set集合中
     */
    private Set<String> readSensitiveWordFile() throws Exception {

        Set<String> set = new HashSet<String>();
//
//        byte[] bytes = null;
//        Jedis cn.tc.ulife.platform.util.jedis = null;
//        try {
//            cn.tc.ulife.platform.util.jedis = JedisTool.getJedis();
//
//            bytes = cn.tc.ulife.platform.util.jedis.get("mgc".getBytes());
//            JedisTool.returnResource(cn.tc.ulife.platform.util.jedis);
//        } catch (Exception e) {
//            JedisTool.returnResource(cn.tc.ulife.platform.util.jedis);
//            e.printStackTrace();
//        }
//        ListSerializeUtil<SysMgzBean> listSerializeUtil = new ListSerializeUtil<SysMgzBean>();
//        if (bytes != null) {
//            List<SysMgzBean> beans = listSerializeUtil.unserialize(bytes);
//
//            for (SysMgzBean bean : beans) {
//                set.add(bean.getmText());
//            }
//        } else {
//            set.add("XX");
//        }

        return set;
    }
}
