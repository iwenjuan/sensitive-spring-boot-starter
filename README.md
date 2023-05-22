# sensitive-spring-boot-starter

## 介绍
1. 注解式接口数据脱敏
2. 内置多种常见数据脱敏规则
3. 支持自定义脱敏规则
4. 目前只测试了SpringBoot 2.7.X版本

## 使用说明

### maven引入依赖
~~~
<dependency>
    <groupId>cn.iwenjuan</groupId>
    <artifactId>sensitive-spring-boot-starter</artifactId>
    <version>1.0.1-SNAPSHOT</version>
</dependency>
~~~
### @Desensitize注解
~~~
1.作用在方法上，标记该方法需要做数据脱敏处理
2.作用在属性上，标记该属性需要做数据脱敏处理（针对复杂对象的属性，结合@DesensitizeField注解表示该对象的属性需要做数据脱敏处理）
3.具体使用方式参考sample工程的UserController和ApiResult类
~~~
### @DesensitizeField注解
~~~
1.作用在属性上，标记该属性需要做数据脱敏处理（不能标记在复杂对象的属性上）
2.具体使用方式参考sample工程的User类
~~~
### 自定义脱敏规则
除内置的几种常见数据的脱敏规则外，还支持自定义脱敏规则，@DesensitizeField注解的type设置为CUSTOM
#### 自定义脱敏规则方式一
~~~
1.使用@DesensitizeField注解的prefixLength、suffixLength属性
2.参考User类的mobilePhone属性
~~~
#### 自定义脱敏规则方式一
~~~
1.实现DesensitizeHandler接口，并注入spring容器
2.@DesensitizeField注解的handler属性设置为自定义的DesensitizeHandler实现类
~~~
