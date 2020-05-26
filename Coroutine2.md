# Coroutine의 사용

- Coroutine은 아래와 같이 사용하면 된다.

  1. 사용할 Dispatcher를 결정한다.
  
  2. Dispatcher를 이용해서 CoroutineScope를 만든다.
  
  3. CoroutineScope의 Launch 또는 Async에 수행 할 코드 블록을 넘긴다.
  
  
- Launch와 Async
  
  - CoroutineScope의 확장함수
  
  - 넘겨 받은 코드 블록으로 Coroutine을 만들고 실행해주는 CoroutineBuilder
  
  - Launch는 Job 객체를 반환
  
  - Async는 Deferred 객체를 반환
  
  - 위 객체를 사용하여 아래의 작업을 할 수 있다.
  
    - 수행 결과를 받거나
    - 작업이 끝나기를 대기하거나
    - 취소 등의 제어
 
``` kotlin
    val scope = CoroutineScope(Dispatchers.Main)

    // Foreground 작업
    scope.launch {
    
    }

    // CoroutineContext를 변경하여 Background로 작업 전환
    scope.launch(Dispatchers.Default) {
    
    }
```

``` kotlin
    val scope = CoroutineScope(Dispatchers.Main)

    // 새로운 CoroutineScope로 동작하는 Background 작업
    CoroutineScope(Dispatchers.Default).launch {
    
    }
    // 기존 CoroutineScope는 유지하되, 작업만 Background로 처리
    scope.launch(Dispatchers.Default) {
    
    }
```
