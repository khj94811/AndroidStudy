# Flash

- Service

    - Service는 안드로이드의 4대 컴포넌트 중 하나로, 화면이 없고 백그라운드에서 수행하는 작업을 작성하는 컴포넌트이다.
    
    - Flash를 켜는 기능에 화면이 꼭 필요하지는 않다.
    
    - 이런 경우에는 서비스에서 Flash를 켜고 끄도록 하고, 액티비티는 서비스를 호출하는 방법을 사용한다.
    
    ![Sevice_LifeCycle](https://developer.android.com/images/service_lifecycle.png)
    
    - onStartCommand() 메서드의 반환 값으로 이 값에 따라서, 시스템이 강제로 종료한 후에 시스템 자원이 회복되어 다시 서비스를 시작할 수 있을 때 어떻게 할지 결정
        - START_STICKY : null 인텐트로 다시 시작 (명령을 실행하지는 않지만 무기한으로 실행중), 작업을 기다리고 있는 미디어 플레이어
        - START_NOT_STICKY : 다시 시작하지 않음
        - START_REDELIVER_INTENT : 마지막 인텐트로 다시 시작, 능동적으로 수행중인 파일 다운로드와 같은 서비스
        
    - 일반적으로 START_STICKY 반환
    
- 구조

    - 해당 App에서의 구조는 아래와 같다.
    
        - 기존 구조는 Activity -> Torch Class
        
        - 여기서는 Activity -> Service -> Torch Class
        
- App Widget

    - Placement
        - Home-screen only
            - 홈 화면에만 배치 가능
        - Home-screen and Keyguard
            - 홈 화면과 잠금 화면에 배치 가능
        - Keyguard only (API 17+)
            - 잠금 화면에만 배치 가능
    
    - Resizable (API 12+)
        - Horizontally and vertically
            - 가로와 세로 크기 변경 가능
        - Only horizontally
            - 가로로만 크기 변경 가능
        - Only vertically
            - 세로로만 변경 가능
        - Not resizable
    
    - Minimum Width (cells)
        - 가로 크기 1~4 중 선택
        
    - Minimum Height (cells)
        - 세로 크기 1~4 중 선택
        
    - Configuration Screen
        - Widget 의 환경설정 액티비티를 생성
    
    - setOnClickPendingIntent
        - Click 이벤트를 연결
        - Pending Intent는 실행할 인텐트의 정보를 가지고 있다가 수행해준다.
        - PendingIntent.getActivity()
            - Activity 실행
        - PendingIntent.getService()
            - Service 실행
        - PendingIntent.getBroadcast()
            - Broadcast 실행
    
    - PendingIntent.getService()
        - 인자
            - 컨텍스트, 리퀘스트 코드, 서비스 인텐트, 플래그
        - Widget을 클릭하면 서비스가 시작된다.