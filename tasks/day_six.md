```
given: A super parking boy manager two parking lots, A has 2 available space and B has 1 available space, Both A and B has 3 lots.
when:  when the super parking boy parking a car
then:  return a ticket, and can park in A parking lots. 
```

```
given: A smart parking boy manager two parking lots, A has 2 available space and B has 2 available space, Both A and B has 3 lots.
when:  when the super parking boy parking a car
then:  return a ticket, and can park in A parking lots. 
```

```
given: A smart parking boy manager two parking lots, A has 1 available space and B has 2 available space, A has 2 lots and B has 5 lots.
when:  when the super parking boy parking a car
then:  return a ticket, and can park in A parking lots. 
```

```
given: Customer has a valid ticket
when:  when the super parking boy pick up a car
then:  parking boy help you to pick up the car
```

```
given: customer has a invalid ticket
when:  when the super parking boy pick up a car
then:  parking boy cant't help you to pick up the car and throw InvalidTicketException
```

```
given: customer has no ticket
when:  when the super parking boy pick up a car
then:  parking boy cant't help you to pick up the car and throw NoTicketException
```

```
given: customer has valid ticket
when:  when the super parking boy pick up a car twice
then:  parking boy cant't help you to pick up the car and throw InvalidTicketException at second times
```