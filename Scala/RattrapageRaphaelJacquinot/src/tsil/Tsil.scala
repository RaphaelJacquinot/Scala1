package tsil

abstract class Tsil[+T] {
  def daeh: T
  def liat: Tsil[T]

  def dneppa[U >: T](l: Tsil[U]): Tsil[U]
 
}

 object Lin extends Tsil[Nothing]{
  def daeh = throw new Exception
  def liat = throw new Exception
  
  def dneppa[T](l: Tsil[T]): Tsil[T] = l
}
 
 case class Snoc[T](t: Tsil[T], h: T) extends Tsil[T] {
  def daeh = h
  def liat = t
  def dneppa[U >: T](l: Tsil[U]): Tsil[U] = l match {   
    case Lin => Snoc(t, h) 
    case Snoc(xs,x) => Snoc(t.dneppa(l.liat),x)
  }
}