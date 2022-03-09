package shoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import shoppinglist.uiBoundary.*;


@Configuration
@Component
@ComponentScan(basePackages="shoppinglist")
public class App {  

        @Autowired
        ILui ui;
        public static void main(String[] args) {
        
            var ctx = new AnnotationConfigApplicationContext(App.class);

            var bean = ctx.getBean(App.class);
            bean.run();
    
            ctx.close();

        
    }

    public void run() {
        ui.exec();
    }

}