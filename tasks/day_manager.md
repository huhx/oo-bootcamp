```
given: A manager has parking boys, and parking lots has available space
when:  when the customer parking a car
then:  return a ticket and car can be parked.
```

```
given: A manager dont' have parking boys, and parking lots has available space
when:  when the customer parking a car
then:  return a ticket and car can be parked.
```

```
given: A manager has parking boys, and parking lots don't have available space
when:  when the customer parking a car
then:  throw NoAvailableException and car cant' be parked.
```

```
given: customer has a valid ticket
when:  when the customer pick up a car
then:  manager can help you to pick up the car
```

```
given: customer has a invalid ticket
when:  when the customer pick up a car
then:  manager cant't help you to pick up the car and throw InvalidTicketException
```

```
given: customer has a valid ticket
when:  when the customer pick up a car twice
then:  the second time throw InvalidTicketException
```

```
given: customer has no ticket
when:  when the customer pick up a car
then:  manager cant't help you to pick up the car and throw NoTicketException
```