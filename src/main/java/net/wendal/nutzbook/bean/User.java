package net.wendal.nutzbook.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table( "t_user" )
public class User extends BasePojo
{
	@Id
	private int id;
	@Name
	@Column
	private String name;
	@Column( "passwd" )
	@ColDefine( type = ColType.VARCHAR , width = 200 )
	private String password;
	@Column
	private String salt;
	@Column
	private boolean locked;
	@ManyMany( from = "u_id" , relation = "t_user_role" , target = Role.class , to = "role_id" )
	protected List< Role > roles;
	@ManyMany( from = "u_id" , relation = "t_user_permission" , target = Permission.class , to = "permission_id" )
	protected List< Permission > permissions;
	@One( target = UserProfile.class , field = "id" , key = "userId" )
	protected UserProfile profile;

	public int getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	public String getSalt()
	{
		return salt;
	}

	public void setSalt( String salt )
	{
		this.salt = salt;
	}

	public UserProfile getProfile()
	{
		return profile;
	}

	public void setProfile( UserProfile profile )
	{
		this.profile = profile;
	}

	public boolean isLocked()
	{
		return locked;
	}

	public void setLocked( boolean locked )
	{
		this.locked = locked;
	}

	public List< Role > getRoles()
	{
		return roles;
	}

	public void setRoles( List< Role > roles )
	{
		this.roles = roles;
	}

	public List< Permission > getPermissions()
	{
		return permissions;
	}

	public void setPermissions( List< Permission > permissions )
	{
		this.permissions = permissions;
	}

}
