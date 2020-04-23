# My Google Map

### Location Request 객체

- locationRequest : 위치 요청 객체

- locationCallback : 위치가 갱신되면 호출되는 Callback

- looper : 특정 Looper Thread를 지정

### Location Request

- PRIORITY_HIGH_ACCURACY : 가장 정확한 위치를 요청

- PRIORITY_BALANCED_POWER_ACCURACY : '블록' 수준의 정확도 요청

- PRIORITY_LOW_POWER : '도시' 수준의 정확도 요청

- PRIORITY_NO_POWER : 추가 전력 소모 없이 최상의 정확도 요청

- interval : 위치를 갱신하는데 필요한 시간

- fastestInterval : 다른 앱에서 위치를 갱신했을 때, 그 정보를 가장 빠른 간격으로 입력

    - 다른 앱에서 위치를 갱신했을 때, 그 정보를 가장 빠른 간격으로 입력