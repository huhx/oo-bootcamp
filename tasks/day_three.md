```
given: parking lots has available space
when: a car come in 
then: a car can come in and return a ticket
```

```
given: parking lots has no available space
when: a car come in 
then: a car can not come in
```

```
given: customer has a valid ticket
when: a customer want to pick up the car
then: the car can be pick up
```

```
given: customer has a invalid ticket
when: a customer want to pick up the car
then: the car can't be pick up
```