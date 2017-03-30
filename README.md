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