(ns example.server-handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as response]))

;; If you are new to using Clojure as an HTTP server please take your
;; time and study ring and compojure. They are both very popular and
;; accessible Clojure libraries.

;; --> https://github.com/ring-clojure/ring
;; --> https://github.com/weavejester/compojure

;(def artists(atom 6))
;
;(defn album_data [artist album]
;  (response {:artist artist :album album}))

(defn get_album [artist album]
  (println artist album)
  (str "From server with love: "artist album))


(defroutes app-routes
  ;; NOTE: this will deliver all of your assets from the public directory
  ;; of resources i.e. resources/public
  (route/resources "/" {:root "public"})
  ;; NOTE: this will deliver your index.html
  (GET "/" [] (-> (response/resource-response "index.html" {:root "public"})
                  (response/content-type "text/html")))
  (GET "/hello" [] "Hello World!")
  (GET "/album/:artist/:album" [artist album] (get_album artist album))

  (route/not-found "Not Found"))

(def app (wrap-defaults app-routes site-defaults))

;; this development application has a var reference to the app-routes above
;; for friendlier REPL based reloading
(def dev-app (wrap-defaults #'app-routes site-defaults))
