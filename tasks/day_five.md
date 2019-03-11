```
given: A smart parking boy manager two parking lots, A has 5 available space and B has 4 available space
when:  when the smart parking boy parking a car
then:  return a ticket, and can park in A parking lots. 
```

```
given: A smart parking boy manager two parking lots, A has 4 available space and B has 4 available space
when:  when the smart parking boy parking a car
then:  return a ticket, and can park in A or B parking lots. 
```

```
given: Customer has a valid ticket
when:  when the smart parking boy pick up a car
then:  parking boy help you to pick up the car
```

```
given: customer has a invalid ticket
when:  when the smart parking boy pick up a car
then:  parking boy cant't help you to pick up the car and throw InvalidTicketException
```

```
given: customer has no ticket
when:  when the smart parking boy pick up a car
then:  parking boy cant't help you to pick up the car and throw NoTicketException
```