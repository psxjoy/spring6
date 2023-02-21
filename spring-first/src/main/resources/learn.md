1.之前创建对象，无参数构造？

2.不用 new 的方式，还可以如何创建对象？

（1）加载 bean.xml 文件

（2）解析 bean.xml文件
（3）对xml文件的bean标签属性进行获取（id and class 属性值）
（4）使用反射根据类全路径创建对象
3.创建对象放到哪里

```java
Map<String,BeanDefiniton> beanDefinitionMap
```
