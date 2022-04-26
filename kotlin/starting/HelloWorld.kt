fun main(args: Array<String>) { 
    //println("Hello, World!") 
    val items = listOf(1, 2, 3, 4)    
    for (i in items) println("hello " + i)
}

// compile kotlin
// kotlinc helloWorld.kt -include-runtime -d helloWorld.jar
// java -jar helloWorld.jar

// to install kotlin
// curl -s "https://get.sdkman.io" | bash
// source "$HOME/.sdkman/bin/sdkman-init.sh"
// sdk install kotlin