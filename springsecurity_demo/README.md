# SpringSecurity的使用 #
## 一、搭建环境 ##
### 1 maven坐标 ###
	<properties>
        <spring.version>4.3.12.RELEASE</spring.version>
        <springsecurity.version>4.2.13.RELEASE</springsecurity.version>
    </properties>
	<!--springSecurity依赖 start-->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-web</artifactId>
            <version>${springsecurity.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-config</artifactId>
            <version>${springsecurity.version}</version>
        </dependency> 
	<!--springSecurity依赖 end-->
### 2 web.xml配置 ###
	 <!--配置spring-mvc DispatcherServlet-->
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath*:spring*.xml</param-value>
        </init-param>
        <!--设置为第一启动-->
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    <!--配置springSecurity过滤器链-->
    <filter>
        <filter-name>springSecurityFilterChain</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>springSecurityFilterChain</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
### 3 springmvc.xml配置 ###
	<!--1 配置注解扫描-->
    <context:component-scan base-package="controller"></context:component-scan>
    <!--2 配置处理器映射 和适配器-->
    <mvc:annotation-driven />
    <!--3 配置静态资源映射  不被springmvc所拦截-->
    <mvc:resources location="/WEB-INF/static/**" mapping="/resources" ></mvc:resources>
    <!--4 配置视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/page/" />
        <property name="suffix" value=".jsp" />
    </bean>
### 4 添加模拟需要权限访问的资源 ###
新建一个类StudentController
	
	@RequestMapping("/student")
	@Controller
	public class StudentController {

    @RequestMapping("addStudent")
    public String addStudent(){
        return "addStudent";
    }
    @RequestMapping("updateStudent")
    public String updateStudent(){
        return "updateStudent";
    }
    @RequestMapping("deleteStudent")
    public String deleteStudent(){
        return "deleteStudent";
     }
	}
### 建立访问的jsp页面 ###
我这里建了对应的三个jsp页面，只是简单的显示这里贴出一个addStudent.jsp

	<!--addStudent.jsp-->
	<html>
		<head>
    		<title>添加学生</title>
		</head>
		<body>
			<h3>添加学生</h3>
		</body>
	</html>
--------------------------------------
	<!--index.jsp-->	
	<html>
	<head>
	    <title>欢迎页面</title>
	</head>
	<body>
	<a href="/student/addStudent">添加学生</a>
	<a href="/student/updateStudent">更新学生</a>
	<a href="/student/deleteStudent">删除学生</a>
	</body>
	</html>	
## 二、xml方式实现权限验证 ##
后面我会从简单的配置到复杂的配置
### 1直接将用户名密码写死在spring-security.xml中 ###
	