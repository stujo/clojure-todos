# Clojure Lists

* [http://clojuredocs.org/clojure.core/list](http://clojuredocs.org/clojure.core/list)

Thinking...
> Implemented as a linked list, so performant in situations where the items are added and removed from the sequence

```clojure
(1 2 3)
=> (1 2 3)
```

```clojure
(list 1 2 3)
=> (1 2 3)
```

```clojure
todo.core=> (cons 1 '(2 3 4 5 6))
(1 2 3 4 5 6)
todo.core=> (cons 1 (list 3))
(1 3)
```

```clojure
todo.core=> (cons (1) (2 3 4 5 6))

ClassCastException java.lang.Long cannot be cast to clojure.lang.IFn  todo.core/eval1398 (form-init4602003227947088863.clj:1)
```
This is because it's trying to evaluate ``2`` as a function, we have to quote the list literal or build it 

```clojure
todo.core=> (cons 1 '(2 3 4 5 6))
(1 2 3 4 5 6)
todo.core=> (cons 1 (list 2 3 4 5 6))
(1 2 3 4 5 6)
```



