package com.xjd.web.interceptor;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import com.opensymphony.xwork2.util.ValueStack;
import com.xjd.web.util.It;
import org.apache.log4j.Logger;

public class LoginInterceptor extends AbstractInterceptor {
    private String ignoreActions;

    public String getIgnoreActions() {
        return ignoreActions;
    }

    public void setIgnoreActions(String ignoreActions) {
        this.ignoreActions = ignoreActions;
    }

  public  static final   Logger logger = Logger.getLogger(LoginInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ctx = invocation.getInvocationContext();
        ValueStack ob = invocation.getStack();
        Map<String, Object> m = ob.getContext();
       Map<String,Object>  ss= (Map<String, Object>) m.get("session");
        Set<Map.Entry<String, Object>> it1 = ss.entrySet();
        for (Map.Entry<String, Object> stringObjectEntry : it1) {
            stringObjectEntry.getClass();
        }
        for (String s : ss.keySet()) {
            System.out.println(ss.get(s));
        }

        Iterator<Map.Entry<String, Object>> it = m.entrySet().iterator();
        for (String s : m.keySet()) {
            System.out.println(m.keySet());
        }

        Map session = ctx.getSession();
        Object user = session.get("loginUser");
        boolean ignore = false;
        String currentAction = invocation.getProxy().getActionName();
        String[] actions = ignoreActions.split(",");
        for (String action : actions) {
            if (action.trim().equals(currentAction)) {
                ignore = true;
                break;
            }
        }
        if (user != null || ignore) {
            return invocation.invoke();
        } else {
            logger.error(currentAction+"\twas intercepter by\t"+LoginInterceptor.class.getName());
            return Action.LOGIN;
        }

    }

}
