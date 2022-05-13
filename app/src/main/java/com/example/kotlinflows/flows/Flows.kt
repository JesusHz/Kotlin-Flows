package com.example.kotlinflows.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
//    val numberListAsFlow = listOf(1, 2, 3, 4, 5).asFlow()
//        .filter { it % 2 == 0 }
//        .collect {
//            println(it)
//        }
//    val numberListFlowOf = flowOf(1, 2, 3, 4, 5)
//        .map { "Value is $it" }
//        .collect {
//            println(it)
//        }
//    val makeFlow = makeFlow()
//        .transform {
//            emit(it * 2)
//        }
//        .collect { number ->
//            println(number)
//        }

//    val flowOne = flowOf("uno", "dos", "tres", "cuatro", "cinco")
//    val flowTwo = flowOf(1, 2, 3, 4, 5)
//
//    flowOne.zip(flowTwo) { one, two ->
//        println("$one = $two")
//    }.collect {
//        it
//    }
}

fun makeFlow() = flow {
    for (i in 0..10) {
        delay(1000)
        emit(i) //suspend function
    }
}