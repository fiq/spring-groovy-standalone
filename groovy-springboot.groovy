// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
@Grapes([
        @GrabConfig(systemClassLoader = true),
        @Grab(group = 'javax.servlet', module = 'javax.servlet-api', version = '4.0.1'),
        @Grab(group = 'org.springframework.boot', module = 'spring-boot-starter-web', version = '2.1.2.RELEASE'),
        // tomcat 9 depends on serverl-api >= 3.1. Groovy still comes with a provided v3.0.1
        @GrabExclude(group = 'org.springframework.boot', module = 'spring-boot-starter-tomcat'),
        @Grab(group = 'org.springframework.boot', module = 'spring-boot-starter-jetty', version = '2.1.2.RELEASE'),
        @Grab(group = 'org.eclipse.jetty', module = 'jetty-server', version = '9.4.14.v20181114'),
        @Grab(group = 'org.eclipse.jetty', module = 'jetty-http', version = '9.4.14.v20181114'),
        @Grab(group = 'org.eclipse.jetty', module = 'jetty-util', version = '9.4.14.v20181114'),
        @Grab(group = 'org.eclipse.jetty.websocket', module = 'websocket-common', version = '9.4.14.v20181114'),
])

package raf

import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@Controller
class SpringyEcho {

    @RequestMapping("/")
    @ResponseBody
    String root() {
        "hello there"
    }

    @PostMapping("/echo")
    @ResponseBody
    String echo(@RequestBody String body) {
        return URLDecoder.decode(body);
    }
}


static void main(String[] args) {
    SpringApplication.run(SpringyEcho.class, args)
}
