when: parking lot station has available lot
given: a car come in 
then: a car can come in

given: a car come in 
when: parking lot station has no available lot
then: a car can not come in

given: a customer want to pick up the car
when: he has a valid ticket
then: the car can pick up

given: a customer want to pick up the car
when: he does not have a valid ticket
then: the car can not pick up