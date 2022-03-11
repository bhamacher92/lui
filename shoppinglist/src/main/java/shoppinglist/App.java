package shoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import shoppinglist.uiBoundary.*;


@Configuration
@ComponentScan
@Component
public class App {  

        @Autowired
        ILui ui;

        static ApplicationContext ctx;
        public static void main(String[] args) {
        
            ctx = new AnnotationConfigApplicationContext(App.class);

            var bean = ctx.getBean(App.class);
            bean.run();
    
           // ctx.close();

        
    }

    public void run() {

        for (String beanName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        ui.setApplicationContext(ctx);

        ui.exec();
    }

}