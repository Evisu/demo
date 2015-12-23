package net.wendal.nutzbook.service;

public interface EmailService
{
	/**
	 * 发送邮件
	 * 
	 * @param to
	 * @param subject
	 * @param html
	 * @return
	 */
	boolean send( String to , String subject , String html );
}
