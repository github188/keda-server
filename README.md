视综平台后端基础框架
==============
## 主要模块

内容                      |说明                     |版本           |
----                      |----                     |----         |
kiaf-base               | web依赖                 |1.0.0-RELEASE   |
kiaf-flyway             | sql版本控制                  |1.0.0-RELEASE   |
kiaf-index              |project启动类             |1.0.0-RELEASE   |
kiaf-web                |web应用                  |1.0.0-RELEASE   |

## 框架的Repository地址
        <repository>
            <id>ctsp</id>
            <name>ctsp</name>
            <url>http://nexus.ctsp.kedacom.com/content/groups/public/</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
        <repository>
            <id>alibab</id>
            <name>alibaba</name>
            <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
        </repository>
        <repository>
            <id>yuanqu-release</id>
            <name>yuanqu</name>
            <url>http://nexus.ctsp.kedacom.com/content/repositories/yuanqu-release/</url>
        </repository>
        <repository>
            <id>yuanqu-snapshot</id>
            <name>yuanqu</name>
            <url>http://nexus.ctsp.kedacom.com/content/repositories/yuanqu-snapshot/</url>
        </repository>


# kiaf-base

## 简介
* 该目录主要存放web所要依赖的一些基础包以及对web的一些通用的扩展功能，比如当前技术栈中用到的spring boot 依赖等。

## 依赖
* 添加对spring-boot-web 和Tomcat 的支持(web 基本)
    
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>

* 添加对web的基本支持
    
        <dependency>
            <groupId>com.kedacom.kidp.base</groupId>
            <artifactId>web-starter</artifactId>
            <version>${web.starter.version}</version>
        </dependency>
        
* 添加对持久化基本操作
        
        <dependency>
            <groupId>com.kedacom.kidp.base</groupId>
            <artifactId>data-starter</artifactId>
            <version>${data.starter.version}</version>
        </dependency>
        
* 代码生成器支持，可通过该功能从表开始生成基本的一套CRUD操作的代码
                
                    
        <dependency>
            <groupId>com.kedacom.kidp.base</groupId>
            <artifactId>codegen-starter</artifactId>
            <version>${codegen.starter.version}</version>
        </dependency>
        
* 添加对通用工具类的支持
        
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-collections4</artifactId>
        </dependency>
        <dependency>
            <groupId>com.belerweb</groupId>
            <artifactId>pinyin4j</artifactId>
            <version>2.5.1</version>
        </dependency>
        <dependency>
            <groupId>com.kedacom.ctsp</groupId>
            <artifactId>commons-web-controller</artifactId>
        </dependency> 
        
*  添加对日志的支持
                                       
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
        </dependency>
        
        <dependency>
            <groupId>com.googlecode.log4jdbc</groupId>
            <artifactId>log4jdbc</artifactId>
            <version>1.2</version>
        </dependency>
         
* Lombok支持(简化对bean的编写和使用)
                          
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
         
* 添加对用户权限验证的支持
    
        <dependency>
            <groupId>com.kedacom.ctsp.cloud</groupId>
            <artifactId>rbac-authority-starter</artifactId>
            <version>${rbac.version}</version>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-devtools</artifactId>
                </exclusion>
            </exclusions>
        </dependency>     
        <dependency>
            <groupId>com.kedacom.ctsp</groupId>
            <artifactId>commons-authz</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-devtools</artifactId>
                </exclusion>
            </exclusions>
        </dependency>       
        <dependency>
            <groupId>com.kedacom.ctsp.cloud</groupId>
            <artifactId>rbac-authz-oauth2-client</artifactId>
            <version>${rbac.version}</version>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-devtools</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
 
* 单元测试的支持
 
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
  
* 对swagger功能的支持

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
        </dependency>

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
        </dependency>
        
## 功能扩展

### 指定日志特殊处理

* 通过继承web-starter包中的DefaultAuditLog重写log方法来实现对日志的自定义捕获
        
        @Primary
        @Component
        @Slf4j
        public class KiafLogAudit extends DefaultAuditLog {
        
            @Value("${log.aspect.file}")
            private String accessLogFile;
            
             //通过accept指定日志处理所支持包下的文件,一般是当前工程下的自定义处理,不同组件处理各自的日志,如果不加将处理所有的 请求日志
            @Override
            public boolean accept(AuditEvent auditEvent) {
                return auditEvent.getAuditContext().getControllerClass().getPackage().getName().startsWith("com.kedacom.kiaf");
            }
                
            public void log(AuditEvent auditEvent) {
                if (AuditType.ACCESS.equals(auditEvent.getType())) {
                    if (null == auditEvent.getAuditContext()) {
                        log.error("log(), auditContext = null");
                        return;
                    }
                    try {
                        LogTempDTO savedTempLog = preProcessLog(auditEvent.getAuditContext());
                        String[] logFiles = accessLogFile.split(",");
                        boolean isNotFile = true;
                        if (auditEvent.getAuditContext() != null && StringUtils.isNotEmpty(auditEvent.getAuditContext().getModule())) {
                            for (String logName : logFiles) {
                                if (logName.equals(auditEvent.getAuditContext().getModule())) {
                                    org.slf4j.Logger logger = LoggerFactory.getLogger(logName);
                                    logger.info(savedTempLog.toString());
                                    isNotFile = false;
                                    break;
                                }
                            }
                        }
                        //如果没有匹配到文件就打到公共文件中去
                        if (isNotFile) {
                            log.info(savedTempLog.toString());
                        }    
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }
        }
* log.aspect.file 的值从application-xxx.yml(如:application-dev.yml) 配置文件中获取,多个值用逗号隔开
        
        log:
          aspect:
            file: kedacom_log1,kedacom_log2
 * 在lomback-spring.xml 中添加和上面属于相同命名(如:kedacom_log1)的日志配置
    
        <appender name="kedacom_log1" class="ch.qos.logback.core.rolling.RollingFileAppender">
                <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                    <!--日志文件输出的文件名-->
                    <FileNamePattern>${LOG_HOME}/kedacom_log1.@build.finalName@.%d{yyyy-MM-dd}.log</FileNamePattern>
                    <!--日志文件保留天数-->
                    <MaxHistory>30</MaxHistory>
                </rollingPolicy>
                <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
                    <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符-->
                    <pattern>%-4relative [%thread] %-5level %logger{35} - %msg%n</pattern>
                </encoder>
                <!--日志文件最大的大小-->
                <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
                    <MaxFileSize>10MB</MaxFileSize>
                </triggeringPolicy>
            </appender>
            
            <logger name="kedacom_log1" level="INFO" additivity="false">
                    <appender-ref ref="STDOUT"/>
                    <appender-ref ref="kedacom_log1"/>
                </logger>
                
 * controller层的方法上添加@AccessLog对特殊日志处理支持，注意名称和我们定义的日志配置名称(如:kedacom_log1)一致才能被捕获到
   
       @GetMapping("/test/log1")
       @AccessLog(module = "kedacom_log1")
       public ResponseMessage testLog1() {
           log.info("[kd-base] this is a test log2: " + new Date() + "," + mainValue);
           return ResponseMessage.ok();
       }
 
        
### 全局异常捕获和处理

* 当我们暴露给外界的接口被调用失败时会抛出异常，这个时候我们需要catch住这个异常返回给前端一个友好的结果，系统提供了一个common的异常捕获器但是有的时候我们需要添加一些特殊的处理这个时候我们就要自己实现一个这样的功能。

        @ControllerAdvice
        @Slf4j
        @Order(KiafExceptionHandler.Order.GLOBAL_PRECEDENCE)
        public class KiafExceptionHandler {
        
            @ExceptionHandler(MethodArgumentNotValidException.class)
            @ResponseBody
            public ResponseMessage handleIllegalParamException(MethodArgumentNotValidException e) { // 处理方法参数的异常类型
                List<ObjectError> errors = e.getBindingResult().getAllErrors();
                StringBuilder tips = new StringBuilder("参数不合法: ");
                if (errors.size() > 0) {
                    for (ObjectError error : errors) {
                        tips.append(error.getDefaultMessage()).append("; ");
                    }
                    //去掉最后一个 ;
                    tips.deleteCharAt(tips.length() - 1);
                }
        
                return ResponseGenerator.genFailResult(tips);
            }
            
            public interface Order {
                int GLOBAL_PRECEDENCE=Ordered.LOWEST_PRECEDENCE-11000;
            }
        }
        
        --以上提供一个捕获serviceException的操作
          
          --当我们需要在controller层中添加异常抛出的时候上面的handler会捕获到
              
              @RestController
              @RequestMapping("/single_base")
              @Slf4j
              @Api(tags = "single-base", description = "基础框架测试入口")
              public class KiafBaseController {
              
                  @GetMapping("/service/detail")
                  public ResponseMessage findDetail() {
                      throw new ServiceException("THIS IS A TEST SERVICE EXCEPTION TEST");
                  }
              }
              
          --启动服务访问该接口返回以下JSON数据
          {
          	"code": "500",
          	"message": "THIS IS A TEST SERVICE EXCEPTION TEST",
          	"status": 500,
          	"timeElapsed": 9,
          	"timestamp": 1544439047581
          }
        
* 注意:因为在基础jar中提供了一个GlobalExceptionHandler 所以我们需要添加一个order优先级来确定加载顺序 ，
  当这个值越小优先级越高，在GlobalExceptionHandler中是Ordered.LOWEST_PRECEDENCE-10000 所以在当前类上减去一个比10000大的值就好了。 
        

# kiaf- web

## 依赖

* 添加Base包对web的功能的支持

        
           <dependency>
               <groupId>com.kedacom.kiaf</groupId>
               <artifactId>kiaf-base</artifactId>
               <version>${project.version}</version>
               <exclusions>
                   <exclusion>
                       <groupId>org.springframework.boot</groupId>
                       <artifactId>spring-boot-devtools</artifactId>
                   </exclusion>
               </exclusions>
           </dependency>
 ## 功能
 
 * kiaf-web 目录是开发具体的业务的包，当我们需要对外暴露服务的时候我们的业务功能将在这个包下面实现。
 
 * 暴露对外的接口的文件存放在controller文件夹下，具体业务实现存放在service文件夹下，实体对象entity，查询对象dto,持久化操作dao,当需要调用外部服务的时候我们使用feign client功能，文件存放在feign文件夹下，这样整个文件目录就构建完成了。
  
 * controller 包下的功能：
    
          @RestController
          @RequestMapping("/kiaf_base")
          @Slf4j
          @Api(tags = "kiaf-base", description = "基础框架测试入口")
          public class MicroBaseController {
      
              @GetMapping("/test/log1")
              @AccessLog(module = "kedacom_log1")
              public ResponseMessage testLog1() {
                  log.info("[kd-base] this is a test log2: " + new Date() + "," + mainValue);
                  return ResponseMessage.ok();
              }
          }
    
  * Dao 持久化操作
  * 目前的规范是使用两种方式的来使用，基于单表的的操作可以通过约定的方式来优先查询，如果不支持将使用注解的方式。
    
        VideoBookmark findVideoBookmarkByUserAndDeviceId(String user, String deviceId);
                    
        @Query(value = "select * from video_plan where USER = :user and PLAN_RELEASE_TYPE = :planReleaseType and PLAN_NAME like CONCAT('%',:planName,'%') ", nativeQuery = true)
        List<VideoPlan> findVideoPlanBySql(@Param("user") String user, @Param("planReleaseType") String planReleaseType, @Param("planName") String planName);   
 
 * 第二种复杂的查询（多表）通过JPQL.xml的方式来执行查询
 * 先配置XML
    
        <jpa module="mapFocusArea">
            <jpql id="queryFocusArea" resultClass="com.kedacom.kiaf.data.dto.MapFocusAreaDTO" native="true">
                SELECT id focus_Id,focus_Name,focus_Alias,area_Code,area_Name,
                focus_Type,focus_Radius,`user`,query_Desc,shape
                FROM map_focus_area
                WHERE 1=1
                #if($focusId)
                and id = :focusId
                #end
                #if($focusType)
                and focus_Type = :focusType
                #end
                #if($user)
                and `user` = :user
                #end
                #if($queryDesc)
                and queryDesc LIKE :'%queryDesc%'
                #end
                ORDER BY focus_Type,id DESC;
            </jpql>
        </jpa>
    
 * 再在代码中获取数据
 
        HashMap<String, Object> sqlParam = new HashMap<>();                      
        sqlParam.put("focusId", Long.valueOf(focusSearchDTO.getFocusId()));
        sqlParam.put("focusType", focusSearchDTO.getFocusType());
        sqlParam.put("queryDesc", focusSearchDTO.getQueryDesc());
        sqlParam.put("user", focusSearchDTO.getUser());
        List<MapFocusAreaDTO> queryResults = jpqlQuerySupport.findAll("mapFocusArea.queryFocusArea", sqlParam);
        
 * web包提供的是应用服务，当我们作为组件加入别的项目时因为一个项目只能有一个启动类，所以需要将启动类和自身的配置文件排除出去才能做到和主工程一起实例化在一个容器中作为一个应用启动。
    排除的方法需要在pom文件的build中添加一下source和plugin.
    
        <resource>
            <directory>src/main/resources</directory>
            <filtering>false</filtering>
            <excludes>
                <exclude>*.yml</exclude>
                <exclude>*.xml</exclude>
            </excludes>
        </resource>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <configuration>
                <excludes>
                    <exclude>**/Application.java</exclude>
                </excludes>
            </configuration>
        </plugin>
        
  * 如果作为单个的应用启动不需要添加意识的功能了。
 
 
# kiaf- flyway

## 概述
* 开发服务避免不了和数据库进行交互，这个时候我们就需要创建数据表了，在开发的过程中随着业务的复杂和功能的扩展我们最初设计的表结构已经不能满足我们的业务需求，这个时候我们就要做表结构变动以及表数据的变动。为了使数据库的变动在各个环境能够一致性我们需要一个版本控制的工具，这边我们使用的flyway。当我们有数据库的变动我们将新建一个脚本文件放在这个目录下，当环境部署的时候先运行这里的脚本保证数据库能够支持应用的运行(注意这里的脚本文件只能新增不能修改)。

       文件的目录结构是根据服务种类来确定的，当我们有多个服务要启动就会有多个文件夹，比如 现在有的两个 media和map，对应的服务先都有相同的文件夹migration和updateSql存放脚本文件。

       当我们要执行这些sql 的时候只要运行maven的 flyway: migration 命令就可以将所有的脚本执行到指定的数据库中。
        
* 需要引入这个插件来执行
       
       <plugins>
           <plugin>
               <groupId>org.flywaydb</groupId>
               <artifactId>flyway-maven-plugin</artifactId>
               <version>${flyway-maven-plugin.version}</version>
               <configuration>
                   <table>schema_version</table>
                   <validateOnMigrate>true</validateOnMigrate>
                   <user>${db.username}</user>
                   <password>${db.password}</password>
                   <driver>${db.driver}</driver>
                   <url>${db.url}</url>
                   <locations>
                       <location>db</location>
                   </locations>
               </configuration>
               <!--  <executions>
                     <execution>
                         <id>migrate</id>
                         <phase>package</phase>&lt;!&ndash; 要绑定到的生命周期的阶段 &ndash;&gt;
                         <goals>
                             <goal>migrate</goal>&lt;!&ndash; 要绑定的插件的目标 &ndash;&gt;
                         </goals>
                     </execution>
                 </executions>-->
           </plugin>
       </plugins>
 ## 注意
   1.数据库脚本个格式是 V时间_服务名称_操作_表名.sql
  --例如 V201811291904_MEDIA__CREATE_TABLE_VIDEO_BOOKMARK.sql
   2.当主项目中加入多个的时候要将这些module加进kiaf-flyway,因为一个数据库只能执行一个flayway,多个模块不能独立的去执行自己的数据脚本,需要将所有的模块的DB脚本依赖进主工程的flyway下然后一起执行这些脚本，
 做法就是讲maven依赖加进kiaf-flay的pom中,如视频组件。
 
         <dependency>
                <groupId>com.kedacom.media</groupId>
                <artifactId>media-web</artifactId>
                <version>${media.web.version}</version>
            </dependency>
 
 # kiaf- index
 
## 依赖

* 该工程是系统启动包，所有项目内的的功能模块和外部组件都将依赖到这个包下

        <dependency>
            <groupId>com.kedacom.kiaf</groupId>
            <artifactId>kiaf-web</artifactId>
            <version>${project.version}</version>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-devtools</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
        
## 功能

* 因为kiaf-index是启动类所以所有配置有全局的配置文件，项目的的基本配置有 application.yml 当在不同的环境下启动各自环境的配置application-xxx.yml，Resource Bundle authority 文件夹下的文件添加对国际化的支持，日志的支持配置通过logback-spring.xml来实现。

* 开发后端避免不了和数据库进行交互，这个时候我们就需要创建数据表了，在开发的过程中随着业务的复杂和功能的扩展我们最初设计的表结构已经不能满足我们的业务需求，这个时候我们就要做表结构变动以及表数据的变动。为了使数据库的变动在各个环境能够一致性我们需要一个版本控制的工具，这边我们使用的flyway。当我们有数据库的变动我们将新建一个脚本文件放在这个目录下，当环境部署的时候先运行这里的脚本保证数据库能够支持应用的运行(注意这里的脚本文件只能新增不能修改)。

## 组件注意事项

* 选择组件之后,需要把sql都整合在一起。
  
   1.把需要用到的sql都放到统一的位置管理
   
       例如：xxx-flyway/resources/db/项目名称、版本号 
    
   2.sql需要按照以下格式命名
   
         V变根号__V版本号__组件名称_表操作_表名
         例如:V1__v1.0.0_RELEASE-TOLLGATE-CREATE_TABLE_TOLLGATE.sql
    
* class文件命名规范

   1.每个组件必须创建自己的包名
    
        例如 com.kedacom.ra
   
   2.创建类时必须带上自己项目的前缀 例如:xxxConfiguration
      
      package com.kedacom.kiaf;
      
      import org.springframework.boot.autoconfigure.domain.EntityScan;
      import org.springframework.context.annotation.ComponentScan;
      import org.springframework.context.annotation.Configuration;
      import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
      import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
      
      /**
       * @author kedacom 
       * @date 2018-11-20
       */
      @Configuration
      @ComponentScan
      @EnableJpaAuditing
      @EnableJpaRepositories
      @EntityScan
      public class KiafConfiguration {
      
      }
   
 
* spring yml配置的规范

  在源码构建的时候由于主启动项目的配置文件中没有组件必须的配置信息导致启动失败
  
  1.在上传组件时,在最外层加上template/yml,把必要的配置文件加上去
  
      spring:
        kafka:
          secondary:
            servers:
              viid:
                consumer:
                  group-id: apple-local
                bootstrap-servers: 172.16.239.7:9092
                topic:
                  motorVehicle: trff-kafka-motorvehicles-p6
  
  2.最后在生成项目时,会把yml追加到xxx-index生成项目的yml中
  
* spring Configuration配置的规范

  在对组件源码构建中配置文件的缺失导致整个组件不能启动
 
  1.在上传组件时候,把配置的class类的完整路径加入到template/yml中
  
      template:
          configuration:
              - "com.kedacom.tollgate.TollgateConfiguration"
  
  2.最后在生成项目之后,会在生成的模块(默认为xx-index 例如 Common-index)中生成CommonTemplateConfiguration加入所有选中组件的的Configuration类)
      
      @Import({com.kedacom.common.CommonConfiguration.class})
      public class Application extends SpringBootServletInitializer {
      
          public static void main(String[] args) {
              SpringApplication.run(Application.class, args);
          }
      
          @Override
          protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
              // 注意这里要指向原先用main方法执行的Application启动类
              return builder.sources(Application.class);
          }
      }
  
  
   
   
   