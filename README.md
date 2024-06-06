# dgn-workshop

## introduction to functional programming

### Purity

```java
int add(int a, int b) {
    return a + b;
}

int getTen() {
    final int ten = 10; // const in js
    return ten;
}
```

* don’t modify the input parameters
* don’t modify any external variables neither
* idempotence: pure functions can be called over and over and will always return the same result
* no side effects
* thread-safe
* no variables, just constants

### Impurity

examples

```java
var x = 1;

x =x +1;
x +=1;
x++;
// real functional programming has no loops, just recursion

void saveFile(File file) {
    // modify harddrive contents
}


@Inject
EntityManager em;

@Transactional
void updateCustomerName(long id, String name) {
    var c = this.em.find(id, Customer.class);
    c.setName(name);
}

```

## Introduction CDI

### Contexts and Dependency Injection

CDI-managed beans are contextual and EJB beans are not. Managed beans in CDI live in well-defined scope.
They are created and destroyed on demand by the container.
CDI comes already with pre-defined scopes and annotations:
@RequestScoped, @SessionScoped, @ApplicationScoped, and @ConversationScoped.

stateful EJBs have to be manually removed, CDI beans are destroyed and garbage-collected once the context is finished.