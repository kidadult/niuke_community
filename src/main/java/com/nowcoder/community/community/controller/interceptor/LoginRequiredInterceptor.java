package com.nowcoder.community.community.controller.interceptor;

import com.nowcoder.community.community.annotation.LoginRequired;
import com.nowcoder.community.community.utils.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果拦截的是一个方法,那么就接着进行处理,因为拦截可能还会拦截其他资源,比如静态资源
        // 在这里我们只判定方法
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);  // 拦截带有@LoginRequired注解的方法--进行精准拦截
            if (loginRequired != null && hostHolder.getUser() == null) {
                response.sendRedirect(request.getContextPath() + "/login"); // 拒绝后续的请求,使用response机进行重定向
                return false;
            }
        }
        return true;
    }
}
