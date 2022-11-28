# netflix 例子

spring boot版本`<spring-boot.version>2.3.11.RELEASE</spring-boot.version>`

spring cloud版本`<spring-cloud.version>Hoxton.SR12</spring-cloud.version>`

spring cloud支持netflix的最后一个版本,不再升级.

## maven
打包代码
```shell
mvn install -DskipTests=true
```

打包镜像
```shell
mvn jib:dockerBuild
```

部署
> docker-compose方式
```shell
docker apply -f netflix-example.yml
```