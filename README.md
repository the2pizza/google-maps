# google-maps

[![CircleCI](https://circleci.com/gh/lowl4tency/google-maps/tree/master.svg?style=svg)](https://circleci.com/gh/lowl4tency/google-maps/tree/master)

A Clojure library designed to operate Google Maps API through official SDK

## Usage

```
    [lowl4tency/google-maps "0.3.0-SNAPSHOT"]

```

```
    (:require [google-maps.core :as m])
```

### List of functions:

       (m/make-context "API-KEY")
       returns GeoApiContext

       (m/latlng {:lat Num :lng Num})
       returns LatLng

       (m/address->coordinates context address)
       returns {:lat Num, :lng Num, :address Str, :city Str, :country Str}

       (m/coordinates->address context LatLng)
       returns {:address Str, :city Str, :country Str}

       (m/distance context {:a1 Str :a2 Str})
       returns {:distance Num  ;meters
                :duration Num} ;seconds
```

## License

Copyright © 2016 8ll

Distributed under the MIT License either version 1.0 or (at
your option) any later version.
