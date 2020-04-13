# Kotlin의 기본 구문

- 작성하다 보니까 이걸 왜 쓰고있는건지 싶은데, 복습 차원에서 그냥 하자...

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

        - 만약 상속받은 Class가 생성자가 있다면, 아래와 같이.

        ``` kotlin
            open class Animal(val name: String) {

            }

            class Dog(name: String) : Animal(name){
                // ...
            }
        ```

    - Inner Class

        - inner 키워드를 사용하여 외부 클래스에 대한 참조를 가진 내부 클래스를 선언한다.

        ``` kotlin
            class Outer {
                var a = 10
                inner class InnerClass{
                    fun hello() {
                        a = 20
                    }
                }
            }
        ```

    - Abstract Class

        - 미구현 메서드가 포함된 클래스

        ``` kotlin
            abstract class A {
                abstract fun func()
                fun func2() {

                }
            }
        ```

- Interface

    - 미구현 메서드를 포함하여 클래스에서 이를 구현한다.

    - Abstract Class와 비슷하지만 Class는 단일 상속만 되는 반면에 Interface는 다중 구현이 가능하다.

    - Class에 동일한 속성을 부여해 같은 메서드라도 다른 행동을 할 수 있게 하는데 주로 사용한다.

    ``` kotlin
        open class Animal {
        
        }

        interface Runnable {
            fun run()
        }

        interface Eatable {
            fun eat()
        }

        class Dog : Animal(), Runnable, Eatable {
            override fun eat() {
                println("Eat")
            }
            override fun run() {
                println("Run")
            }
        }
    ```

- Nullable

    - Kotlin은 기본적으로 객체를 불변으로 보고 Null 값을 허용하지 않는다.

    - Null 값을 허용하려면 별도의 연산자가 필요하며, Null을 허용한 자료형을 사용할 때에도 별도의 연산자들을 사용하여 안전하게 호출해야한다.

    ``` kotlin
        val a : String          // Error !, 초기화 필요 
        val a : String = null   // Error !, Null이 허용되지 않음
        val a : String? = null  // OK !
    ```

- lateinit 과 lazy

    - lateinit
        - 초기화를 나중에 하는 경우가 생길 수 있다.
        - 초기화를 잊는다면 잘못된 null값을 참조하여 앱이 종료될 수 있으니 주의해야한다.

        ``` kotlin
            lateinit var a : String

            a = "hello"
        ```
    - lazy
        - lateinit이 var로 선언한 변수의 늦은 초기화라면, lazy는 val을 사용할 수 있다.
        - val 선언 뒤에 by lazy 블록에 초기화에 필요한 코드를 작성한다.
        - 값이 처음 호출될 때, 초기화 block의 코드가 실행된다.
        - 앱이 시작될 때 연산을 분산시킬 수 있다.
        - val 에서만 사용 가능하며, 조건이 적기 때문에 lateinit보다 편하게 사용할 수 있다.

        ``` kotlin
            val str : String by lazy {
                println("초기화")
                "hello"
            }
            println(str)    // 초기화가 실행된 후 hello
            println(str)    // hello만 실행
        ```

- Null 값이 아님을 보증

    - 변수 뒤에 !!를 추가하면, Null 값이 아님을 보증할 수 있다.

    ``` kotlin
        val name: String? = "안녕"

        val name2: String = name        // Error
        val name3: String? = name       // OK
        val name4: String = name!!      // OK
    ```

- 안전한 호출

    - Method 호출 시 dot(.) 연산자 대신, ?. 연산자를 사용하면 Null 값이 아닌 경우에만 호출이 된다.

    ``` kotlin
        val str: String? = null

        var upperCase = str?.toUpperCase    // null이기 때문에 호출되지 않음
    ```

- 엘비스 연산자

    - 안전한 호출 시 Null이 아닌 기본값을 반환하고 싶을 때, 엘비스 연산자를 함께 사용한다.
    
    ``` kotlin
        val str: String? = null

        var upperCase = str?.toUpperCase ?: "초기화"
    ```

- Collection

    - List
        ``` kotlin
            val foods: List<String> = listOf("F1", "F2", "F3")
            
            val foods = listOf("F1", "F2", "F3") // 형추론으로 자료형 생략이 가능하다.
        ```
    - mutableList

        - 요소를 변경하는 리스트 작성시에는 mutableListOf를 사용한다.
        
        ``` kotlin
            val foods = mutableListOf("F1", "F2", "F3")
            foods[1] = "H1"
        ```

    - Map

        - key와 value로 이루어진 키가 중복될 수 없는 자료구조

        - mapOf로 ReadOnly Map을, mutableMapOf로 수정 가능한 Map을 만들 수 있다.

        ``` kotlin
            val map = mapOf("a" to 1, "b" to 2, "c" to 3)
            val capital = mutableMapOf("한국" to "서울", "일본" to "도쿄")

            capital["미국"] = "워싱턴DC"
        ```

    - Set

- Lambda Expression

    - 람다식은 코드를 간결하게 해주지만, 디버깅이 어렵고 남발할 경우 가독성을 떨어뜨린다.

    ``` kotlin
        fun add(x: Int, y: Int) = x + y

        // 또는

        var add = { x: Int, y: Int -> x + y }
    ```

- SAM 변환

    - Kotlin에서는 추상 메서드 하나를 인수로 사용할 때에는 함수를 인수로 전달하면 편하다.

    - Method가 하나인 인터페이스를 구현할 때에는 대신 함수를 작성할 수 있다.

    - 이를 Single Abstract Method라고 한다.

    ``` kotlin
        // View.OnClickListener Interface에는 onClick 추상 메서드가 하나만 존재한다.
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

            }
        })
        // 이 때에는 이를 람다식으로 변경할 수 있다.
        button.setOnClickListener({ v: View? ->

        })
    ```

- 확장 함수

    - 확장 함수 기능을 통해서 쉽게 기존 클래스에 함수를 추가할 수 있다.

    ``` kotlin
        fun Int.isEven() = this % 2 == 0

        val a = 5
        val b = 6

        println(a.isEven())
        println(b.isEven())
    ```

- 형변환

    - to자료형() 메서드를 통해 변환이 가능하다.

    - 숫자 형태의 문자열을 숫자로 바꿀 때에는 Interger.parseInt(str)

    - class간 형변환을 하려면 as 키워드를 사용한다.
        - val animal = dog as Animal
    
- 형체크

    ``` kotlin
        val str = "hello"
        if (str is String){

        }
    ```

- 고차 함수

    - 함수의 인수로 함수를 전달하거나 함수를 반환하는 것이 가능하다.

    - 이를 고차 함수라고 부른다.

- 동반 객체

    - Companion Object

- let() 함수

    - 자기 자신을 인수로 전달하고 수행된 결과를 반환한다.

    - 자기 자신은 it로 참조

- with() 함수

    - 인수로 객체를 받고 블록에 리시버 객체로 전달한다.

    = 리시버 객체로 전달된 객체는 this로 접근할 수 있다.

- apply() 함수

    - 블록에 객체 자신이 리시버 객체로 전달되고, 이 객체가 반환된다.

    - 객체의 상태를 변화시키고, 그 객체를 다시 반환할 때 주로 사용한다.

- run() 함수

    - 