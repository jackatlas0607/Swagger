package com.Takagi.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置了Swagger的Docket的Bean實例，Swagger实例Bean是Docket，所以通过配置Docket实例来配置Swaggger。
    //利用Docket接管了原本Swagger的默認配置
    //http://localhost:8080/swagger-ui.html
    @Bean
    public Docket docket(Environment environment) {

        //設置要顯示的Swagger環境
        Profiles profiles = Profiles.of("dev","test"); //放沒有的環境也可以

        //設置 environment.acceptsProfiles(profiles);判斷是否處在自己設定的環境當中
        //配置文件的spring.profiles.active
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 是否啟用swagger，若為flase則Swagger不能在瀏覽器中訪問
                .groupName("狂三")
                .enable(flag)
                .select()
                //RequestHandlerSelectors配置要掃描接口的方式
                //basePackage: 指定要掃描的包，幾乎都是用這個方法
                //ant():掃描全部
                //none():都不掃描
                //withClassAnnotation():掃描類上的註解，參數是一個註解的反射對象
                //withMethodAnnotation():掃描方法上的註解
                .apis(RequestHandlerSelectors.basePackage("com.Takagi.swagger.controller"))
                //paths():過濾甚麼路徑
                //.paths(PathSelectors.ant("/Takagi/**"))
                .build();

        //掃描"com.Takagi.swagger.controller"這個包，但是只掃描"/Takagi/**"這樣的請求
    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
    //配置Swagger信息= apiInfo
    private ApiInfo apiInfo() {

        //作者信息
        Contact contact = new Contact("Google", "https://www.google.com.tw/", "google@google.com");

        return new ApiInfo("SwaggerAPI文檔",
                "Api Documentation", "v1.0",
                "https://www.google.com.tw/",
                contact, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }

}
