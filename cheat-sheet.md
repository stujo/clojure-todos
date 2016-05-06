#Links
* [Source Code](https://github.com/clojure/clojure)
* [Docs](http://clojure.org/)
* ``$brew install leiningen`` - [http://leiningen.org/](http://leiningen.org/)
* Looks like [LISP](https://en.wikipedia.org/wiki/Lisp_(programming_language))!

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


#Namespacing

Your clojure program is always in the ``current namespace`` which by default is ``user``
In our todo demo app the namespace for the ``lein repl`` is ``todo.core``

    (ns-name *ns*)
    => todo.core

* namespace
* symbol
* var
