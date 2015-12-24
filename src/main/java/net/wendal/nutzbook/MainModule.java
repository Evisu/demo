package net.wendal.nutzbook;

import org.nutz.integration.shiro.ShiroSessionProvider;
import org.nutz.mvc.annotation.ChainBy;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SessionBy;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * 添加模块类自动扫描
 * 
 * @author walkman
 *
 */
@SetupBy( value = MainSetup.class )
@IocBy( type = ComboIocProvider.class , args = { "*js", "ioc/", "*anno", "net.wendal.nutzbook", "*tx", "*org.nutz.integration.quartz.QuartzIocLoader" } )
@Modules( scanPackage = true )
@ChainBy( args = "mvc/nutzbook-mvc-chain.js" )
@SessionBy( ShiroSessionProvider.class )
public class MainModule
{

}
