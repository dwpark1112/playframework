# Play framework and Scala + Javascript로 간단한 게임 만들어보기

Scala 언어에 대한 문법을 간단하게 살펴보았으니, 다음은 Scala랑 잘 맞는 프레임워크를 배워보고 실제로 toy project를 해보면서 Javascript도 배워볼 목적으로 시작!

Play framework는 인텔리제이로 시작하니, 정말 간단하고 빠르게 `Hello world!`를 시작할 수 있음

## 어플리케이션 구조

- app -- 어플리케이션 소스 코드
  - controllers (Action method 등 Scala files)
  - views (Scala view template)
- conf -- 설정 파일과 데이터
  - application.conf
  - routes (HTTP URLs mapping)
- project -- 프로젝트 빌드 스크립트
- public -- 정적파일들
- test

## routes 

```
PUT /product/:ean        controllers.Products.update(ean: Long)
```

- route 파일에서 위에 있을수록 우선순위가 높다.
- 경로 매칭에서 `:` 대신에 `*`을 사용할 수 있다.
- route 동작
  - 요청 URL을 통해 구성된 경로를 비교하여 적절한 경로를 찾는다.
  - 타입에 특화된 바인더 중 하나를 사용하여 parameter를 바인딩한다.
  - 라우터는 controller의 action을 호출하고, parameter를 전달한다.

## database

**Configuration**

- `application.conf` 에서 아래 2줄 주석 해제 (H2 DB 사용)
  - db.default.driver=org.h2.Driver
  - db.default.url="jdbc:h2:mem:play"
- `build.sbt`에서 jdbc, anorm 추가
  - libraryDependencies ++= Seq( jdbc, cache , ws   , specs2 % Test, "com.typesafe.play" %% "anorm" % "2.4.0" )
  - anorm? <https://www.playframework.com/documentation/2.3.x/ScalaAnorm>
    - Anorm is Not an ORM
    - The release 2.4.0 of Anorm requires Java 8. The last version compatible with a JDK 1.6 or 1.7 is Anorm 2.3.9.

**Scheme & Model**

Anorm은 ORM이 아니기 때문에 사용자 모델에 대해서 모르고, 테이블을 직접 생성하지 못한다. 따라서, Play가 제공하는 evolution을 사용하여 스키마를 직접 생성해줘야 한다. 