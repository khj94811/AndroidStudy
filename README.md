# Android Study

- 옛날에 Kotlin 공부한다고 Android 공부했는데 다까먹었다.

- 처음부터 다시 공부하자.

- 오준석의 안드로이드 생존코딩 : 코틀린 편 을 기반으로 공부 진행

    - https://github.com/junsuk5/kotlin-android
    
## Kotlin의 기본 구문

- 기본 구문

    - 변수
        - var a : Int = 10
        - 값을 변경할 수 있다.
    - 상수
        - val b : Int = 20
        - 값을 변경할 수 없다.

    - 함수
        ``` kotlin
            fun greet(str: String): Unit {
                println(str)
            }
        ```
        - Method VS Function

            - Method는 객체와 관련된 함수를 의미한다.

            - 함수는 조금 더 일반적인 용어로, 모든 메서드는 함수이다.

- 기본 자료형

    - 자바는 Primitive 자료형과 Object 자료형이 분류되지만, Kotlin의 기본 자료형은 모두 객체이다.

    - 숫자형
        - Double
        - Float
        - Long
        - Int
        - Short
        - Byte

    - 문자형
        - String
        - Char
        - 문자열 비교는 ==를 사용한다.

    
    - 배열
        - Array라는 별도의 타입으로 표현
        ``` kotlin
            val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)
        ```

- 제어문

    - if 문
    
    - when 문

        - Java의 switch문에 대응한다.
        
        ``` kotlin
            val x = 1
            when(x) {
                1 -> println("x == 1")
                2, 3 -> println("x == 2 or x == 3")
                4..7 -> println("4부터 7사이)
            }
            else -> {
                println("x 는 1이나 2가 아님)
            }
        ```

        - when 문의 결과를 함수의 반환값으로 사용할 수 있다.

        ``` kotlin
            val number = 1
            
            fun isEven(num : Int) = when(num % 2) {
                0 -> "짝"
                else -> "홀"
            }
            
            println(isEven(number))
        ```

    - for 문

        - 배열이나 컬렉션을 순회

        ``` kotlin
        for (i in 1..3){
        }

        for (i in 0..10 step 2){
        }

        for (i in 10 downTo 0 step 2){
        }
        ```

    - while 문

    - Class

        ``` kotlin
            // Class 선언
            class Person{

            }
            
            // Instance 생성
            val person = Person() 
            
        ```

        - Constructor

            ``` kotlin
                class Person {
                    constructor(name: String){
                        println(name)
                    }
                }
            ```
            ``` kotlin
                class Person(name: String) {
                    init{
                        println(name)
                    }
                }
            ```
            - 생성자 이외에도 init block에서 작성한 코드가 클래스를 인스턴스화 할 때 가장 먼저 초기화된다.

    - Property

        - Class의 속성을 사용할 때에는 멤버에 직접 접근하며, 이를 Property라고 한다.

        - Java에서는 private 접근 지정자로 은닉화된 멤버 변수에 Get / Set Method를 사용해서 접근하는 방식이 일반적이다.

        - 하지만, Kotlin은 Getter / Setter 를 Property가 대체한다.

    - 접근 제한자

        - Public
        
        - Private

        - Protected

        - Internal

    - 상속

        - Kotlin 에서의 Class는 기본적으로 상속이 금지된다.

        - 만약 상속이 가능하게 하려면, Open Keyword를 Class 선언 앞에 추가해야 한다.

        ``` kotlin
            open class Animal {

            }

            class Dog : Animal(){

            }
        ```

        - 만약 상속받은 Class가 생성자가 있다면,

        ``` kotlin
            open class Animal(val name: String) {

            }

            class Dog(name: String) : Animal(name){
                // ...
            }
        ```