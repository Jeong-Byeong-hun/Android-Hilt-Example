package com.example.hiltexample

class SubWay {
    fun makeSandwich() {
        //샌드위치 만들기
    }
}


class Bakery{
    fun makeCake(){

    }
}

class Worker {
    var bakery = Bakery()

    fun order() {
        bakery.makeCake()
    }
}


