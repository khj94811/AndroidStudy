# Stop Watch

- Android에는 UI를 조작하는 Main Thread와 오래 걸리는 작업을 보이지 않는 곳에서 처리하는 Worker Thread가 존재한다.

- timer는 오래 걸리는 작업을 하는 Worker Thread에서 동작한다.

- Worker Thread는 UI를 조작할 수 없다.

    - 때문에 runOnUiThread() 메서드를 사용해야한다.

    - timer 내에서 runOnUiThread 를 이용하여 감싸준다.