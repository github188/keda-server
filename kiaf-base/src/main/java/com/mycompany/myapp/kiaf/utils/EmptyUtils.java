package com.mycompany.myapp.kiaf.utils;

import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;

/**
 * Created by keda on 2019/3/22.
 */
public class EmptyUtils {
    public static boolean isEmpty(Object bean) {
        PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(bean);
        for (PropertyDescriptor origDescriptor : origDescriptors) {
            String name = origDescriptor.getName();
            if ("class".equals(name)) {
                continue;
            }
            if (PropertyUtils.isReadable(bean, name)) {
                try {
                    Object value = PropertyUtils.getSimpleProperty(bean, name);
                    if (value == null) {
                        continue;
                    } else {
                        return false;
                    }
                } catch (java.lang.IllegalArgumentException ie) {
                    ;
                } catch (Exception e) {
                    ;
                }
            }
        }
        return true;
    }
}
