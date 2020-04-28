# Kotlin Style Guide

https://developer.android.com/kotlin/style-guide

## Case Naming Convention

- lowerCamelCase

  - 일반적으로 Camel Case라고 하면, Lower Camel Case를 의미한다.
  
  - 각 단어의 첫 문자를 대문자로 표현하되, 이름의 첫 문자는 소문자로 적는다.

- UpperCamelCase / PascalCase

  - 전체 이름의 첫 문자를 포함한 각 단어의 첫 문자를 대문자로 표시한다.
  
- snake_case

  - 각 단어 사이를 언더바(_) 로 구분해주는 표기법.
  
- Hungarian Notation

    - 이름 앖에 변수의 타입을 접두어로 넣어주는 표기법
    
    - 접두어의 종류
        - ch --> char
        - db --> double
        - str --> string
        - b --> boolean
  
## Kotlin Style

- Source File

  - 모든 소스 파일은 UTF-8로 인코딩되어야합니다.
  
- 이름 지정
  - 소스 파일에 최상위 클래스가 하나 뿐인 경우 파일 이름에 대소문자를 구분하는 이름과 .kt 확장자가 반영되어야 합니다. 그렇지 않고 소스 파일에 최상위 수준 선언이 여러 개 있는 경우 파일의 내용을 설명하는 이름을 선택하고 PascalCase를 적용한 다음 .kt 확장자를 추가합니다
