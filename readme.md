### springboot中配置https

#### 1.执行下面的命令生成一个证书：
    keytool -genkey -alias tomcathttps -keyalg RSA -keysize 2048  -keystore D:\weimin.p12 -validity 365

    命令含义如下：
    genkey 表示要创建一个新的密钥。
    alias 表示 keystore 的别名。
    keyalg 表示使用的加密算法是 RSA ，一种非对称加密算法。
    keysize 表示密钥的长度。
    keystore 表示生成的密钥存放位置。
    validity 表示密钥的有效时间，单位为天。

#### 2.将上面生成的 javaboy.p12 拷贝到 Spring Boot 项目的 resources 目录下。然后在 application.properties 中添加如下配置：

    server.ssl.key-store=classpath:weimin.p12
    server.ssl.key-alias=tomcathttps
    server.ssl.key-store-password=weimin

    key-store表示密钥文件名。
    key-alias表示密钥别名。
    key-store-password就是在cmd命令执行过程中输入的密码。

#### 3.Spring Boot 不支持同时启动 HTTP 和 HTTPS ，为了解决这个问题，我们这里可以配置一个请求转发，当用户发起 HTTP 调用时，自动转发到 HTTPS 上。

    com.example.springboothttpsdemo.demos.config.TomcatConfig

    在这个类，配置了 Http 的请求端口为 8081，所有来自 8081 的请求，将被自动重定向到 8080 这个 https 的端口上。


#### test
    https://localhost:8080/hello
    http://localhost:8081/hello

#### 更新：使用jks证书