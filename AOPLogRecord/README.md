在DynamicProxy中我们展示了动态代理的一些基础知识，在本例中我们使用Spring自带的Aop注解简单地实现日志记录

@Aspect
定义切面

@Pointcut 定义切点，可以跟随一个表达式，用于匹配方法。
    execution 基于方法的返回类型、包名、类名、方法名以及参数类型等信息来精确地匹配方法.
    within 匹配被指定注解标注的方法。
    annotation 匹配了所有被注解标注的类的所有方法。

定义织入方法
@Before: 在切点之前，织入相关代码；
@After: 在切点之后，织入相关代码;
@AfterReturning: 在切点返回内容后，织入相关代码，一般用于对返回值做些加工处理的场景；
@AfterThrowing: 用来处理当织入的代码抛出异常后的逻辑处理;
@Around: 在切入点前后织入代码，并且可以自由的控制何时执行切点；