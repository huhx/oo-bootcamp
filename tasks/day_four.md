```
given: A parking boy manager three parking lots that has available spaces
when:  when customer parking a car
then:  parking boy help you to park the car and return a ticket
```

```
given: A parking boy manager three parking lots that has no available spaces
when:  when customer parking a car
then:  parking boy can't help you to park the car and return exception
```

```
given: Customer has a valid ticket
when:  when customer pick up his car
then:  parking boy help you to pick up the car and space is release
```

```
given: customer has a invalid ticket
when:  when customer pick up his car
then:  parking boy cant't help you to pick up the car
```