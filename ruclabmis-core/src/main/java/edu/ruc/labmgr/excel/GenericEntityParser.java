package edu.ruc.labmgr.excel;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
public class GenericEntityParser<T> extends POIEntityParser<T> {
    @Override
    public T mapToEntity(Map<String, Object> map) {
        T result = newType();
        if (map != null) {
            try {
                for (String key : map.keySet()) {
                    BeanUtils.setProperty(result, key, map.get(key));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
