package shoppinglist.uiBoundary;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public interface ILui {
    public void exec();
    public void setApplicationContext(ApplicationContext context);
}
