package example

import org.scalatest.FunSuite
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class implements a ScalaTest test suite for the methods in object
 * `Lists` that need to be implemented as part of this assignment. A test
 * suite is simply a collection of individual tests for some specific
 * component of a program.
 *
 * A test suite is created by defining a class which extends the type
 * `org.scalatest.FunSuite`. When running ScalaTest, it will automatically
 * find this class and execute all of its tests.
 *
 * Adding the `@RunWith` annotation enables the test suite to be executed
 * inside eclipse using the built-in JUnit test runner.
 *
 * You have two options for running this test suite:
 *
 * - Start the sbt console and run the "test" command
 * - Right-click this file in eclipse and chose "Run As" - "JUnit Test"
 */
 @RunWith(classOf[JUnitRunner])
  class ListsSuite extends FunSuite with Matchers {
 
  /**
   * Tests are written using the `test` operator which takes two arguments:
   *
   * - A description of the test. This description has to be unique, no two
   *   tests can have the same description.
   * - The test body, a piece of Scala code that implements the test
   *
   * The most common way to implement a test body is using the method `assert`
   * which tests that its argument evaluates to `true`. So one of the simplest
   * successful tests is the following:
   */
  test("one plus one is two")(assert(1 + 1 == 2))


  /**
   * In Scala, it is allowed to pass an argument to a method using the block
   * syntax, i.e. `{ argument }` instead of parentheses `(argument)`.
   *
   * This allows tests to be written in a more readable manner:
   */
  test("one plus one is three?") {
    assert(1 + 1 == 2) // This assertion fails! Go ahead and fix it.
  }


  /**
   * One problem with the previous (failing) test is that ScalaTest will
   * only tell you that a test failed, but it will not tell you what was
   * the reason for the failure. The output looks like this:
   *
   * {{{
   *    [info] - one plus one is three? *** FAILED ***
   * }}}
   *
   * This situation can be improved by using a special equality operator
   * `===` instead of `==` (this is only possible in ScalaTest). So if you
   * run the next test, ScalaTest will show the following output:
   *
   * {{{
   *    [info] - details why one plus one is not three *** FAILED ***
   *    [info]   2 did not equal 3 (ListsSuite.scala:67)
   * }}}
   *
   * We recommend to always use the `===` equality operator when writing tests.
   */
  test("details why one plus one is not three") {
    assert(1 + 1 === 2) // Fix me, please!
  }

  /**
   * In order to test the exceptional behavior of a methods, ScalaTest offers
   * the `intercept` operation.
   *
   * In the following example, we test the fact that the method `intNotZero`
   * throws an `IllegalArgumentException` if its argument is `0`.
   */
  test("intNotZero throws an exception if its argument is 0") {
    intercept[IllegalArgumentException] {
      intNotZero(0)
    }
  }

  def intNotZero(x: Int): Int = {
    if (x == 0) throw new IllegalArgumentException("zero is not allowed")
    else x
  }


  /**
   * Now we finally write some tests for the list functions that have to be
   * implemented for this assignment. We fist import all members of the
   * `List` object.
   */
  import Lists._


  /**
   * We only provide two very basic tests for you. Write more tests to make
   * sure your `sum` and `max` methods work as expected.
   *
   * In particular, write tests for corner cases: negative numbers, zeros,
   * empty lists, lists with repeated elements, etc.
   *
   * It is allowed to have multiple `assert` statements inside one test,
   * however it is recommended to write an individual `test` statement for
   * every tested aspect of a method.
   */

  // Sum of a few numbers
  test("sum of a few numbers") {
    assert(sum(List(1,2,0)) === 3)
  }

  // testing sum with positive and negative numbers
  test ("two plus three minus 5 is equal to zero"){
     assert(sum(List(2,3,-5)) == 0)
  }

  // testing maximum of a list of negative numbers
  test("minus one is the maximum of a negative number only list")
  {
    assert(max(List(-50,-23,-3,-1)) == -1)
  }
  // testing the max of a few positive numbers
  test("max of a few numbers") {
    assert(max(List(3, 7, 2)) === 7)
  }

  test("sum of a list of zeros")
  {
    assert(sum(List(0,0,0,0,0)) === 0)
  }

  // testing isNegative - returns an exception if the argument is positive or 0
  def isNegative(x: Int): Int = {
    if (x < 0) throw new IllegalArgumentException("The element is negative")
    else x
  }
  test("intNegative throws an exception if its argument is Positive or 0") {
    intercept[IllegalArgumentException] {
      isNegative(-5+4)
    }
  }


  // check if the list is empty
  def isListEmpty(list: List[Int]): Boolean = {
    if (list.isEmpty){
      return true
    }
    else return false
  }

  test ("check if the list is empty"){
  assert(isListEmpty(List()) == true)}


  test ("check if two sums with the same result but different numbers are equal"){
assert( sum(List(2,4,6,8)) === sum(List(30,-10)) )
  }
// its supposed to fail
  test ("check for distinct numbers on a list"){
    assert( (List(2,4,6,8,4).size) === (List(2,4,6,8,4).distinct.size) )
  }
}




