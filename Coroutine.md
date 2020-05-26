# Coroutine

- CoroutineScope

  - Coroutine의 범위, Coroutine Block을 묶음으로 제어 할 수 있는 단위
  
  - Global Scope
    - Coroutine Scope의 한 종류로, 미리 정의된 방식으로 프로그램 전반에 걸쳐서 백그라운드에서 동작
    
- CoroutineContext
  
  - Coroutine을 어떻게 처리 할 것인지에 대한 여러가지 정보의 집합
  
  - 주요 요소
    - Job과 Dispatcher
    
- Dispatcher

  - CoroutineContext를 상속받아 어떤 쓰레드를 이용해서 어떻게 동작할 것인지를 미리 정의해 두었음.
  
  - Dispatcher의 용도
    - Dispatchers.Default
      - CPU 사용량이 많은 작업에 사용
      - 주 스레드에서 작업하기에는 너무 긴 작업에 알맞는다.
    - Dispatchers.IO
      - Network, Disk 사용 등에 사용
      - 파일을 읽고, 쓸 때
      - 소켓을 읽고, 쓸 때
      - 작업을 멈출 때
    - Dispatchers.Main
      - 안드로이드의 경우 UI 스레드 사용
      - Dispatchers.Main을 사용할 수 없는 플랫폼에서는 IllegalStateException 발생
    - Dispatchers.Unconfined
      - 다른 Dispatcher와는 달리 특정 스레드 / 스레드 풀을 지정하지 않음.
      - 특정 목적을 위해서 사용됨
