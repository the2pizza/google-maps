# google-maps

A Clojure library designed to operate Google Maps API through official SDK

## Usage

    (require '[google-maps.core :as m])
    (m/defkey "API-KEY")
    (m/coordinates->a lat lng)
    (m/address->coordinates "ADDRESS")
    (m/distance "ADDRESS 1" "ADDRESS2")

## License

Copyright © 2016 8ll

Distributed under the MIT License either version 1.0 or (at
your option) any later version.
