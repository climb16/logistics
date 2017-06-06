package com.yx.logistics.config;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

/**
 * author : Guo LiXiao
 * date : 2017-5-31  18:52
 */

public class WebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {

    private static final String SERVLET_NAME = "spring-mvc";
    /*@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{BackConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding(Config.ENCODING);
        filter.setForceEncoding(true);
        return new Filter[]{filter};
    }
*/
    /**
     * 服务器启动调用此方法，在这里可以做配置 作用与web.xml相同
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 注册springMvc的servlet
        this.addServlet(servletContext);
        // 注册过滤器
        // servletContext.addFilter(arg0, arg1)
        // 注册监听器
        // servletContext.addListener(arg0);
    }

    /**
     * 注册Spring servlet
     *
     * @param servletContext
     */
    private void addServlet(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(MvcConfig.class, BackConfig.class);
        // 注册spring mvc 的 servlet
        ServletRegistration.Dynamic dynamic = servletContext.addServlet(SERVLET_NAME, new DispatcherServlet(webContext));
        // 添加springMVC 允许访问的Controller后缀
        // 全部通过请用 “/”
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }

}
