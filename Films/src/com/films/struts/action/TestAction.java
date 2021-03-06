/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.films.struts.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.films.service.TestService;



/** 
 * MyEclipse Struts
 * Creation date: 10-06-2012
 * 
 * XDoclet definition:
 * @struts.action parameter="flag"
 */
public class TestAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	@Resource
	private TestService testService;
	public TestService getTestService() {
		return testService;
	}
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	public ActionForward test(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.servlet.getServletContext());
//		TestService ts = (TestService) ctx.getBean("testService");
		List list = testService.showArea();
		request.setAttribute("list", list);
		return mapping.findForward("show");
	}
}