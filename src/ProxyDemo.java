import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    public interface SmsService {
        String send(String message);
    }

    public class SmsServiceImpl implements SmsService {
        public String send(String message) {
            System.out.println("send message:" + message);
            return message;
        }
    }

    public class DebugInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // TODO Auto-generated method stub
            Object result = method.invoke(target, args);
            return null;
        }
        
    }

    public class JdkProxyFactory {
        public static Object getProxy(Object target) {
            return Proxy.newProxyInstance(
                    target.getClass().getClassLoader(), // 目标类的类加载
                    target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                    new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
            );
        }
    }
}
