1、概念
        装饰模式又名包装(Wrapper)模式。装饰模式以对客户端透明的方式扩展对象的功能，是继承关系的一个替代方案。
2、针对的问题
        动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator模式相比生成子类更为灵活。不改变接口的前提下，增强所考虑的类的性能。

何时使用：

    1）需要扩展一个类的功能，或给一个类增加附加责任。

    2）需要动态的给一个对象增加功能，这些功能可以再动态地撤销。

    3）需要增加一些基本功能的排列组合而产生的非常大量的功能，从而使继承变得    不现实。\

3、角色组成
   抽象构件(Component)角色：给出一个抽象接口，以规范准备接收附加责任的对象。

    具体构件(ConcreteComponent)角色：定义一个将要接收附加责任的类

    装饰角色(Decorator)：持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口

   体装饰角色(ConcreteDecorator)：负责给构件对象“贴上”附加的责任
   
例子：
  咖啡是一种饮料，咖啡的本质是咖啡豆+水磨出来的。
  咖啡店现在要卖各种口味的咖啡，如果不使用装饰模式，那么在销售系统中，
  各种不一样的咖啡都要产生一个类，如果有4中咖啡豆，5种口味，那么将要产生至少20个类（不包括混合口味），非常麻烦。
  使用了装饰模式，只需要11个类即可生产任意口味咖啡（包括混合口味）。
  