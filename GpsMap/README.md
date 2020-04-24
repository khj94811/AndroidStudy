# My Google Map

### Google API

- google_maps_api.xml 파일에 API 키 입력

- 주석에 있는 Link를 복사하여 들어가서 API 키를 받아오면 된다.

- 이 Key를 그대로 Commit, Push 하면 문제가 있으니, .gitignore에 등록하자

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

