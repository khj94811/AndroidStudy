# Custom Web Browser

- Plain Text Attributes

    - inputType
        - Edit Text를 클릭하여 키보드가 표시될 때, 적절한 키보드 배열을 표시한다.

    - imeOptions
        - Keyboard의 Enter Icon을 변경해준다.

- AndroidManifest에 Internet Permission 추가
```
    <uses-permission android:name="android.permission.INTERNET"/>
```

- WebView

    - WebView를 사용할 때 기본으로 해야하는 설정

        1. javaScriptEnabled 기능을 켜야한다.

        2. WebViewClient 클래스를 지정해야 웹뷰에 페이지가 표시된다.

- Menu

    - File --> New --> Android Resource Director 에서 Resource Type을 Menu로 선택하고 OK

    - 팔레트 창에서 Menu Item을 선택하여 Component Tree의 Menu 아래 배치할 수 있다.