package com.xjd.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{
private String ignoreActions;

	public String getIgnoreActions() {
	return ignoreActions;
}

public void setIgnoreActions(String ignoreActions) {
	this.ignoreActions = ignoreActions;
}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext ctx=invocation.getInvocationContext();
		Map session=ctx.getSession();
		Object user= session.get("loginUser");		
		boolean ignore=false;
		String currentAction=invocation.getProxy().getActionName();
		String[] actions=ignoreActions.split(",");
		for(String action:actions){
			if(action.trim().equals(currentAction)){
				ignore=true;
				break;
			}
		}
		if(user!=null||ignore){
			return invocation.invoke();
		}else{
			return Action.LOGIN;
		}
		
	}

}
