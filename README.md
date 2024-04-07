# Spring Boot + Security + JPA Example

이것은 Java로 작성된 Spring Boot 어플리케이션의 샘플입니다. Spring Security와 Spring Data JPA를 사용하여 구현한 백엔드 API 예제입니다.

## 개요

이 어플리케이션은 회원 및 게시물 관리를 위한 RESTful API를 제공합니다. 사용자 인증, 역할 기반 접근 제어 및 회원, 게시물 엔터티에 대한 CRUD 기능을 포함하고 있습니다.

## 사전 준비 사항

이 어플리케이션을 실행하기 전에 다음을 설치해야 합니다:

- Java Development Kit (JDK)  17 이상
- Gradle

## 사용법

1. Gradle을 사용하여 어플리케이션을 실행합니다.
2. 어플리케이션이 실행된 후에는 Postman이나 curl과 같은 도구를 사용하여 엔드포인트에 접근할 수 있습니다.

## 엔드포인트

### 회원 관리 (ROLE_ADMIN 권한 필요)

- **GET /api/v1/admin/members/{username}**: 특정 회원의 상세 정보를 조회합니다.
- **GET /api/v1/admin/members**: 모든 회원의 목록을 조회합니다.

### 회원 관리 (ROLE_USER 권한 필요)

- **POST /api/v1/members**: 새 회원을 생성합니다.
- **PUT /api/v1/members/{username}**: 기존 회원을 수정합니다.
- **GET /api/v1/members/{username}**: 특정 회원의 상세 정보를 조회합니다.

### 게시물 관리 (ROLE_ADMIN, ROLE_USER 권한 필요)

- **GET /api/v1/posts/{id}**: 특정 게시물의 상세 정보를 조회합니다.
- **GET /api/v1/posts**: 모든 게시물의 목록을 조회합니다.
-

## 보안 구성

보안 구성은 `SecurityConfig.java`에서 정의되어 있으며 다음과 같은 내용을 포함합니다:

- BCryptPasswordEncoder를 사용한 비밀번호 암호화 설정
- CSRF 보호를 비활성화하고 상태가 없는 세션을 사용하는 등의 HTTP 보안 규칙 정의
- 요청을 가로채고 인증 토큰을 추출하고 해당 토큰을 기반으로 사용자를 인증하는 `SecurityFilter` 클래스의 구현

## 구성 요소

### 보안 필터

`SecurityFilter` 클래스는 수신된 요청을 가로채고 인증 토큰을 추출하여 해당 토큰을 기반으로 사용자를 인증합니다. "/api" 경로 아래의 요청에 대해 실행되도록 설정되어 있습니다.

### 컨트롤러

- **MemberAdminController**: 회원 관리에 대한 관리 작업을 담당합니다.
- **MemberController**: 회원에 대한 기본 CRUD 작업을 관리합니다.
- **PostController**: 게시물 관리에 대한 기본 CRUD 작업을 관리합니다.

### 회원 엔터티

`Member` 클래스는 어플리케이션에서 사용되는 사용자 엔터티를 나타냅니다. Spring Security와의 통합을 위해 UserDetails 인터페이스를 구현하며 사용자명, 비밀번호, 닉네임, 역할, 활성화 상태 및 감사 필드 등의 속성을 포함하고 있습니다.

### 게시물 엔터티

`Post` 클래스는 어플리케이션에서 사용되는 게시물 엔터티를 나타냅니다. 게시물의 제목, 내용, 작성자 등의 속성을 포함하고 있습니다.

## Gradle 의존성

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-security'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    runtimeOnly 'com.h2database:h2'
}
```

위의 코드는 프로젝트에 필요한 Gradle 의존성을 정의하고 있습니다. 해당 의존성을 프로젝트의 build.gradle 파일에 추가해주세요.