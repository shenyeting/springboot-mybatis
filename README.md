mybatis官网文档 http://www.mybatis.org/mybatis-3/zh/getting-started.html
http://www.mybatis.org/spring-boot-starter/


sql映射文件的顶级元素(按应该被定义的顺序) http://www.mybatis.org/mybatis-3/zh/sqlmap-xml.html
1 cache:给定命名空间的缓存配置
	缓存默认是关闭的，除了局部的session缓存，要开启二级缓存，需要在映射文件中添加一行<cache />,它的效果如下
		文件中所有select语句将会被缓存
		文件中所有insert，update，delete语句会刷新缓存
		缓存默认会使用Least Recently Used(LRU,最近最少使用)算法来回收(可配置eviction=LRU,FIFO,SOFT,WEAK),
		缓存默认不设置刷新间隔，仅调用语句是刷新(可设置flushInterval="600000")
		缓存对象数量默认为1024个(可设置size="512")
		readOnly:只读的缓存会给所有调用者返回缓存对象相同实例。因此这些对象不能被修改。这提供了很重要的性能优势。可读写的缓存会返回缓存对象的拷贝(序列化对象)，这会慢一些，但更安全。所以默认为false
		
2 cache-ref：其他命名空间缓存配置的引用
	<cache-ref namespace="com.wefed.mybatis.dao.UserDao"/>
	
3 resultMap：描述如何从数据库结果集中加载对象
	resultMap是mybatis中最重要最强大的元素，可以让你从90%的结果集数据提取代码中解放出来。它的设计思想是，简单的语句不需要明确的结果映射，而复杂的语句只需要描述它们的关系。
	简单的情况，mybatis可以自动映射，如下所示，默认映射同名的字段(忽略大小写)，要启动驼峰映射，将map-underscore-to-camel-case设为true
	自动映射等级有三种:NONE(禁用),PARTIAL(默认,映射除了那些有内部定义内嵌结果映射的),FULL(映射全部),可设置auto-mapping-behavior
	<select id="get" parameterType="Long" resultType="com.wefed.mybatis.entities.User">
		select id, user_name as "userName" 
		from t_user 
		where id = #{id};
	</select>
	
	高级结果映射,例如:
	<resultMap id="detailedBlogResultMap" type="Blog">
		用于实例化类时，注入结果到构造方法中
		<constructor>
			id参数，标记作为id的结果集，可以帮助提高整体性能
	    	<idArg column="blog_id" javaType="int"/>
	    	注入到构造方法中的一个普通结果
	    	<arg column="username" javaType="String" name="username" />
		</constructor>
	注入到javaBean属性的普通结果
	<result property="title" column="blog_title"/>
	复杂类型的关联
	<association property="author" javaType="Author">
		<id property="id" column="author_id"/>
		<result property="username" column="author_username"/>
		<result property="password" column="author_password"/>
		<result property="email" column="author_email"/>
		<result property="bio" column="author_bio"/>
		<result property="favouriteSection" column="author_favourite_section"/>
	</association>
	复杂类型的集合
	<collection property="posts" ofType="Post">
	    <id property="id" column="post_id"/>
	    <result property="subject" column="post_subject"/>
	    <association property="author" javaType="Author"/>
	    <collection property="comments" ofType="Comment">
	      <id property="id" column="comment_id"/>
	    </collection>
	    <collection property="tags" ofType="Tag" >
	      <id property="id" column="tag_id"/>
	    </collection>
		使用结果集来使用哪个resultMap
	    <discriminator javaType="int" column="draft">
	      <case value="1" resultType="DraftPost"/>
	    </discriminator>
  	</collection>
</resultMap>
	
4 sql：可被其他语句引用的可重用语句块
	这个元素可以被用来定义可重用的 SQL 代码段，可以包含在其他语句中。它可以被静态地(在加载参数) 参数化. 不同的属性值通过包含的实例变化. 比如：
	<sql id="userColumns"> ${alias}.id,${alias}.username,${alias}.password </sql>
	这个 SQL 片段可以被包含在其他语句中，例如：
	<select id="selectUsers" resultType="map">
	  select
	    <include refid="userColumns"><property name="alias" value="t1"/></include>,
	    <include refid="userColumns"><property name="alias" value="t2"/></include>
	  from some_table t1
	    cross join some_table t2
	</select>
5 insert：映射插入语句
	<insert
  id="insertAuthor"
  parameterType="domain.blog.Author"
  flushCache="true"
  statementType="PREPARED"
  keyProperty=""
  keyColumn=""
  useGeneratedKeys=""
  timeout="20">
6 update：映射更新语句
	<update
  id="updateAuthor"
  parameterType="domain.blog.Author"
  flushCache="true"
  statementType="PREPARED"
  timeout="20">
7 delete：映射删除语句
	<delete
  id="deleteAuthor"
  parameterType="domain.blog.Author"
  flushCache="true"
  statementType="PREPARED"
  timeout="20">
8 select：映射查询语句
	<select
  id="selectPerson"
  parameterType="int"
  parameterMap="deprecated"
  resultType="hashmap"
  resultMap="personResultMap"
  flushCache="false"
  useCache="true"
  timeout="10000"
  fetchSize="256"
  statementType="PREPARED"
  resultSetType="FORWARD_ONLY">


动态拼接sql:http://www.mybatis.org/mybatis-3/zh/dynamic-sql.html



































