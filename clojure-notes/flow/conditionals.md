Clojure Conditionals
--------------

# if
a or b

```clojure
todo.core=> (if true 10 20)
10
```

```clojure
todo.core=> (if false 10 20)
20
```

# when 
a or ``nil``

```clojure
todo.core=> (if true 10 20)
10
todo.core=> (if false 10 20)
20
todo.core=> (when true 10)
10
todo.core=> (when false 10)
nil
todo.core=> (when false 10 20)
nil
todo.core=> (when true 10 20)
20
```
