/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.films.struts.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.films.domain.Users;
import com.films.service.inter.IUserService;
import com.films.struts.form.RegisterForm;
import com.films.utils.MyTools;

/** 
 * MyEclipse Struts
 * Creation date: 10-07-2012
 * 
 * XDoclet definition:
 * @struts.action parameter="flag"
 */
public class RegisterAction extends DispatchAction {
	/*
	 * Generated Methods
	 */
	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ActionForward regCheck(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email") ;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(userService.checkEmail(email)){
			out.println("�����ѱ�ע�ᣬ�뻻һ������ע�ᣡ");//email already exist,please change a email to keep register	
		}else{
			out.println("����δ��ʹ�ã������ע�� ��");	//the email never be use 
		}
		return null;
	}
	
	public ActionForward reg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RegisterForm regForm = (RegisterForm) form;
		Users user = new Users();
		user.setUemail((regForm.getEmail()));
		user.setUsex(regForm.getSex());
		user.setUpassword(MyTools.MD5(regForm.getPassword()));//�������MD5���ܺ󱣴�
		user.setUrole("user");	
		if(userService.checkEmail(regForm.getEmail())){
			return mapping.findForward("regFail");
		}else{
			userService.save(user);
			request.getSession().setAttribute("loginUser", user);
			return mapping.findForward("regisOK");
		}		
		}
}