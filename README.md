# Android Study

- 옛날에 Kotlin 공부한다고 Android 공부했는데 다까먹었다.

- 처음부터 다시 공부하자.

- 오준석의 안드로이드 생존코딩 : 코틀린 편 을 기반으로 공부 진행

    - https://github.com/junsuk5/kotlin-android

![Android Life Cycle](https://developer.android.com/guide/components/images/activity_lifecycle.png)

- Anko Library 추가

    - gradle (Module)
    ``` groovy
        dependencies {
            implementation "org.jetbrains.anko:anko:$anko_version"
        }
    ```
    - gradle (Project)
    ``` groovy 
        buildscript {
            ext.anko_version='0.10.8'
        }
    ```

- Glide Library 추가

    - gradle (Module)
    ``` groovy
        dependencies {
            implementation 'com.github.bumptech.glide:glide:4.11.0'
        }
    ```

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

- Fragment

    - 사용자 인터페이스 모음

    - Fragment 여러 개를 조합하여 액티비티 하나를 구성할 수 있다.

    - 한 번 작성한 Fragment는 재사용 하는 것이 가능하다.

    - Fragment의 생명주기

    ![Fragment LifeCycle](https://developer.android.com/images/fragment_lifecycle.png)

    - onAttach()

        - Activity에 붙을 때 호출 (Activity 참조 사용 가능)

    - onCreate()

        - Fragment를 생성할 때, 인자가 함께 넘어온다면 onCreate() 메서드에서 받아서 변수에 담음

        - 레이아웃 완성 전

    - onCreateView()

        - Fragment에 표시할 View를 Layout 파일로 부터 읽어옴

        - 완성된 뷰를 반환 

        - 레이아웃 완성 전

    - onActivityCreated()

        - Activity의 onCreate() 메서드가 수행된 직후 호출

    - onStart()

        - Fragment가 사용자에게 보여질 때 호출

    - onResume()

        - 사용자와 상호작용하기 시작
    
    - onPause()

        - Fragment가 일시 중지중이거나 더 이상 사용자와 상호작용 하지 않음

    - onStop()

        - Fragment가 중지됨.

    - onDestroyView()

        - Fragment가 해당 자원을 정리할 수 있도록 함

    - onDestroy()

        - Fragment가 파괴됨.

    - onDetach()

        - Fragment가 Activity에서 완전히 제거됨.

- ViewPager

    - Adapter

        - Item의 목록 정보를 가진 객체

        - Fragment를 Item으로 가지면서 ViewPager에 설정하는 Adapter

            1. FragmentPagerAdapter
                - Page 내용이 영구적일 때 적합
                - 한 번 로딩한 페이지는 메모리에 보관됨.
                - 많은 메모리를 사용

            2. FragmentStatePagerAdapter
                - 많은 수의 페이지가 있을 때 적합
                - 보이지 않는 페이지를 메모리에서 제거할 수 있음
                - 상대적으로 적은 메모리를 차지

            - 사진의 경우 다수의 페이지를 사용할 수 있으므로, FragmentStatePagerAdapter가 적합.
            
            