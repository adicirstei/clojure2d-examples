(ns examples.NOC.introduction.randomwalktraditional2
  (:require [clojure2d.core :refer :all]
            [fastmath.core :as m]
            [fastmath.random :as r]))

(set! *warn-on-reflection* true)
(set! *unchecked-math* :warn-on-boxed)

(defn draw
  ""
  [canvas _ _ state]
  (let [[^double x ^double y] (or state [(* 0.5 ^int (width canvas))
                                         (* 0.5 ^int (height canvas))])
        stepx (dec (int (r/drand 3)))
        stepy (dec (int (r/drand 3)))
        nx (m/constrain (+ x stepx) 0 ^int (width canvas))
        ny (m/constrain (+ y stepy) 0 ^int (height canvas))]

    (-> canvas
        (set-color :white)
        (point nx ny))

    [nx ny]))

(show-window (canvas 200 200) "Random Walk - Traditional 2" draw)
