#建立项目的数据库表

# Modle One   权限模块 [基于RBAC的设计模式去设计表,非常灵活，扩展性好]
	# airsys_user 
	# airsys_role 
	# airsys_resource
# Modle Two   人资模块 [其实并没有统一的标准，就是根据实际情况去设计表]
	#...
	#...
	#...
# Modle Three 行政模块 [子模块也很多 比如考勤管理、车辆管理、办公用品管理]
	#...
	#...
	#...
# 例子模块 仅有一张表
	create table if not exists account{
		id int primary key auto_increment,
		name varchar(50) not null,
		balance double
	}
	
	
	create table if not exists user{
		id int primary key auto_increment,
		name varchar(50) not null,
		age integer
	}
	insert into user(name,age) values('zs',18)
	