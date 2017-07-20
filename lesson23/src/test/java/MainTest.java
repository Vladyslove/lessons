import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class MainTest {
  @Test
  public void testFactorial() {
    assertThat(factorial(0), is(1));
    assertThat(factorial(1), is(1));
    assertThat(factorial(2), is(2));
    assertThat(factorial(3), is(6));
    assertThat(factorial(4), is(24));
    assertThat(factorial(5), is(120));
  }

  @Test
  public void name() throws Exception {
    List <Integer>list = Arrays.asList(10, 20, 30, 40);
    //iterative style
    for (int i: list) {
      System.out.println(i);
    }

    // declarative style
     list.forEach(System.out::println);
    // the same is
//    list.forEach((i) -> System.out.println(i));
// Здесь (след. 8-10 строк) описано все, что происходит со строкой выше (с лямбдой)
//      Consumer<Integer> c = new Consumer<Integer>() {
//          @Override
//          public void accept(Integer i) {
//              System.out.println(i);
//          }
//      };
//      c.accept(list.get(0));
      // и 2 ВАРИАНТ если заменить создание нового объекта Consumer на лямбда выражение
//      Consumer<Integer> c = i -> System.out.println(i);
//      c.accept(list.get(0));
      System.out.println();
      
      // RECOMMENDED TO PRACTISE AT HOME
        Optional<Integer> firstEven = list.stream()
              .filter(i -> i % 2 == 0)
              .findFirst();
        System.out.println(firstEven.orElse(-1));

  }
  @Test
  public void testrecursivefactorial() {
      assertThat(recursiveFactorial(0), is(1));
      assertThat(recursiveFactorial(1), is(1));
      assertThat(recursiveFactorial(2), is(2));
      assertThat(recursiveFactorial(3), is(6));
      assertThat(recursiveFactorial(4), is(24));
      assertThat(recursiveFactorial(5), is(120));
  } 
  
  @Test
  public void testTailrecursivefactorial1() {
      assertThat(tailRecursiveFactorial(0), is(1));
      assertThat(tailRecursiveFactorial(1), is(1));
      assertThat(tailRecursiveFactorial(2), is(2));
      assertThat(tailRecursiveFactorial(3), is(6));
      assertThat(tailRecursiveFactorial(4), is(24));
      assertThat(tailRecursiveFactorial(5), is(120));
  }

  @Test
  public void testTailrecursiveFactorial2() {
    assertThat(tailRecursiveFactorial2(0, 1), is(1));
    assertThat(tailRecursiveFactorial2(1, 1), is(1));
    assertThat(tailRecursiveFactorial2(2, 1), is(2));
    assertThat(tailRecursiveFactorial2(3, 1), is(6));
    assertThat(tailRecursiveFactorial2(4, 1), is(24));
    assertThat(tailRecursiveFactorial2(5, 1), is(120));
  }

  // this is how tail recursion could look like (not implemented in Java)
  private int tailRecursiveFactorial(int n, int...prevElem) { //varArgs
      int p = (prevElem.length > 0) ? prevElem[0] : 1;
      return (n < 2) ? p : tailRecursiveFactorial(n - 1, n * p);
  }

  // another example of tail recursion (not implemented in Java)
  int tailRecursiveFactorial2(int n, int acc) {
    if (n == 0) {
      return acc;
    } else {
      return tailRecursiveFactorial2(n - 1, acc * n);
    }
  }

  private int recursiveFactorial(int n) {
    if (n == 0) {
      return 1;
    }
    return n * recursiveFactorial(n-1);
  }

  private int factorial(int n) {
    if (n == 0) {
      return 1;
    }
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }

    return result;
  }

  @Test
  public void testFib() throws Exception {
    assertThat(fib(0), is(0));
    assertThat(fib(1), is(1));
    assertThat(fib(2), is(1));
    assertThat(fib(3), is(2));
    assertThat(fib(4), is(3));
    assertThat(fib(5), is(5));
    assertThat(fib(6), is(8));
    assertThat(fib(7), is(13));
  }

  private int fib(int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    return fib(n - 1) + fib(n - 2);
    }
  }

