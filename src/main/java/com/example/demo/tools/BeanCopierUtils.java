package com.example.demo.tools;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * <p>
 * Bean拷贝工具类
 * </p>
 *
 * @author joker
 * @since 2020/8/6
 */

public enum BeanCopierUtils {

    /**
     * 单例调用入口
     */
    INSTANCE;

    private final Map<String, BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<>();

    private static final Map<String, ConstructorAccess> CONSTRUCTOR_ACCESS_CACHE = new ConcurrentHashMap<>();

//    private static BeanCopierUtils beanCopierUtils;

//    private BeanCopierUtils() {
//    }
//
//    public static BeanCopierUtils getInstance() {
//        if (beanCopierUtils == null) {
//            synchronized (BeanCopierUtils.class) {
//                if (beanCopierUtils == null) {
//                    beanCopierUtils = new BeanCopierUtils();
//                }
//            }
//        }
//        return beanCopierUtils;
//    }

    /**
     * 属性值拷贝
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public void copy(Object source, Object target) {
        Class sourceCls = source.getClass();
        Class targetCls = target.getClass();
        String key = calculateKey(sourceCls, targetCls);
        // 先检查缓存中存在转换的Bean
        BeanCopier beanCopier = BEAN_COPIERS.get(key);
        if (beanCopier == null) {
            beanCopier = BeanCopier.create(sourceCls, targetCls, false);
            BEAN_COPIERS.put(key, beanCopier);
        }
        beanCopier.copy(source, target, null);
    }

    /**
     * 拷贝对象集合
     *
     * @param sourceList  源对象列表
     * @param targetClass 目标对象Class
     * @param <T>         对象类型
     * @return 新对象集合
     */
    public <T> List<T> copyList(List<?> sourceList, Class<T> targetClass) {
        if (sourceList == null || sourceList.isEmpty()) {
            return Collections.emptyList();
        }
        ConstructorAccess<T> constructorAccess = getConstructorAccess(targetClass);
        List<T> resultList = new ArrayList<>(sourceList.size());
        for (Object o : sourceList) {
            T t;
            try {
                t = constructorAccess.newInstance();
                copy(o, t);
                resultList.add(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return resultList;
    }

    /**
     * 获取构造方法 反射生成对象实例
     *
     * @param targetClass 目标Class
     * @param <T>         具体对象
     * @return 返回一个构造器
     */
    private <T> ConstructorAccess<T> getConstructorAccess(Class<T> targetClass) {
        ConstructorAccess<T> constructorAccess = CONSTRUCTOR_ACCESS_CACHE.get(targetClass.getName());
        if (constructorAccess != null) {
            return constructorAccess;
        }
        try {
            constructorAccess = ConstructorAccess.get(targetClass);
            constructorAccess.newInstance();
            CONSTRUCTOR_ACCESS_CACHE.put(targetClass.toString(), constructorAccess);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Create new instance of %s failed: %s", targetClass, e.getMessage()));
        }
        return constructorAccess;
    }

    private String calculateKey(Class source, Class target) {
        return source.getName() + target.getName();
    }
}
