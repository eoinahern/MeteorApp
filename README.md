# MeteorApp
using nasa's data on all meteor collisions with earth since 2011

Broke down the application into 3 layers. Data, Domain, Presentation. this is essentially a variation on DDD. 


Data deals with the data pertaining to a list of meteor items. I used retrofit for my web calls and Realm for my database and 
cache. the first call uses the web and calls the nasa api with my key. Once the data is retrieved, It is stored in the realm db.
subsequent calls will access the realm db. I could of added a mapper class to the data layer to transform the entities between UI entities
and data entities. But this probably wasn't really needed for such a small app. I alos usead RXjava and android for simplified threading 
and its inbuilt observer pattern. 


Domain layer just contained the contract to the Repository class.In proper DDD this is the layer which i would of also placed my usecases
which contain no references to the android OS so the classes can be unit tested using junit.

Presentation layer used MVP a popular design pattern used on android to decouple view from business logic.
my presenter was injected into my view using dagger 2 DI. In turn, my repositiory was injected into the presenter. presenter is basically
used to delegate between the view and the model removing a lot of bloat from my fragments and activities. the view is basically a dumb
view layer that asks the presenter to perform operations for it. 





