# springboot

win10 hosts文件路径 : C:\WINDOWS\system32\drivers\etc\hosts
chenglu:里面主要为考核内容

笔记：

eureka：配置：

    #注意对其
    spring:
      application:
        name: eureka-service
    
    server:
      port: 8000
    #    读取网卡时间 Cannot determine local hostname 读取网卡超时
      cloud:
        inetutils:
          timeout-seconds: 10
    eureka:
    #是否允许其他注册和同步服务，默认为true
      client:
        register-with-eureka: true
        fetch-registry: true
        service-url:
          defaultZone: http://47.101.130.37:8000/eureka/,http://127.0.0.1:8000/eureka/
      server:
        eviction-interval-timer-in-ms: 4000

   其他服务服务配置：
   
    server:
      port: 8001
    eureka:
      client:
        service-url:
          defaultZone: http://127.0.0.1:8000/eureka/
    spring:
      application:
        name: gateway-service
      cloud:
        inetutils:
          timeout-seconds: 10

forEach：调用

     List<HgylPersonInfo> list = ExcelUtils.excelToShopIdList(excelFile.getInputStream());
            //循环调用插入过程
            list.forEach(e -> {
                System.out.println("list:"+e.getJobNum());
                hgylPersonInfoService.insert(e);
            });
            
            
mapping中批量插入：
      
      <!--批量插入-->
      <insert id="batchInsert" parameterType="java.util.List">
              INSERT INTO
              hgyl_person_info(
              `area`,
              `job_num`,
              `name`,
              `project`,
              `working`,
              `site`,
              `start_date`,
              `end_date`,
              `remark`)
              VALUES
              <foreach collection="list" item="item" index="index" separator=",">
                  (
                  #{item.area},
                  #{item.jobNum},
                  #{item.name},
                  #{item.project},
                  #{item.working},
                  #{item.site},
                  #{item.startDate},
                  #{item.endDate},
                  #{item.remark}
                  )
              </foreach>
              
动态执行：

        JexlEngine jexl=new JexlEngine();  
        Expression e = jexl.createExpression(jexlExp);//jexlExp 需要执行的语句
        
        maven 依赖
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-jexl</artifactId>
            <version>2.0</version>
        </dependency>
        
        
 ## 前端
 
  更改源
  
    npm config set registry https://registry.npm.taobao.org
    npm config set disturl https://npm.taobao.org/dist
    yarn  --ignore-scripts; //有scripts报错


      