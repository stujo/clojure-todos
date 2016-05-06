Clojure Cheat Sheet - Exploring Clojure
--------------------------

These are my notes playing around with Clojure and it's syntax for the first time

#Useful Links
* [Source Code](https://github.com/clojure/clojure)
* [Docs](http://clojure.org/)
* ``$brew install leiningen`` - [http://leiningen.org/](http://leiningen.org/)
* Looks like [LISP](https://en.wikipedia.org/wiki/Lisp_(programming_language))!
* [http://clojure.org/api/cheatsheet](http://clojure.org/api/cheatsheet)

# DataTypes
  * [Lists](./datatypes/lists.md)
  * [Vectors](./datatypes/vectors.md)
  * [Sets](./datatypes/sets.md)
  * [Maps](./datatypes/maps.md)

# Control Flow

* [Loops](https://programming-pages.com/2012/01/23/loops-in-clojure/)
Recursion is the preferred approach, ``loop`` can be used to re-perform evaluation
Here ``index`` is assigned the value 10 and the second argument a ``statement`` is evaluated
The ``recur`` function causes the second argument to be evaluated again with ``index`` set to ``(- index 1)``
When ``(= index 0)`` the recursion stops and the value of ``index`` in this case ``0`` is returned
```clojure
(loop [index 10] ; initialize the recursion index == 10
  (if (= index 0) ; base case index == 0
    index ; base case return value
    (do ;perform in sequence
      (prn index)  ; we can perform a side effect
      (recur (- index 1))))) ; recurse into loop with new value for index
10
9
8
7
6
5
4
3
2
1
0
```


#Single and Double Quotes
Why is this false?

    (= "x" 'x')
    => false

Let's look

    'x'
    => x'

Weird huh? - What does a ``'`` do?

* [Quoting without confusion](https://blog.8thlight.com/colin-jones/2012/05/22/quoting-without-confusion.html)

What can of worms is this?

Let's take a look [http://www.braveclojure.com/organization/](http://www.braveclojure.com/organization/)

> when you give Clojure a symbol like map, it finds the corresponding var in the current namespace, gets a shelf address, and retrieves an object from that shelf for you—in this case, the function that map refers to. If you want to just use the symbol itself, and not the thing it refers to, you have to quote it. Quoting any Clojure form tells Clojure not to evaluate it but to treat it as data.

* unquoted
    todo.core=> inc
    => #object[clojure.core$inc 0x46aa81ba "clojure.core$inc@46aa81ba"]

* quoted
    todo.core=> 'inc
    => inc

* backtick quoted (syntax-quote) - Symbols are resolved
    todo.core=> `inc
    => clojure.core/inc

* unquoted - ``~`` bounces out of the current quote to allow evaluation

    `~inc
    => #object[clojure.core$inc 0x46aa81ba "clojure.core$inc@46aa81ba"]

    `(inc ~(+ 2 2))
    => (clojure.core/inc 4)

* Quoted values are of type ``clojure.lang.Cons`` and can be ``eval``'d

    (type `(inc ~(+ 2 2)))
    => clojure.lang.Cons

    (eval `(inc ~(+ 2 2)))
    => 5

* What is ``clojure.lang.Cons``?

Is this a ``symbol`` or just some kind of text?

Looks like ``clojure.lang.Symbol`` is something different but similar...

    todo.core=> (symbol "clojure.core" "foo")
    clojure.core/foo

    todo.core=> (eval (symbol "clojure.core" "foo"))
    CompilerException java.lang.RuntimeException: No such var: clojure.core/foo,     compiling:(/private/var/folders/83/cx_mytx15ks9dgdhbj4kxf9c0000gn/T/form-init4602003227947088863.clj:1:1) 

    todo.core=> (type (symbol "clojure.core" "foo"))
    clojure.lang.Symbol

    todo.core=> (eval  (symbol "clojure.core" "foo"))
    CompilerException java.lang.RuntimeException: No such var: clojure.core/foo, compiling:(/private/var/folders/83/cx_mytx15ks9dgdhbj4kxf9c0000gn/T/form-init4602003227947088863.clj:1:1) 



#Namespacing

Your clojure program is always in the ``current namespace`` which by default is ``user``
In our todo demo app the namespace for the ``lein repl`` is ``todo.core``

    (ns-name *ns*)
    => todo.core

* namespace
* symbol
* var
