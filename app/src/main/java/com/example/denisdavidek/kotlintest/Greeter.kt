package com.example.denisdavidek.kotlintest

/**
 * Created by denisdavidek on 1/23/18.
 */
class Greeter(val name: String) {

    fun greet(): String{
        return name
    }

    fun max(a: Int, b: Int): Int {

        if (a>b) return a
        else return b
    }
}