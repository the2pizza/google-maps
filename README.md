# google-maps

A Clojure library designed to operate Google Maps API through official SDK

## Usage

```
    [lowl4tency/google-maps "0.1.0-SNAPSHOT"]

```

```
    (:require [google-maps.core :as m])
```

### List of functions:

       (m/address->coordinates context address)
       returns {:lat Num, :lng Num, :address Str, :city Str, :country Str}

       (m/coordinates->address context Lat Lng)
       returns {:address Str, :city Str, :country Str}

       (m/distance context Address1 Address2)
       returns {:distance Num  ;meters
                :duration Num} ;seconds
```

## License

Copyright © 2016 8ll

Distributed under the MIT License either version 1.0 or (at
your option) any later version.
