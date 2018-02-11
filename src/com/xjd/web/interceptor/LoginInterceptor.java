package com.xjd.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
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
