# BMI Calculator

- Intent 부분 구현이 귀찮았는데, Anko Library를 쓰니까 쉽게 가능해서 좋았다.

- AndroidManifest.xml 부분에 parentActivity를 명시하여 뒤로가기 버튼을 만들어줄 수 있다.

``` groovy
    <activity
        android:name=".ResultActivity"
        android:parentActivityName=".MainActivity"></activity>
    <activity android:name=".MainActivity">
```

- PreferenceManager를 이용해서 데이터를 저장하고 불러올 수 있다.

    - This class was deprecated in API level 29.
Use the AndroidX Preference Library for consistent behavior across all devices. For more information on using the AndroidX Preference Library see Settings.

    - 위의 이유로 androidx.preference에서 불러와야했다.

- 아무튼 초반 내용이다 보니 좀 쉽다.