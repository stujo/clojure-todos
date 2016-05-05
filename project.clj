(defproject todo "0.1.0-SNAPSHOT"
  :description "Todo App in Clojure - eventually"
  :url "http://github.com/stujo/clojure-todos"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot todo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
