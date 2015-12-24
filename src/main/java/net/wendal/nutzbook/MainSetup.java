package net.wendal.nutzbook;

import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.integration.quartz.NutQuartzCronJobFactory;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import net.wendal.nutzbook.bean.User;
import net.wendal.nutzbook.service.UserService;

public class MainSetup implements Setup
{
	public void init( NutConfig conf )
	{
		Ioc ioc = conf.getIoc();
		Dao dao = ioc.get( Dao.class );
		Daos.createTablesInPackage( dao, "net.wendal.nutzbook", false );

		// 初始化默认根用户
		if ( dao.count( User.class ) == 0 )
		{
			UserService us = ioc.get( UserService.class );
			us.add( "admin", "123456" );
		}

		// 获取NutQuartzCronJobFactory从而触发计划任务的初始化与启动
		ioc.get( NutQuartzCronJobFactory.class );

		// TODO 测试发送邮件未成功 可能是服务器参数设置问题
		// 测试发送邮件
		// try {
		// HtmlEmail email = ioc.get(HtmlEmail.class);
		// email.setSubject("测试NutzBook");
		// email.setMsg("This is a test mail ... :-)" +
		// System.currentTimeMillis());
		// email.addTo("guochen-1988@163.com");//请务必改成您自己的邮箱啊!!!
		// email.buildMimeMessage();
		// email.sendMimeMessage();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	public void destroy( NutConfig conf )
	{
	}
}
