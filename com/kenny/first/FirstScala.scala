package com.kenny.first

import java.util.{Date, Locale}
import scala.util.control.Breaks._

object FrenchDate {
  def main(args: Array[String]) {
    println("Select an option:")
    println("\t1) Say \"Good morning\"")
    println("\t2) Say \"Good afternoon\"")
    println("\t3) Say \"Good night\"")
    breakable {
      while(true) {
        print("Your choice (0 to exit): ")
        try {
          val myChoice = scala.io.StdIn.readInt()
          
          if (myChoice == 0) {
            break
          }
      
          def func() = myChoice match {
            case 1 => exec(sayMorning)
            case 2 => exec(sayAfternoon)
            case 3 => sayNight
            case _ => sayError
          }
          run(func, exec)
        }catch {
          case e: java.lang.NumberFormatException => {
            sayError
            // e.printStackTrace()
          }
        }
      }
    }
    println("Bye-bye!")
  }
  
  def exec(func:()=>Unit) = func()
  def run(func:()=>Unit, func1:(()=>Unit)=>Unit) = func1(func)
  
  def sayMorning() { println("Good morning, my friend!") }
  def sayAfternoon() { println("Good afternoon, my friend!") }
  def sayNight() { println("Good night, my friend!") }
  def sayError() { println("Input error, my friend!") }
}