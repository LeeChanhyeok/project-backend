# Spring Boot Sample

팀 과제용 Spring Boot 샘플 프로젝트입니다.  
기본 CRUD 구조를 제공하며, 각자 맡은 도메인에 맞게 커스텀하여 개발하세요.

## 기술 스택
- Java 17
- Spring Boot 3.2
- Spring Data JPA
- H2 (개발용 인메모리 DB)
- Lombok

## 시작하기

```bash
# 개발 서버 실행
./gradlew bootRun

# 빌드
./gradlew build

# 테스트
./gradlew test

# 서버 주소
http://localhost:8080

# H2 콘솔 (개발용 DB 확인)
http://localhost:8080/h2-console
# JDBC URL: jdbc:h2:mem:sampledb
```

## API 목록

| Method | URL             | 설명       |
|--------|-----------------|------------|
| GET    | /api/items      | 전체 조회  |
| GET    | /api/items/{id} | 단건 조회  |
| POST   | /api/items      | 등록       |
| PUT    | /api/items/{id} | 수정       |
| DELETE | /api/items/{id} | 삭제       |

## 프로젝트 구조

```
src/main/java/com/example/sample/
├── SampleApplication.java     # 진입점
├── config/
│   ├── WebConfig.java         # CORS 설정
│   └── GlobalExceptionHandler.java
├── controller/
│   └── ItemController.java    # REST API
├── service/
│   └── ItemService.java       # 비즈니스 로직
├── repository/
│   └── ItemRepository.java    # DB 접근
├── domain/
│   └── Item.java              # 엔티티
└── dto/
    ├── ItemRequest.java
    └── ItemResponse.java
```

## 커스텀 가이드

1. `domain/Item.java` → 본인의 도메인 엔티티로 교체
2. `dto/` → 요청/응답 DTO 수정
3. `repository/` → 필요한 쿼리 메서드 추가
4. `service/` → 비즈니스 로직 구현
5. `controller/` → API 경로 및 메서드 수정
6. `application.yml` → 운영 DB 설정으로 교체

## DB 변경 (H2 → MySQL)

`build.gradle.kts`에 의존성 추가:
```kotlin
runtimeOnly("com.mysql:mysql-connector-j")
```

`application.yml` 변경:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/sampledb
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: your_password
  jpa:
    hibernate:
      ddl-auto: validate
```
