package tsil

abstract class List[+T] {
  def head: T
  def tail: List[T]
  def init: List[T]
  def last: T
  def append[U >: T](l: List[U]): List[U]
  def toTsil[U >: T](t: List[U], h: T): Tsil[U]
}

object Nil extends List[Nothing] {
  def head = throw new Exception
  def tail = throw new Exception
  def init = throw new Exception
  def last = throw new Exception

  def append[U](l: List[U]): List[U] = l
  def toTsil[U](t: List[U], h: U): Tsil[U] = Lin
}

case class Cons[T](h: T, t: List[T]) extends List[T] {
  def head = h
  def tail = t
  def init = t match {
    case Cons(x, xs) => Cons(h, t.init)
    case Nil         => Nil
  }

  def last = t match {
    case Nil => h
    case xs  => xs.last
  }

  def append[U >: T](l: List[U]): List[U] = Cons(h, t.append(l))
  def toTsil[U >: T](t: List[U], h: U): Tsil[U] = Snoc(toTsil(t, t.head), h)
}