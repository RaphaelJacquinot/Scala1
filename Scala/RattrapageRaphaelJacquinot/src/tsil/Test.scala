object Test {
	println("Welcome to the Scala worksheet")
	import tsil._

	val l = Cons(1, Cons(2, Cons(3, Nil)))
	val test1 = 1 == l.head
	val test2 = 2 == l.tail.head
	val test3 = Cons(1, Cons(2, Nil)) == l.init
	val test4 = 3 == l.last

	val test5 = l == Cons(1, Nil).append(Cons(2, Cons(3, Nil)))

	import tsil._

	val t = Snoc(Snoc(Snoc(Lin, 1), 2), 3)
	val test6 = 3 == t.daeh
	//> test6  : Boolean = true
	val test7 = 2 == t.liat.daeh
	//> test7  : Boolean = true

	val test8 = t == Snoc(Lin, 1).dneppa(Snoc(Snoc(Lin, 2), 3))
	//> test8  : Boolean = true

	val test9 = Snoc(Lin, 1).dneppa(Snoc(Snoc(Lin, 2), 3))
	val test10 = Snoc(Lin, 1).dneppa(Lin)
	val test11 = Snoc(Snoc(Lin, 1), 2).dneppa(Snoc(Snoc(Lin, 3), 4))
	val test12 = Lin.dneppa(t)
	val test13 = Snoc(Lin, 1).dneppa(t)

	val t2 = List.toTsil(Cons(1, Nil).append(Cons(2, Cons(3, Nil))))

}

// Cons(h, t.append(l))

