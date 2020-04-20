# Android Study

- 옛날에 Kotlin 공부한다고 Android 공부했는데 다까먹었다.

- 처음부터 다시 공부하자.

- 오준석의 안드로이드 생존코딩 : 코틀린 편 을 기반으로 공부 진행

    - https://github.com/junsuk5/kotlin-android

![Android Life Cycle](https://developer.android.com/guide/components/images/activity_lifecycle.png)

- Android 4대 Component

    - Activity
        - 화면을 구성한다.
    - Contents Provider
        - Database, File, Network의 데이터를 다른 앱에 공유한다.
    - Broadcast Receiver
        - 앱이나 기기가 발송하는 방송을 수신한다.
    - Service
        - 화면이 없고 백그라운드 작업에 용이

- Provider를 이용하여 사진 정보를 가져오는 순서

    1. 외부 저장소 읽기 권한을 앱에 부여한다.
    2. 외부 저장소 읽기 권한은 위험 권한이기 때문에 사용자에게 권한을 허용하도록 한다.
    3. contentResolver 객체를 이용하여 데이터를 Cursor 객체로 가지고 온다.

- 안드로이드 저장소
    
    - 내부 저장소
        - OS가 설치된 영역으로, 유저가 접근할 수 없는 시스템 영역.
        - 앱이 사용하는 정보와 데이터베이스가 저장
    
    - 외부 저장소
        - 컴퓨터에 기기를 연결하면 저장소로 인식되며 유저가 사용하는 영역
        - 사진이나 동영상 등.

    - 기기의 사진 경로 얻기
    
        ``` kotlin
            val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null,
            null,
            null,
            MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC")
        ```
        - 각 라인별 분석

        1. 어떤 데이터를 가져오는지 URI 형태로 지정
            - 외부 저장소에 저장된 데이터를 가리키는 URI가 EXTERNAL_CONTENT_URI
        2. 어떤 항목의 데이터를 가져올 것인지 String 배열로 저장
        3. 데이터를 가져올 조건 지정 (null은 전체 데이터)
        4. 세 번째 인자와 조합하여 조건 지정
        5. 정렬 방법 지정