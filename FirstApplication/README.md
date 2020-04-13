# Chapter 1

### 문자열을 Resource화 하기

- textView를 하나 만들게 되면, Component Tree에 경고 아이콘이 뜬다.

- 경고 아이콘을 누르고 fix를 클릭하게 되면, 해당 문자열을 Resource화 하도록 도와준다.

### 다국어 추가하기

- strings.xml 파일에서 Open editor를 클릭하면 Translations Editor가 표시된다.

- 좌측 상단의 Add Locale 아이콘을 클릭하면 추가할 언어를 선택하는 Dropdown List가 표시된다.

- 이 곳에서 해당 언어를 선택하면 된다.

### AppCompatActivity Class

- MainActivity Class는 AppCompatActivity Class를 상속받고 있다.

- 하위 호환을 가능하게 하기 위해서는 반드시 이 클래스를 상속받아야 한다.

### onCreate() Method

- Activity가 시작되면 최초로 호출되는 메서드

- 해당 메서드를 Override하여 코드를 작성해야한다.

- onCreate() 메서드에서는 반드시 부모 클래스의 생성자를 호출해야한다.

### setContentView() Method

- Activity가 표시할 Layout file을 지정한다.

- R.layout.activity_main 은 res/layout/activity_main.xml 파일을 가리킨다.

- 리소스 (레이아웃, 메뉴, 그림, 문자열 등)은 모두 R Class를 사용하여 Code에서 조작할 수 있다.

### 단축키 [Ctrl + E]

- Recent Files를 보여준다.