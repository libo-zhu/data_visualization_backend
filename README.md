# data_visualization_backend

# ⚙️ 气象数据服务后端

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)](https://www.mysql.com/)
[![BCrypt](https://img.shields.io/badge/BCrypt-003A70?logo=bcrypt&logoColor=white)](https://bcrypt.sourceforge.net/)

> 基于SpringBoot的气象数据服务后端，提供安全高效的API接口
>
> ## 🗃️ 数据库设计
>
> ```sql
> CREATE TABLE users (
>   id INT PRIMARY KEY AUTO_INCREMENT,
>   username VARCHAR(50) UNIQUE NOT NULL,
>   password CHAR(60) NOT NULL -- BCrypt加密后固定60字符
> );
> 
> CREATE TABLE history_city (
>   city_id INT PRIMARY KEY,
>   city_name VARCHAR(50) NOT NULL,
>   latitude DECIMAL(9,6) NOT NULL,
>   longitude DECIMAL(9,6) NOT NULL
> );
> 
> CREATE TABLE history (
>   record_id INT PRIMARY KEY AUTO_INCREMENT,
>   city_id INT,
>   record_date DATE NOT NULL,
>   temperature DECIMAL(3,1),
>   humidity TINYINT,
>   FOREIGN KEY (city_id) REFERENCES history_city(city_id)
> );

## 🔐 安全特性

1. 密码加密
   - 采用BCrypt强哈希算法（文献19）
   - 自动生成盐值 + 迭代加密
2. API防护
   - JWT令牌认证（有效期15分钟）
   - 接口限流（Redis实现）
3. 数据安全
   - SQL注入过滤（MyBatis参数绑定）
   - XSS防护（Jackson HTML转义）

## 🌐 API文档

|          端点           | 方法 |        描述         |
| :---------------------: | :--: | :-----------------: |
|    `/api/auth/login`    | POST | 用户登录（返回JWT） |
|   `/api/weather/real`   | GET  |  获取实时天气数据   |
| `/api/history/{cityId}` | GET  |  查询历史气象记录   |

## 🚀 部署指南

1. 环境要求：
   - Java 17+
   - MySQL 8.0+
2. 配置文件`application.yml`：

```yaml
amap:
  api-key: your_amap_service_key
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/weather_db
    username: dbuser
    password: dbpassword
```

## 📊 性能优化

- 历史数据查询添加复合索引：

  ```sql
  CREATE INDEX idx_city_date ON history(city_id, record_date);
  ```

- 热点天气数据缓存（Redis实现）
