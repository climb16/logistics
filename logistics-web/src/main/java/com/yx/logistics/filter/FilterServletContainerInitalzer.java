package com.yx.logistics.filter;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/**
 * author : Guo LiXiao
 * date : 2017-6-5  13:24
 */

@HandlesTypes(Filter.class)
public class FilterServletContainerInitalzer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        if(set != null) {
            Iterator iterator = set.iterator();
            while(iterator.hasNext()) {
                Class<?> waiClass = (Class)iterator.next();
                if(!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) && Filter.class.isAssignableFrom(waiClass)) {
                    try {
                        Filter filter = (Filter) waiClass.newInstance();
                        FilterRegistration.Dynamic dynamic = servletContext.addFilter(waiClass.getTypeName(), filter);
                        dynamic.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), true, filter.getContextPath());
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
